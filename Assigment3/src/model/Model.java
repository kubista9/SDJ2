package model;
import mediatorServer.Message;

import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public interface Model {
	void addMessage(Message message, String ip);
	void addListener(PropertyChangeListener listener);
	void removeListener(PropertyChangeListener listener);
	void logIn(String username);

	Message post(Message message);

	ArrayList<Message> getAllMessages();
}
