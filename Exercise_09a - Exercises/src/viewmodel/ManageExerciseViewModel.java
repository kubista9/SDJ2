package viewmodel;

import javafx.beans.property.*;
import model.Exercise;
import model.Model;

public class ManageExerciseViewModel
{
    private Model model;
    private ViewState viewState;

    private StringProperty errorProperty, headerProperty, topicProperty;
    private ObjectProperty<Boolean> completedProperty, editableProperty;
    private IntegerProperty numberProperty, sessionProperty;

    public ManageExerciseViewModel(Model model, ViewState viewState)
    {
        this.model = model;
        this.viewState = viewState;
        //Properties
        errorProperty = new SimpleStringProperty();
        headerProperty = new SimpleStringProperty();
        topicProperty = new SimpleStringProperty();
        completedProperty = new SimpleObjectProperty<>(false);
        editableProperty = new SimpleObjectProperty<>(false);
        numberProperty = new SimpleIntegerProperty();
        sessionProperty = new SimpleIntegerProperty();
    }

    public void reset()
    {
        errorProperty.set(null);
        //ViewState incorporated here according to the number and isRemove we set the header,
        //Create a temp exercise, change all the properties accordingly
        if (viewState != null && viewState.getNumber() != null)
        //CASE REMOVE & EDIT cuz the number is set
        {
            Exercise ex = model.getExercise((viewState.getNumber()));
            numberProperty.set(ex.getExerciseNumber());
            sessionProperty.set(ex.getSessionNumber());
            topicProperty.set(ex.getTopic());
            completedProperty.set(ex.isCompleted());
            if (viewState.isRemove())
            {
                headerProperty.set("Remove exercise");
                editableProperty.set(false);
            } else
            {
                headerProperty.set("Edit exercise");
                editableProperty.set(true);
            }
        } else if (viewState != null && !viewState.isRemove()) //CASE ADD no number set, remove is false
        {
            headerProperty.set("Add exercise");
            numberProperty.set(0);
            sessionProperty.set(0);
            topicProperty.set(null);
            completedProperty.set(false);
            editableProperty.set(true);
        }
    }

    public StringProperty errorPropertyProperty()
    {
        return errorProperty;
    }

    public StringProperty headerPropertyProperty()
    {
        return headerProperty;
    }

    public StringProperty topicPropertyProperty()
    {
        return topicProperty;
    }

    public IntegerProperty numberPropertyProperty()
    {
        return numberProperty;
    }

    public IntegerProperty sessionPropertyProperty()
    {
        return sessionProperty;
    }

    public ObjectProperty<Boolean> completedPropertyProperty()
    {
        return completedProperty;
    }

    public ObjectProperty<Boolean> editablePropertyProperty()
    {
        return editableProperty;
    }

    private Exercise createExerciseObject()
    {
        Exercise ex = new Exercise(sessionProperty.get(), numberProperty.get(), topicProperty.get());
        return ex;
    }

    public boolean accept()
    {
        //This method returns a boolean whether an action is correct.
        if (headerProperty == null)
        {
            errorProperty.set("Null property.");
            return false;
        }
        try
        {
            if (headerProperty.get().contains("Add")) //Add
            {
                model.addExercise(createExerciseObject());
            } else if (headerProperty.get().contains("Edit")) //Edit
            {
                model.editExercise(viewState.getNumber(), createExerciseObject());
            } else  //Remove
            {
                model.removeExercise(viewState.getNumber());
            }
            return true;
        } catch (Exception e)
        {
            errorProperty.set(e.getMessage());
            return false;
        }
    }
}
