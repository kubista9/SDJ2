package server.mediator;

import com.google.gson.Gson;
import server.model.Model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class UserClientHandler implements Runnable {
	private Model model;
	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;
	private boolean running;
	private Gson gson;
	private String clientIp;

	public UserClientHandler(Socket socket, Model model) throws IOException {
		this.socket = socket;
		this.model = model;
		this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		this.out = new PrintWriter(socket.getOutputStream(), true);
		this.running = true;
		this.gson = new Gson();
		this.clientIp = null;
	}

	public void close() {
		running = false;
	}

	public void run() {
		while (running) {
			try {
				String request = "";
				request = in.readLine();
				System.out.println("Client: " + request);
				UserPackage userPackage = gson.fromJson(request, UserPackage.class);
				System.out.println("User: " + userPackage.toString());

				model.addUser(userPackage.getUser(), userPackage.getPassword());
				out.println("Success, your are logged in ");
				System.out.println("Success, your are logged in ");

			} catch (Exception e) {
				out.println("Error: " + e.getMessage());
				System.out.println("Error: " + e.getMessage());
			}
			running = false;

		}
	}
}
