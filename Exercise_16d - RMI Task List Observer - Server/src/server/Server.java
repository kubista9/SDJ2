package server;

import mediator.RemoteTaskList;

public class Server {
	public static void main(String[] args) throws Exception {
		RemoteTaskList server = new RmiTaskServer();
	}
}
