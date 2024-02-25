package server.mediator;

import server.model.Model;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ExercisesServer implements Runnable{

	private static final int PORT = 2910;
	private boolean running;
	private ServerSocket welcomeSocket;
	private Model model;

	public ExercisesServer(Model model) throws IOException {
		this.running = true;
		this.model = model;
	}

	public void close() throws IOException{
		running = false;
		welcomeSocket.close();
	}

	@Override
	public void run() {
		System.out.println("ExercisesServer Class is running.....");

		try {
			welcomeSocket = new ServerSocket(PORT);

			while (running) {
				Socket socket = welcomeSocket.accept();
				ExercisesClientHandler exercisesClientHandler = new ExercisesClientHandler(model, socket);
				Thread t1 = new Thread(exercisesClientHandler);
				t1.setDaemon(true);
				t1.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
