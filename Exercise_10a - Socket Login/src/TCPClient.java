import java.io.*;
import java.net.*;
import java.util.Scanner;

public class TCPClient {
	public static void main(String[] args) throws UnknownHostException, IOException {

		final int PORT = 5678;
		final String HOST = "10.21.11.127";
		System.out.println("Starting the server...");

		System.out.println("Server ip: " + InetAddress.getLocalHost().getHostAddress());
		Scanner input = new Scanner(System.in);
		Socket socket = new Socket(HOST, PORT);
		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

		out.println("connect");

		String request1 = input.nextLine();
		out.println("Jakub");
		System.out.println("username");

		String response1 = in.readLine();
		System.out.println("Server: " + response1);
		out.println("qwerty123");

		String request2 = input.nextLine();
		System.out.println("Server: " + request2);

		socket.close();
	}
}
