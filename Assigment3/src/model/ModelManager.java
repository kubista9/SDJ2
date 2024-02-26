package model;

import mediatorServer.Message;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class ModelManager implements Model, UnnamedPropertyChangeSubject
{
  private PropertyChangeSupport support;

  public ModelManager()
  {
    this.support = new PropertyChangeSupport(this);
  }

  @Override public void addMessage(Message message, String ip)
  {
    Log g =  Log.getInstance();
    g.addMessage(message);
    Log.getInstance().writeToFile(message, ip);
    support.firePropertyChange("BROADCAST", null, message);
  }

  @Override public void addListener(PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(listener);
  }

  @Override public void removeListener(PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(listener);
  }

  @Override public void logIn(String username){

  }

	@Override
	public Message post(Message message) {
		return message;
	}

	@Override public ArrayList<Message> getAllMessages()
  {
    return Log.getInstance().getAllMessages();
  }
}
