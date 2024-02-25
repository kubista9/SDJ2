package server;

import mediator.RemoteMessageList;
import mediator.RemoteSender;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class RmiCallBackServer implements RemoteMessageList {
	private ArrayList<String> messageList;
	public RmiCallBackServer()
	{
		this.messageList = new ArrayList<>();
	}

	public void start() throws RemoteException, MalformedURLException
	{
		UnicastRemoteObject.exportObject(this, 0);
		Naming.rebind("Message", this);
	}

	@Override
	public void addMessage(String message, RemoteSender sender) throws RemoteException {
		messageList.add(message);
		System.out.println(message);
		sender.replyMessage("Thank you");
	}
}
