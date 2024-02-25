package client;
import server.RemoteMessageList;
import utility.observer.event.ObserverEvent;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class RmiObserverClient {
	private RemoteMessageList server;

	public RmiObserverClient() {
		try {
			server = (RemoteMessageList) Naming.lookup("rmi://localhost:1099/Message");
//			server.addListener(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void send(String text) throws RemoteException {
		server.addMessage(text);
	}

	public void propertyChange(ObserverEvent<String, String> event) throws RemoteException {
		System.out.println(event.getPropertyName() + ": " + event.getValue2());
	}
}
