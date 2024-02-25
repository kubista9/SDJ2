package client.model;

import utility.observer.javaobserver.UnnamedPropertyChangeSubject;

import java.util.ArrayList;

public interface Model extends UnnamedPropertyChangeSubject
{
  public ArrayList<Exercise> getAllExercises();
  public Exercise getExercise(String number);
  public Exercise removeExercise(String number);
  public void addExercise(Exercise exercise);
  public Exercise editExercise(String number, Exercise exercise);
}
