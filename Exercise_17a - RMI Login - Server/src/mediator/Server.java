package mediator;

import model.Model;
import model.Password;
import model.User;
import model.UserName;

import java.rmi.Remote;

public class Server implements RemoteModel {
	private Model model;

	public Server(Model model) {
		this.model = model;
	}

	@Override
	public int getNumberOfUsers() {
		return 0;
	}

	@Override
	public User getUser(int index) throws IndexOutOfBoundsException {
		return null;
	}

	@Override
	public User getUserByName(String name) {
		return null;
	}

	@Override
	public void addUser(User user) throws IllegalStateException, IllegalArgumentException {

	}

	@Override
	public void addUser(UserName userName, Password password) throws IllegalStateException, IllegalArgumentException {

	}

	@Override
	public void addUser(String userName, String password) throws IllegalStateException, IllegalArgumentException {

	}

	@Override
	public boolean contains(User user) {
		return false;
	}
}
