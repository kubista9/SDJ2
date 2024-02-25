package client.model;

import client.mediator.User;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.InputMismatchException;

public class UserClient implements Model{
	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;
	private Gson gson;

	public UserClient(String host, int port) throws IOException {
		socket = new Socket(host, port);
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out = new PrintWriter(socket.getOutputStream(), true);
		gson = new Gson();
	}

	public void disconnected() throws IOException{socket.close();}

	@Override
	public void login(String userName, String password) throws IllegalStateException, IllegalArgumentException {
		User user = new User(userName, password);
		String json = gson.toJson(user);
		out.println(json);
		while(true)
			try {
			System.out.println("Yoo");
			String reply1 = in.readLine();
			System.out.println("Second response:" + reply1);
			if (reply1.contains("Success")){
				System.out.println(reply1);
				break;
			}
			else {
				System.out.println(reply1);
				break;
			}
		}
		catch(IOException e){
			e.printStackTrace();
		}

	}
}
