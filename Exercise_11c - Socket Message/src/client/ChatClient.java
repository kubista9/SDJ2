package client;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
	private Scanner input;
	private BufferedReader in;
	private PrintWriter out;
	private Socket socket;

	public ChatClient(String host, int port) throws IOException {
		input = new Scanner(System.in);
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out = new PrintWriter(socket.getOutputStream(), true);
		socket = new Socket(host, port);
	}

	public void execute() throws IOException{
		System.out.println("Starting the client...");
		Gson gson = new Gson();

		while (true){
			String reply1 = input.nextLine();
			Message message = new Message(reply1);
		}
	}

	public void close() throws IOException{
		socket.close();
	}
}
