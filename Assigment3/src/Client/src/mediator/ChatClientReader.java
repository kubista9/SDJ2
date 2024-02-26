package Client.src.mediator;

import java.io.BufferedReader;

public class ChatClientReader implements Runnable
{
  private BufferedReader in;
  private ChatClient client;
  public ChatClientReader(ChatClient client, BufferedReader in){
    this.client = client;
    this.in=in;
  }
  public void run(){
    while(true){
      String s;
      try {
        System.out.println("Waiting for input.");
        s = in.readLine();
        client.receive(s);
      }
      catch (Exception e) {
        throw new RuntimeException(e);
      }
    }
  }
}
