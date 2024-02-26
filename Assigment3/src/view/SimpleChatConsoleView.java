package view;

import mediatorServer.RequestPackage;
import model.Model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class SimpleChatConsoleView implements PropertyChangeListener
{
  public SimpleChatConsoleView (Model model)
  {
    model.addListener(this);
  }

  public void printRequest (RequestPackage request)
  {
    switch(request.getType())
    {
      case "USERNAME":
        System.out.println("USERNAME " + request.getText());
      case "EXIT":
        System.out.println("EXIT");
    }
  }

  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    if (evt.getPropertyName().equals("BROADCAST"))
    {
      System.out.println(evt.getNewValue());
    }
  }
}
