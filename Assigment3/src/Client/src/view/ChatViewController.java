package Client.src.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import Client.src.viewmodel.ChatViewModel;

public class ChatViewController
{
  @FXML private ListView<String> logList;
  @FXML private TextField inputField;
  @FXML private Button postButton;
  @FXML private Label errorLabel;

  private Region root;
  private ChatViewModel chatViewModel;
  private ViewHandler viewHandler;

  public void init(ViewHandler viewHandler, ChatViewModel chatViewModel, Region root)
  {
    this.root = root;
    this.viewHandler = viewHandler;
    this.chatViewModel = chatViewModel;
    this.logList.setItems(chatViewModel.getItems());
    inputField.textProperty().bindBidirectional(chatViewModel.getInputProperty());
    errorLabel.textProperty().bind(chatViewModel.getErrorProperty());
  }

  public void reset()
  {
    chatViewModel.reset();
  }

  public Region getRoot()
  {
    return root;
  }

  @FXML public void postButton()
  {
    chatViewModel.post();
    System.out.println("In controller");
    inputField.setText("");
  }

  @FXML private void onEnter(ActionEvent event)
  {
    if (event.getSource() == inputField)
    {
      postButton.requestFocus();
    }
    else if (event.getSource() == postButton)
    {
      postButton();
    }
  }
}
