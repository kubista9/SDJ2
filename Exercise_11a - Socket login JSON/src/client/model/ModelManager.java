package client.model;

import client.mediator.User;

import java.io.IOException;

public class ModelManager implements Model {
	private UserClient userClient;

	public ModelManager() throws IOException {
		this.userClient = new UserClient("127.0.0.1" ,2910);
	}

	@Override
	public void login(String userName, String password) throws IllegalStateException, IllegalArgumentException {
		userClient.login(userName, password);
	}
}
