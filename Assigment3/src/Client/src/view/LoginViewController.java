package Client.src.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import Client.src.viewmodel.LoginViewModel;

public class LoginViewController
{
  private ViewHandler viewHandler;
  private LoginViewModel loginViewModel;
  private Region root;
  @FXML private TextField nameField;
  @FXML private Label errorLabel;
  @FXML private Button loginButton;

  public void init(ViewHandler viewHandler, LoginViewModel loginViewModel, Region root)
  {
    this.viewHandler = viewHandler;
    this.loginViewModel = loginViewModel;
    this.root = root;
    nameField.textProperty().bindBidirectional(loginViewModel.getNameProperty());
    errorLabel.textProperty().bind(loginViewModel.getErrorProperty());

  }

  public void reset()
  {
    loginViewModel.reset();
  }

  public Region getRoot()
  {
    return root;
  }

  @FXML public void submitButton()
  {
    try{
      loginViewModel.onLogin();
      viewHandler.openView("chat");
    }catch (Exception e){

    }
  }

  @FXML public void onEnter(ActionEvent event)
  {
    if (event.getSource() == nameField)
    {
      loginButton.requestFocus();
    }
    else if (event.getSource() == loginButton)
    {
      submitButton();
    }
  }
}
