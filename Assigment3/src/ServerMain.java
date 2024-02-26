import mediatorServer.ChatServer;
import model.Model;
import model.ModelManager;

import java.io.IOException;

public class ServerMain
{
  public static void main(String[] args) throws IOException
  {
    Model model = new ModelManager();
    ChatServer server = new ChatServer(model,5678);
    Thread t1 = new Thread(server);
    t1.start();
  }
}
