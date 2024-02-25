package client.view;

import client.viewmodel.ManageExerciseViewModel;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import utility.IntStringConverter;

public class ManageExerciseViewController
{
  private ViewHandler viewHandler;
  private ManageExerciseViewModel viewModel;
  private Region root;

  @FXML Label headerLabel, errorLabel;
  @FXML TextField sessionField, numberField, topicField;
  @FXML RadioButton completedRadiobutton;
  @FXML Button submitButton;

  public ManageExerciseViewController()
  {
    //Called by FXML
  }

  public void init(ViewHandler viewHandler, ManageExerciseViewModel viewModel,
      Region root)
  {
    this.viewHandler = viewHandler;
    this.viewModel = viewModel;
    this.root = root;
    //Properties
    headerLabel.textProperty().bind(viewModel.headerPropertyProperty());
    errorLabel.textProperty().bind(viewModel.errorPropertyProperty());

    Bindings.bindBidirectional(sessionField.textProperty(),
        viewModel.sessionPropertyProperty(), new IntStringConverter());
    Bindings.bindBidirectional(numberField.textProperty(),
        viewModel.numberPropertyProperty(), new IntStringConverter());

    topicField.textProperty()
        .bindBidirectional(viewModel.topicPropertyProperty());
    //IDK what about  radio button
    //And also the other button
  }

  public Region getRoot()
  {
    return root;
  }

  public void reset()
  {
    //Called maybe another time :))
  }

  @FXML public void submitButton()
  {
    viewModel.accept();
  }
  @FXML public void cancelButton()
  {
    viewHandler.openView("list");
  }
  @FXML public void onEnter(ActionEvent actionEvent)
  {
    System.out.println(actionEvent.getEventType().getName());
    submitButton();
  }
}
