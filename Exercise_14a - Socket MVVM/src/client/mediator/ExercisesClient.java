package client.mediator;
import client.model.Exercise;
import client.model.Model;
import com.google.gson.Gson;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Map;

public class ExercisesClient implements Model {
	private Model model;
	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;
	private Gson gson;
	private PropertyChangeSupport property;
	private ArrayList<Exercise> allExercises;
	private ArrayList<ExercisePackage> receivedPackages;

	public ExercisesClient(String host, int port) throws IOException {
		this.allExercises = null;
		this.receivedPackages = new ArrayList<>();
		this.gson = new Gson();
		this.property = new PropertyChangeSupport(this);
		this.socket = new Socket(host, port);
		this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		this.out = new PrintWriter(socket.getOutputStream(), true);
		ExercisesClientReader reader = new ExercisesClientReader(this,in);
		Thread t1 = new Thread(reader);
		t1.setDaemon(true);
		t1.start();
	}

	public void disconnect() throws IOException {
		in.close();
		out.close();
		socket.close();
	}

	public void received(String line){
//		if (line.contains("\"type\":\"All\""))
		if (gson.fromJson(line, Map.class).get("type").equals("All")){
			ExerciseListPackage reply = gson.fromJson(line,ExerciseListPackage.class);
			allExercises = reply.getExercises();
		}
		else {
			ExercisePackage reply = gson.fromJson(line, ExercisePackage.class);
			receivedPackages.add(reply);
			String type = reply.getType();
			if (type.equals("Add") || type.equals("Edit") || type.equals("Remove")){
				property.firePropertyChange(type, reply.getNumber(), reply.getExercise());
			}
		}
		notify();
	}

	@Override
	public synchronized ArrayList<Exercise> getAllExercises() {
		ExercisePackage request = new ExercisePackage("All",null,null);
		String requestJson = gson.toJson(request);
		out.println(requestJson);
		try {
			wait();
		}
		catch(InterruptedException e){
			//
		}
		return allExercises;
	}

	@Override
	public Exercise getExercise(String number) {
		ExercisePackage request = new ExercisePackage("Get",null, number);
		String requestJson = gson.toJson(request);
		out.println(requestJson);
		ExercisePackage exercisePackage = waitForReply("Get", number);
		return exercisePackage.getExercise();
	}

	@Override
	public Exercise removeExercise(String number) {
		ExercisePackage request = new ExercisePackage("Remove",null, number);
		String requestJson = gson.toJson(request);
		out.println(requestJson);
		ExercisePackage exercisePackage = waitForReply("Remove", number);
		return exercisePackage.getExercise();
	}

	@Override
	public void addExercise(Exercise exercise) {
		ExercisePackage request = new ExercisePackage("Add",exercise, null);
		String requestJson = gson.toJson(request);
		out.println(requestJson);
		ExercisePackage exercisePackage = waitForReply("Add", exercise.getNumber());
	}

	@Override
	public Exercise editExercise(String number, Exercise exercise) {
		ExercisePackage request = new ExercisePackage("Edit",exercise, number);
		String requestJson = gson.toJson(request);
		out.println(requestJson);
		ExercisePackage exercisePackage = waitForReply("Edit", exercise.getNumber());
		return exercisePackage.getExercise();
	}

	private synchronized ExercisePackage waitForReply(String remove, String number) {
		ExercisePackage received = null;
		boolean found = false;

		while (!found){
			while (receivedPackages.isEmpty()){
				received = receivedPackages.remove(receivedPackages.size()-1);
				found = (received.getError() != null || type.equals(received.getType()) && number.equals(received.getNumber()));
			}
			if (found){
				break;
			}
		}
		if (!found){
			try {
				wait();
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
		if (received.getError() != null){
			throw new IllegalStateException(received.getError());
		}
		return received;
	}

	@Override
	public void addListener(PropertyChangeListener listener) {
		property.addPropertyChangeListener(listener);
	}

	@Override
	public void removeListener(PropertyChangeListener listener) {
		property.addPropertyChangeListener(listener);
	}
}
