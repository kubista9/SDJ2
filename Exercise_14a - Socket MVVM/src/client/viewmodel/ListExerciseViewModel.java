package client.viewmodel;
import client.model.Exercise;
import javafx.application.Platform;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import client.model.Model;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class ListExerciseViewModel implements PropertyChangeListener
{
  private Model model;
  private ViewState viewState;

  private ObservableList<SimpleExerciseViewModel> list;
  private ObjectProperty<SimpleExerciseViewModel> selectedExerciseProperty;
  private StringProperty errorProperty;

  public ListExerciseViewModel(Model model, ViewState viewState)
  {
    this.model = model;
    this.viewState = viewState;
    //Properties
    list = FXCollections.observableArrayList();
    selectedExerciseProperty = new SimpleObjectProperty<>();
    errorProperty = new SimpleStringProperty();
    loadFromModel();//Loading values from model
  }

  public void clear()
  {
    errorProperty.set(null);
  }

  private void loadFromModel()
  {
    list.clear();
    ArrayList<Exercise> exercises = model.getAllExercises();
    for (int i = 0; i < exercises.size(); i++)
    {
      list.add(new SimpleExerciseViewModel((client.model.Exercise) exercises.get(i)));
    }
  }

  public void addEdit()
  {
    viewState.setRemove(false);
    if (selectedExerciseProperty.get() != null)//Edit
    {
      viewState.setNumber(
          selectedExerciseProperty.get().getNumberProperty().get());
    }
    else//Add
    {
      viewState.setNumber(null);
    }
  }

  public boolean remove()
  {
    viewState.setRemove(true);
    if (selectedExerciseProperty.get() != null)
    {
      viewState.setNumber(
          selectedExerciseProperty.get().getNumberProperty().get());
      return true;
    }
    else
    {
      errorProperty.set("No row selected.");
      return false;
    }
  }

  public ObservableList<SimpleExerciseViewModel> getAll()
  {
    return list;
  }

  public void setSelected(SimpleExerciseViewModel selectedExerciseProperty)
  {
    this.selectedExerciseProperty.set(selectedExerciseProperty);
  }

  public StringProperty getErrorProperty()
  {
    return errorProperty;
  }

  private void removeSimpleExercise(String number)
  {
    for (int i = 0; i < list.size(); i++)
    {
      if (list.get(i).getNumberProperty().get().equals(number))
      {
        list.remove(i);
        break;
      }
    }
  }

  private void addSimpleExercise(Exercise exercise)
  {
    list.add(new SimpleExerciseViewModel((client.model.Exercise) exercise));
  }

  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    Platform.runLater(() -> {
      switch (evt.getPropertyName())
      {
        case "Add":
          addSimpleExercise((Exercise) evt.getNewValue());
          break;
        case "Remove":
          removeSimpleExercise(((Exercise) evt.getNewValue()).getNumber());
          break;
        case "Edit":
        {
          removeSimpleExercise(((Exercise) evt.getNewValue()).getNumber());
          addSimpleExercise((Exercise) evt.getNewValue());
          break;
        }

      }
    });
  }
}
