package server;
import com.google.gson.Gson;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TaskListCommunicatorThreadHandler implements Runnable, PropertyChangeListener {
	private BufferedReader in;
	private PrintWriter out;
	private String Ip;
	private TaskList taskList;
	private Socket socket;
	private Gson gson;
	private PropertyChangeListener propertyChangeListener;

	public TaskListCommunicatorThreadHandler(Socket socket, TaskList taskList) throws IOException {
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out = new PrintWriter(socket.getOutputStream(), true);
		Ip = "";
		this.taskList = taskList;
		this.socket = socket;
		gson = new Gson();
		taskList.addListener(this);
	}

	@Override
	public void run() {
		System.out.println("System is running...");

		while (true){

			try{
				String request = "";
				request = in.readLine();
				System.out.println("Client: " + request);

				if (request.contains("1")) {
					out.println("Add a task: ");
					System.out.println("Add a task");
					String task = in.readLine();

					//receiving unjsoned json
					System.out.println(task);
					Task newTask = gson.fromJson(task, Task.class);
					System.out.println("Message: " + newTask);

					taskList.add(newTask);
					out.println("Task is successfully added: ");
					System.out.println("Task is successfully added");
				}

				else if (request.contains("GET")){
					Task getTask = taskList.getAndRemoveNextTask();
					if (getTask == null ){
						out.println("Error");
					}
					else {
						String json = gson.toJson(getTask, Task.class);
						out.println(json);

					}
				}

				else if (request.contains("SIZE")){
					int taskListSize = taskList.size();
					out.println("SIZE" + taskListSize);
				}

				else if (request.contains("EXIT")){
					socket.close();
				}
			}

			catch (IOException e){
				e.printStackTrace();
			}

		}
	}

	@Override
	public void propertyChange(PropertyChangeEvent event) {
		System.out.println("Event name: " + event.getPropertyName());
		System.out.println("First value: " + event.getOldValue());
		System.out.println("Second value: " + event.getNewValue());
		out.println(event.getPropertyName());
	}
}
