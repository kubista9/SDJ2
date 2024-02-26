package Client.src.viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Model;

public class LoginViewModel
{
  private StringProperty errorProperty;
  private StringProperty nameProperty;
  private Model model;

  public LoginViewModel(Model model)
  {
    this.model = model;
    errorProperty = new SimpleStringProperty("");
    nameProperty = new SimpleStringProperty("");
  }

  public void update()
  {
    clear();
  }

  public void clear()
  {
    nameProperty.set("");
    errorProperty.set("");
  }

  public void reset()
  {
    update();
  }

  public StringProperty getErrorProperty()
  {
    return errorProperty;
  }
  public StringProperty getNameProperty()
  {
    return nameProperty;
  }

  public void onLogin()
  {
    try
    {
      String reply = model.logIn(nameProperty.getValue());
      while (reply == null)
      {
        //nothing
      }
    }
    catch (Exception e)
    {
      errorProperty.set(e.getMessage());
      throw new IllegalArgumentException(e.getMessage());
    }
  }
}
