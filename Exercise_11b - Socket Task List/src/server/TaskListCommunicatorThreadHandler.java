package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TaskListCommunicatorThreadHandler implements Runnable{
	private BufferedReader in;
	private PrintWriter out;
	private String ip;
	private TaskList list;
	private Socket socket;

	public TaskListCommunicatorThreadHandler(Socket socket, TaskList list) throws IOException {
		this.socket = socket;
		this.list = list;
		this.out = new PrintWriter(socket.getOutputStream(),true);
		this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		this.ip = "";
	}

	@Override
	public void run() {
		while (true){
			System.out.println("System is running...");

			try{
				String request = "";
				request = in.readLine();
				System.out.println("Client: " + request);

				if (request.contains("ADD")) {
					out.println("Add a task: ");
					System.out.println("Add a task");
					String task = in.readLine();
					System.out.println("What is the estimated time?: ");
					int estimatedTime = in.read();
					list.add(new Task(task, estimatedTime));
				}

				if (request.contains("GET")){
					list.getAndRemoveNextTask();
					System.out.println("Task: " + list);
					out.println("Task" + list);
				}
				if (request.contains("SIZE")){
					System.out.println("Size: " + list.size());
				}
				if (request.contains("EXIT")){
					socket.close();
				}
			}

			catch (IOException e){
				e.printStackTrace();
			}

		}
	}
}
