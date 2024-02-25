package client;

import server.Task;
import server.TaskList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.SQLOutput;
import java.util.Scanner;

public class TaskListClient {
	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;
	private Scanner input;
	private TaskList taskList;

	public TaskListClient(String host, int port) throws IOException {
		socket = new Socket(host, port);
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out = new PrintWriter(socket.getOutputStream(), true);
		input = new Scanner(System.in);
		taskList = new TaskList();
		execute();
	}

	public void execute(){
		System.out.println("Starting the client...");

		while (true){
			String response = "";

			try{
				System.out.println("Choose a task from following: ");
				System.out.println("1) ADD");
				System.out.println("2) GET");
				System.out.println("3) SIZE");
				System.out.println("4) EXIT");
				response = input.nextLine();

				switch (response){
					case "1":
						System.out.println("Method ADD: ");
						System.out.println("What task to perform?: ");
						String task = input.nextLine();
						out.println(task);
						input.nextLine();

						System.out.println("What is the estimated time?:");
						int estimatedTime = input.nextInt();
						out.println(estimatedTime);
						taskList.add(new Task(task, estimatedTime));
						break;

					case "2":
						System.out.println("Method GET: ");
						String get = input.nextLine();
						input.nextLine();
						taskList.getAndRemoveNextTask();
						out.println("Task: " + taskList);
						break;

					case "3":
						System.out.println("Method SIZE");
						String size = input.nextLine();
						out.println(size);
						input.nextLine();
						taskList.size();
						break;

					case "4":
						System.out.println("Closing the server...");
						String close = input.nextLine();
						out.println(close);
						break;
				}
			}

			catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}
