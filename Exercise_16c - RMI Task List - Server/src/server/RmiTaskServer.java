package server;

import mediator.RemoteTaskList;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class RmiTaskServer implements RemoteTaskList {
	private ArrayList<Task> taskList;
	public RmiTaskServer() throws MalformedURLException, RemoteException {
		this.taskList = new ArrayList<Task>();
		startRegistry();
		startServer();
	}

	private void startRegistry() throws RemoteException {
		try {
			Registry reg = LocateRegistry.createRegistry(1099);
			System.out.println("Registry started...");
		} catch (java.rmi.server.ExportException e) {
			System.out.println("Registry already started? " + e.getMessage());
		}
	}

	private void startServer() throws RemoteException, MalformedURLException {
		UnicastRemoteObject.exportObject(this, 0);
		Naming.rebind("Message", this);
		System.out.println("Server started...");
	}

	@Override
	public void addTask(Task task) throws RemoteException {
		taskList.add(task);
	}

	@Override
	public Task get() throws RemoteException {
		return taskList.get(0);
	}

	@Override
	public int size() throws RemoteException {
		return taskList.size();
	}
}
