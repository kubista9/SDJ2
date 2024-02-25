package server.view;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Region;
import server.viewmodel.ListExerciseViewModel;
import server.viewmodel.SimpleExerciseViewModel;

public class ListExerciseViewController
{
  private ViewHandler viewHandler;
  private ListExerciseViewModel viewModel;
  private Region root;

  @FXML private TableView<SimpleExerciseViewModel> exercisesTable;
  @FXML private TableColumn<SimpleExerciseViewModel, String> numberColumn;
  @FXML private TableColumn<SimpleExerciseViewModel, String> topicColumn;
  @FXML private TableColumn<SimpleExerciseViewModel, Boolean> completedColumn;
  @FXML private Label errorLabel;

  public ListExerciseViewController()
  {
    //Called by FXML
  }

  public void init(ViewHandler viewHandler, ListExerciseViewModel viewModel,
      Region root)
  {
    this.viewHandler = viewHandler;
    this.viewModel = viewModel;
    this.root = root;
    //FXML thingies
    numberColumn.setCellValueFactory(
        cellData -> cellData.getValue().getNumberProperty());
    topicColumn.setCellValueFactory(
        cellData -> cellData.getValue().getTopicProperty());
    completedColumn.setCellValueFactory(
        cellData -> cellData.getValue().getCompletedProperty());
    exercisesTable.setItems(viewModel.getAll());
    errorLabel.textProperty().bind(viewModel.getErrorProperty());
  }

  public Region getRoot()
  {
    return root;
  }

  public void reset()
  {
    viewModel.clear();//Checker if null???
  }

  @FXML private void addEditButton()
  {
    reset();
    if (exercisesTable.isFocused())
    {
      viewModel.setSelected(exercisesTable.getFocusModel().getFocusedItem());
    }
    viewModel.addEdit();
    viewHandler.openView("manage");
  }

  @FXML private void removeButton()
  {
    reset();

    viewModel.setSelected(exercisesTable.getItems().get(1));
    if (viewModel.remove())
    {
      viewHandler.openView("manage");
    }
  }

}
