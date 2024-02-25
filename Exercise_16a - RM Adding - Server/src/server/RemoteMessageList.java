package server;

import utility.observer.subject.RemoteSubject;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteMessageList extends RemoteSubject<String, String> {
	public void addMessage(String message) throws RemoteException;
}
