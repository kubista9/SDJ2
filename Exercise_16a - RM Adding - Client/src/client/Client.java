package client;
import java.rmi.RemoteException;
import java.util.Scanner;

public class Client
{
	public static void main(String[] args) throws RemoteException
	{
		client.RmiObserverClient client = new client.RmiObserverClient();

		Scanner input = new Scanner(System.in);

		while (true)
		{
			System.out.println("Text: ");
			String text = input.nextLine();
			client.send(text);
		}
	}
}
