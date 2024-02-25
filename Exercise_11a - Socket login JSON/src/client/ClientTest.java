package client;

import client.model.UserClient;

import java.io.IOException;
import java.util.Scanner;

public class ClientTest {
	public static void main(String[] args) {

		boolean running = true;
		Scanner input = new Scanner(System.in);

		while(running){
			try {
				System.out.println("Enter username: ");
				String username = input.nextLine();

				System.out.println("Enter password");
				String password = input.nextLine();

				UserClient userClient = new UserClient("127.0.0.1", 2910);
				userClient.login(username, password);
				running = false;

			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}
}
