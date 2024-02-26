package Client.src.model;

import Client.src.mediator.ChatClient;
import Client.src.utility.observer.UnnamedPropertyChangeSubject;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;

public class ModelManager implements Model, PropertyChangeListener, UnnamedPropertyChangeSubject
{
  private ChatClient chatClient;
  private PropertyChangeSupport property;
  public static String HOST = "localhost";
  public static int PORT = 5678;

  public ModelManager() throws IOException
  {
    this.chatClient = new ChatClient(this.HOST,this.PORT);
    property = new PropertyChangeSupport(this);
    this.chatClient.addListener(this);
  }


	@Override public String logIn(String username) throws InterruptedException {
    System.out.println("Hello, client model tries to login!");
      return chatClient.logIn(username);
  }

  public String post(String message) throws InterruptedException {
    System.out.println("Hello, client model tries to post!" + message);
      return chatClient.post(message);
  }

  @Override public void exit() throws InterruptedException {
      chatClient.exit();
  }

  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    property.firePropertyChange(evt.getPropertyName(),evt.getOldValue(),evt.getNewValue());
  }

  @Override public void addListener(PropertyChangeListener listener)
  {
    property.addPropertyChangeListener(listener);
  }

  @Override public void removeListener(PropertyChangeListener listener)
  {
    property.removePropertyChangeListener(listener);
  }

}

