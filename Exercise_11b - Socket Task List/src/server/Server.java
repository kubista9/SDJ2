package server;

import java.io.IOException;

public class Server {
	public static void main(String[] args) throws IOException {
		TaskList taskList = new TaskList();
		TaskListServer taskListServer = new TaskListServer(taskList, 2910);
		taskListServer.execute();
	}
}
