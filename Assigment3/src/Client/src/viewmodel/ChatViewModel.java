package Client.src.viewmodel;

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ChatViewModel implements PropertyChangeListener
{
  private StringProperty errorProperty;
  private StringProperty inputProperty;
  private Model model;
  private ObservableList<String> logs;
  public ChatViewModel(Model model)
  {
    this.model = model;
    this.model.addListener(this);
    errorProperty = new SimpleStringProperty("");
    inputProperty = new SimpleStringProperty("");
    logs = FXCollections.observableArrayList();
  }

  public void update()
  {

  }

  public void reset()
  {
    update();
  }

  public StringProperty getErrorProperty()
  {
    return errorProperty;
  }

  public StringProperty getInputProperty()
  {
    return inputProperty;
  }

  public ObservableList<String> getItems()
  {
    return logs;
  }

  public void post()
  {
    try
    {
      model.post(inputProperty.getValue());
    }
    catch (Exception e)
    {
      errorProperty.set(e.toString());
    }
  }

  @Override public void propertyChange(PropertyChangeEvent evt) {
    Platform.runLater(()->{
      this.logs.add(evt.getNewValue().toString());

    });
//    if(evt.getPropertyName().equals("OK")){
//      inputProperty.set("");
//    }
//    if(evt.getPropertyName().equals("BROADCAST")){
//      inputProperty.set("");
//    }
//    System.out.println("In view model");

  }
}
