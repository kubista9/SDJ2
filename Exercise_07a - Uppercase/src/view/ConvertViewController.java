package view;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import viewmodel.ConvertViewModel;
public class ConvertViewController {
  @FXML private TextField requestField;
  @FXML private TextField replyField;
  @FXML private Label errorLabel;
  private Region root;
  private ViewHandler viewHandler;
  private ConvertViewModel convertViewModel;
  public ConvertViewController() {}
  public void init(ViewHandler viewHandler, ConvertViewModel viewModel, Region root) {
    this.viewHandler = viewHandler;
    this.convertViewModel = viewModel;
    this.root = root;
    requestField.textProperty().bindBidirectional(viewModel.getRequestProperty());
    replyField.textProperty().bind(viewModel.getReplyProperty());
    errorLabel.textProperty().bind(viewModel.getErrorProperty());
  }
  public void reset() {}
  public Region getRoot() {
    return root;
  }
  @FXML private void onSubmit() {
    convertViewModel.convert();
  }
  @FXML private void onEnter() {
    onSubmit();
  }
}
