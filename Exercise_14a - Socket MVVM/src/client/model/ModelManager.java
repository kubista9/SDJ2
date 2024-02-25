package client.model;

import client.mediator.ExercisesClient;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.util.ArrayList;

public class ModelManager implements Model, PropertyChangeListener {
	private static final String HOST = "localhost";
	private static final int PORT = 2910;
  private ExercisesClient client;
  private PropertyChangeSupport property;

  public ModelManager() throws IOException {
    property = new PropertyChangeSupport(this);
    client = new ExercisesClient(HOST, PORT);
	client.addListener(this);
  }

  @Override public ArrayList<Exercise> getAllExercises()
  {
    return client.getAllExercises();
  }

  @Override public Exercise getExercise(String number)
  {
    return client.getExercise(number);
  }

  @Override public Exercise removeExercise(String number)
  {
    return client.removeExercise(number);
  }

  @Override public Exercise editExercise(String number, Exercise exercise)
  {
    return client.editExercise(number, exercise);
  }

  @Override public void addExercise(Exercise exercise)
  {
	  client.addExercise(exercise);
  }

  @Override public void addListener(PropertyChangeListener listener)
  {
    property.addPropertyChangeListener(listener);
  }

  @Override public void removeListener(PropertyChangeListener listener)
  {
    property.removePropertyChangeListener(listener);
  }

	@Override
	public void propertyChange(PropertyChangeEvent event) {
		property.firePropertyChange(event);
	}
}
