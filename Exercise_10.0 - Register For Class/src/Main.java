import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws UnknownHostException, IOException {

		final int PORT= 2910;
		final String HOST= "10.154.200.80";

		// Create keyboard input stream
		Scanner input = new Scanner(System.in);

		// Create client socket, connect to server
		Socket socket= new Socket(HOST, PORT);

		// Create input stream attached to the socket
		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

		// Create output stream attached to the socket
		PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

		System.out.print("Write a line for the server: ");
		String request = input.nextLine(); // Read line from keyboard
		System.out.println("Client> " + request);
		out.println(request);// Send line to server
		String reply = in.readLine(); // Read line from Server
		System.out.print("Write a line for the server: ");
		String request2 = input.nextLine(); // Read line from keyboard
		out.println(request2);
		String reply2 = in.readLine();
		System.out.println("Server> " + reply2);
		socket.close(); // Close connection
	}
}
