package client;
import mediator.RemoteMessageList;
import mediator.RemoteSender;
import utility.observer.event.ObserverEvent;

import java.net.InetAddress;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RmiCallBackClient implements RemoteSender {
	private RemoteMessageList remoteMessageList;

	public RmiCallBackClient() {
		try {
			remoteMessageList = (RemoteMessageList) Naming.lookup("rmi://"+
					InetAddress.getLocalHost().getHostAddress() + ":1099/Message");
			UnicastRemoteObject.exportObject(this, 0);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void send(String text) throws RemoteException {
		remoteMessageList.addMessage(text,this);
	}

	@Override
	public void replyMessage(String message) throws RemoteException {
		System.out.println(message);
	}
}
