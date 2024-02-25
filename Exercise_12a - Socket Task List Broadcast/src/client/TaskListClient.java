package client;
import com.google.gson.Gson;
import server.Task;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class TaskListClient {

	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;
	private Scanner input;
	private String receivedString;
	private TaskListClientReceiver taskListClientReceiver;
	private Gson gson;

	public TaskListClient(String host, int port) throws IOException {
		this.socket = new Socket(host, port);
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out = new PrintWriter(socket.getOutputStream(), true);
		input = new Scanner(System.in);
		receivedString = "";
		gson = new Gson();
		Thread t1 = new Thread(taskListClientReceiver);
		execute();
	}

	public void receive(String s) throws IOException, InterruptedException {
		if (s.contains("ADD") || s.contains("REMOVE")){
			System.out.println("Response: " + s);
		}
		else {
			receivedString = s;
			System.out.println("Received: " + receivedString);
			notify();
		}
	}

	public void execute() throws IOException {
		System.out.println("Starting the client...");

		while(true){
			System.out.println("1) ADD");
			System.out.println("2) GET");
			System.out.println("3) SIZE");
			System.out.println("4) EXIT");
			String response = input.nextLine();

			switch (response){
				case "1":
					//1
					System.out.println("What task to perform?: ");
					String task = input.nextLine();
					input.nextLine();

					//2
					System.out.println("What is the estimated time for" + task + " ?");
					int estimatedTime = input.nextInt();
					input.nextLine();

					//JSON PART
					Task newTask = new Task(task, estimatedTime);
					String json = gson.toJson(newTask);
					System.out.println(json);
					out.println(json);
					String responseTask = in.readLine();
					System.out.println(responseTask);
					break;

				case "2":
					System.out.println("Method GET: ");
					String get = input.nextLine();
					input.nextLine();
					break;

				case "3":
					System.out.println("Method SIZE");
					String size = input.nextLine();
					out.println(size);
					input.nextLine();
					break;

				case "4":
					System.out.println("Closing the server...");
					socket.close();
					break;
			}

		}
	}
}
