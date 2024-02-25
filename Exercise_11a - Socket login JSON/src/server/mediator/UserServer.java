package server.mediator;

import server.model.Model;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class UserServer implements Runnable {
	private Model model;
	private final int PORT = 2910;
	private boolean running;
	private ServerSocket welcomeSocket;

	public UserServer(Model model) throws IOException {
		this.model = model;
		running = true;
		welcomeSocket = new ServerSocket(PORT);
	}

	@Override
	public void run() {
		while(running){
			System.out.println("Server is waiting...");

			try {
				Socket socket = welcomeSocket.accept();
				System.out.println("You are now connected! ");
				UserClientHandler userClientHandler = new UserClientHandler(socket, model);
				Thread thread1 = new Thread(userClientHandler);
				thread1.start();
			}
			catch (IOException e){
				throw new RuntimeException(e);
			}
		}
	}
}
