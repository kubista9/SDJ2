package server.mediator;

import com.google.gson.Gson;
import server.model.Exercise;
import server.model.Model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ExercisesClientHandler implements Runnable, PropertyChangeListener {

	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;
	private boolean running;
	private Gson gson;
	private Model model;

	public ExercisesClientHandler(Model model, Socket socket) throws IOException {
		this.socket = socket;
		this.model = model;
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out = new PrintWriter(socket.getOutputStream(), true);
		running = true;
		gson = new Gson();
		model.addListener(this);
	}

	public void close() throws IOException {
		socket.close();
	}

	@Override
	public void run() {
		System.out.println("ExercisesClientHandler Class is running....");

		try {
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream(), true);

			while (running) {
				String requestJson = in.readLine();
				ExercisePackage request = gson.fromJson(requestJson, ExercisePackage.class);

				if (request.getType().contentEquals("All")){
					ArrayList<Exercise> all = model.getAllExercises();
					ExerciseListPackage reply = new ExerciseListPackage("All", all);
					String replyJson = gson.toJson(reply);
					out.println(replyJson);
				}

				else if (request.getType().contentEquals("Add")){
					try {
						model.addExercise(request.getExercise());

					}
					catch (IllegalStateException e){
						ExercisePackage reply  = new ExercisePackage("Error", e.getMessage());
						String replyJson = gson.toJson(reply);
						out.println(replyJson);
					}
				}



				else if (request.getType().contentEquals("Remove")){
						Exercise exercise = model.removeExercise(request.getNumber());

					if (exercise == null){
						ExercisePackage reply  = new ExercisePackage("Error", "No exercise has been removed");
						String replyJson = gson.toJson(reply);
						out.println(replyJson);
					}
				}

				else if (request.getType().contentEquals("Get")){
						Exercise exercise = model.getExercise(request.getNumber());

					if (exercise == null){
						ExercisePackage reply  = new ExercisePackage("Error", "No such exercise found, exercise = " + exercise);
						String replyJson = gson.toJson(reply);
						out.println(replyJson);
					}
					else {
						ExercisePackage reply = new ExercisePackage("Get", exercise, exercise.getNumber());
						String replyJson = gson.toJson(reply);
						out.println(replyJson);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	@Override
	public void propertyChange(PropertyChangeEvent event) {
		ExercisePackage reply = new ExercisePackage(event.getPropertyName(), (Exercise) event.getNewValue(), (String) event.getOldValue());
		String replyJson = gson.toJson(reply);
		out.println(replyJson);
	}
}
