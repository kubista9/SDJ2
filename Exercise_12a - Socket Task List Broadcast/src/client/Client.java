package client;

import java.io.IOException;

import static jdk.javadoc.internal.tool.Main.execute;

public class Client {
	public static void main(String[] args) throws IOException {
		TaskListClient taskListClient = new TaskListClient("127.0.0.1", 2910);
		taskListClient.execute();
	}
}
