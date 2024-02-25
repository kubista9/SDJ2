package mediator;

import client.Task;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteTaskList extends Remote {
	public void addTask(Task task) throws RemoteException;
	public Task get() throws RemoteException;
	public int size() throws RemoteException;
}
