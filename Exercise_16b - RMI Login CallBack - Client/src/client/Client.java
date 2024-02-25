package client;
import java.rmi.RemoteException;
import java.util.Scanner;

public class Client
{
	public static void main(String[] args) throws RemoteException
	{
		client.RmiCallBackClient client = new client.RmiCallBackClient();

		Scanner input = new Scanner(System.in);

		while (true) {
			System.out.println("Text: ");
			String text = input.nextLine();
			client.send(text);
		}
	}
}
