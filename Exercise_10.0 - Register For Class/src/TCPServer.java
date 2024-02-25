import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
	public static void main(String args[]) throws IOException {
		final int PORT = 6789;
		System.out.println("Starting Server...");
		System.out.println("Server ip:" + InetAddress.getLocalHost().getHostAddress());

		//create welcoming socket at port 6789
		ServerSocket welcomeSocket = new ServerSocket(PORT);
		while (true) {
			System.out.println("Waiting for a client...");

			// Wait for contact by client
			Socket socket = welcomeSocket.accept();

			// create input stream attached to the socket
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			// create output stream attached to the socket
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

			String request = in.readLine(); // read line from client

			System.out.println("Client> " + request);
			String reply = request.toUpperCase();
			System.out.println("Server> " + reply);
			out.println(reply); // send line to client

			// loop back and wait for another client connection.

		}
	}
}
