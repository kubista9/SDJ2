package Client.src.mediator;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.Model;
import utility.observer.UnnamedPropertyChangeSubject;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.Map;

public class ChatClient implements UnnamedPropertyChangeSubject, Model
{
  private Socket socket;
  private BufferedReader in;
  private PrintWriter out;
  private Gson gson;
  private boolean waiting;
  private NetworkPackage receivedNetworkPackage;
  private PropertyChangeSupport property;

  public ChatClient(String host,int port) throws IOException {
    this.socket = new Socket(host,port);
    this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    this.out = new PrintWriter(socket.getOutputStream(), true);
    GsonBuilder builder = new GsonBuilder();
    builder.excludeFieldsWithModifiers(Modifier.STATIC, Modifier.TRANSIENT, Modifier.VOLATILE)
        .registerTypeHierarchyAdapter(byte[].class, new GsonByteArrayToBase64())
        .registerTypeAdapter(LocalDateTime.class, new GsonLocalDateTime());
    this.gson = builder.create();
    this.waiting = false;
    this.property = new PropertyChangeSupport(this);
    ChatClientReader chatClientReader = new ChatClientReader(this,in);
    Thread t = new Thread(chatClientReader);
    t.start();
  }

  public synchronized void receive(String replyString){
    if(gson.fromJson(replyString, Map.class).get("type").equals("BROADCAST")){
      MessagePackage ex = gson.fromJson(replyString,MessagePackage.class);
      property.firePropertyChange(ex.getType(),null,ex.getMessage().getText());
    }
    if(gson.fromJson(replyString, Map.class).get("type").equals("OK")){
      NetworkPackage n = gson.fromJson(replyString,NetworkPackage.class);
      if(waiting==true){
        receivedNetworkPackage =n;
        waiting = false;
        notifyAll();
      }
    }
    if(gson.fromJson(replyString, Map.class).get("type").equals("ERROR")){
      RequestPackage n = gson.fromJson(replyString,RequestPackage.class);
      receivedNetworkPackage = n;
      waiting = false;

      notifyAll();
      throw new IllegalArgumentException(n.getText());
    }
  }
  public synchronized String logIn(String username)
      throws InterruptedException {
    PackageCreator packageCreator = new RequestPackageCreator();
    NetworkPackage requestPackage = packageCreator.getPackage("USERNAME",username);
    String request = gson.toJson(requestPackage);
    out.println(request);
    while(receivedNetworkPackage==null){
      waiting=true;
      wait();
    }
    waiting=false;
    NetworkPackage r = receivedNetworkPackage;
    receivedNetworkPackage = null;
    return r.getType();
  }
  public String post(String message) throws InterruptedException {
    System.out.println(message);
    Message messageToPost = new Message(message);
    PackageCreator packageCreator = new MessagePackageCreator();
    NetworkPackage messagePackage = packageCreator.getPackage("POST",messageToPost);
    String request = gson.toJson(messagePackage);
    out.println(request);
    return "ko";
  }
  public synchronized void exit() throws InterruptedException {
    RequestPackageCreator packageCreator = new RequestPackageCreator();
    NetworkPackage requestPackage = packageCreator.getPackage("EXIT",null);
    String request = gson.toJson(requestPackage);
    out.println(request);
  }
  @Override public void addListener(PropertyChangeListener listener) {
    property.addPropertyChangeListener(listener);
  }

  @Override public void removeListener(PropertyChangeListener listener) {
    property.removePropertyChangeListener(listener);
  }
}
