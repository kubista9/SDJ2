package server;
import utility.observer.listener.GeneralListener;
import utility.observer.subject.PropertyChangeHandler;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class RmiObserverServer implements RemoteMessageList
{
	private ArrayList<String> messageList;
  private PropertyChangeHandler<String, String> property;

	public RmiObserverServer()
	{
		this.messageList = new ArrayList<>();
    this.property = new PropertyChangeHandler<>(this, true);
	}

	public void start() throws RemoteException, MalformedURLException
	{
		UnicastRemoteObject.exportObject(this, 0);
		Naming.rebind("Message", this);
	}

	@Override
	public void addMessage(String message) throws RemoteException
	{
		messageList.add(message);
		System.out.println(message);
	}

  public boolean addListener(GeneralListener<String, String> listener, String... propertyNames) throws RemoteException
  {
    return property.addListener(listener, propertyNames);
  }

  public boolean removeListener(GeneralListener<String, String> listener, String... propertyNames) throws RemoteException
  {
    return property.removeListener(listener, propertyNames);
  }
}
