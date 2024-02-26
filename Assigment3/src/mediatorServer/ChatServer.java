package mediatorServer;
import model.Model;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer implements Runnable {
	private final int PORT = 2910;
	private boolean running;
	private Socket socket;
	private Model model;
	private ServerSocket welcomeSocket;

	public ChatServer(Model model, int port) throws IOException {
		this.model = model;
		this.welcomeSocket = new ServerSocket(port);
		running = true;
	}

	@Override
	public void run() {
		System.out.println("ChatServer is running....");

		try {
			while (running) {
				Socket socket = welcomeSocket.accept();
				ChatClientHandler chatClientHandler = new ChatClientHandler(socket, model);
				Thread t1 = new Thread(chatClientHandler);
				t1.start();
			}
		}

		catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public void close() throws IOException{
		running = false;
		welcomeSocket.close();
	}
}
