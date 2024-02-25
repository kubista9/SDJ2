package client;

import mediator.RemoteTaskList;
import utility.observer.event.ObserverEvent;
import utility.observer.listener.RemoteListener;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

public class RmiTaskClient implements RemoteListener<Task, Task> {
	private RemoteTaskList remoteTaskList;
	private String host;
	private Task task;

	public RmiTaskClient(String host) {
		this.host = host;
		try {
			remoteTaskList = (RemoteTaskList) Naming.lookup("rmi://" + host + ":1099/Message");
			UnicastRemoteObject.exportObject(this, 0);
			System.out.println("Client started...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void start() {
		while (true) {
			try {
				Scanner input = new Scanner(System.in);
				System.out.println("Which do you want to perform?");
				System.out.println("ADD a task?");
				System.out.println("GET a task");
				System.out.println("GET the size of the task list?");
				String choice = input.nextLine();

				//ADD
				if (choice.equals("ADD")) {
					System.out.println("What task to perform? ");
					String newTask = input.nextLine();
					System.out.println("What is the estimated time?");
					long estimatedTime = input.nextLong();
					try {
						remoteTaskList.addTask(new Task(newTask, estimatedTime));
					} catch (RemoteException e) {
						e.printStackTrace();
					}
				}

				//GET
				if (choice.equals("GET")) {
					try {
						remoteTaskList.get();
					} catch (RemoteException e) {
						throw new RuntimeException(e);
					}
				}

				//SIZE
				if (choice.equals("SIZE")) {
					try {
						remoteTaskList.size();
					} catch (RemoteException e) {
						throw new RuntimeException(e);
					}
				}

			} catch (RuntimeException e) {
				throw new RuntimeException(e);
			}
		}
	}

	@Override
	public void propertyChange(ObserverEvent<Task, Task> event) throws RemoteException {

	}
}
