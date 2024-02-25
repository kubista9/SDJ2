import mediator.RemoteTaskList;
import server.RmiTaskServer;

public class Server {
	public static void main(String[] args) throws Exception {
		RemoteTaskList server = new RmiTaskServer();
	}
}
