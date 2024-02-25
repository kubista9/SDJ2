package client.mediator;

import java.io.BufferedReader;

public class ExercisesClientReader implements Runnable{

	private ExercisesClient client;
	private BufferedReader in;
	private boolean running;

	public ExercisesClientReader(ExercisesClient client, BufferedReader in){
		this.client = client;
		this.in = in;
		this.running = true;
	}

	@Override
	public void run() {
		while (running){
			try {
				String line = in.readLine();
				client.received(line);
			}
			catch (Exception e){
				e.printStackTrace();
			}
		}
	}
}
