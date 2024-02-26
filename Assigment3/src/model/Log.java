package model;

import mediatorServer.Message;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

public class Log
{
  private static Log instance;
  private static ArrayList<Message> messages;
  private static Object lock = new Object();

  public static Log getInstance()
  {
    if (instance == null)
    {
      synchronized (lock)
      {
        if (instance == null)
        {
          instance = new Log();
        }
      }
    }
    return instance;
  }

  private Log()
  {
    messages = new ArrayList<>();
  }

  public void addMessage (Message message)
  {
    messages.add(message);
  }

  public ArrayList<Message> getAllMessages()
  {
    return messages;
  }

  public void writeToFile(Message message, String ip)
  {
    if (message == null)
    {
      return;
    }
    BufferedWriter out = null;
    try
    {
      out = new BufferedWriter(new FileWriter("log.txt", true));
      out.write(ip + ": " + message + "\n");
    }
    catch (Exception e) {e.printStackTrace();}
    finally
    {
      try
      {
        out.close();
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
  }
}
