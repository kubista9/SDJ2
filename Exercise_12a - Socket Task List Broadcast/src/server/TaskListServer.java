package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TaskListServer {
	private ServerSocket welcomeSocket;
	private TaskList taskList;

	public TaskListServer(TaskList taskList, int port) throws IOException {
		this.taskList = taskList;
		this.welcomeSocket = new ServerSocket(port);
	}

	public void execute() throws IOException{

		System.out.println("Running...");

		while (true){
			Socket socket = welcomeSocket.accept();
			TaskListCommunicatorThreadHandler taskListCommunicatorThreadHandler = new TaskListCommunicatorThreadHandler(socket, taskList);
			Thread t1 = new Thread(taskListCommunicatorThreadHandler);
			t1.start();
		}
	}
}
