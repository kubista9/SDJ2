import java.io.*;
import java.net.*;

public class TCPServer {
	public static void main(String[] args) throws IOException {
		final int PORT = 5678;
		System.out.println("Starting server...");
		System.out.println("Server ip: " + InetAddress.getLocalHost().getHostAddress());
		ServerSocket welcomeSocket = new ServerSocket(PORT);

		while (true) {
			System.out.println("Waiting for a client...");
			Socket socket = welcomeSocket.accept();
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

			if (in.readLine().equals("connect")) {
				out.println("Username?");
				String reply1 = in.readLine();
				System.out.println(reply1);
				out.println("Password?");
				String reply2 = in.readLine();
				System.out.println(reply2);
				if (reply2.equals("password")) {
					out.println("Approved");
				}
				else
					out.println("Wrong password");
			}
			else {
				out.print("Disconnected");
				socket.close();
			}
		}
	}
}
