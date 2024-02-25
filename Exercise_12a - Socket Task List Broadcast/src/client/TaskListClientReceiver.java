package client;

import java.io.BufferedReader;
import java.io.IOException;

public class TaskListClientReceiver implements Runnable{
	private BufferedReader in;
	private TaskListClient client;

	public TaskListClientReceiver(TaskListClient client, BufferedReader in) throws IOException {
		this.client = client;
		this.in = in;
	}

	@Override
	public void run() {
		while (true){
			String s = "";

			try {
				s = in.readLine();
				client.receive(s);
			}
			catch( IOException e){
				e.printStackTrace();
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
	}
}
