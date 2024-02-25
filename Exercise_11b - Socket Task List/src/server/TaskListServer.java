package server;

import server.TaskList;
import server.TaskListCommunicatorThreadHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TaskListServer {
	private ServerSocket welcomeSocket;
	private TaskList taskList;
	private int port;

	public TaskListServer(TaskList taskList, int port) throws IOException {
		this.taskList = taskList;
		this.port = port;
		welcomeSocket = new ServerSocket(port);
	}

	public void execute(){
		System.out.println("Starting the server...");

		while(true){
			try{
				ServerSocket socket = new ServerSocket();
				Socket socket1 = welcomeSocket.accept();
				TaskListCommunicatorThreadHandler taskListCommunicatorThreadHandler = new TaskListCommunicatorThreadHandler(socket1, taskList );
				Thread thread1 = new Thread(taskListCommunicatorThreadHandler);
				thread1.start();
			}
			catch(IOException e){
				e.printStackTrace();
			}
		}
	}
}
