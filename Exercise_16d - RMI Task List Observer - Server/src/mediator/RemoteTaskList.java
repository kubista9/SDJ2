package mediator;

import server.Task;
import utility.observer.subject.RemoteSubject;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteTaskList extends RemoteSubject<Task, Task> {
	public void addTask(Task task) throws RemoteException;
	public Task get() throws RemoteException;
	public int size() throws RemoteException;
}
