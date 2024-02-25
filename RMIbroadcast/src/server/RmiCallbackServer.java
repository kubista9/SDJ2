package server;

import mediator.RemoteMessageList;
import mediator.RemoteSender;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class RmiCallbackServer implements RemoteMessageList {
	private ArrayList<String> messageList;
	private ArrayList<RemoteSender> senders;

	public RmiCallbackServer() {
		this.messageList = new ArrayList<>();
		this.senders = new ArrayList<>();
	}

	public void start() throws RemoteException {
		try {
			RemoteMessageList stub = (RemoteMessageList) UnicastRemoteObject.exportObject(this, 0);
			Naming.rebind("Callback", stub);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addMessage(String message, RemoteSender sender) throws RemoteException {
		messageList.add(message);
		sender.replyMessage("Thank you");
		for (RemoteSender registeredSender : senders) {
			registeredSender.replyMessage("Callback: " + message);
		}
	}
}
