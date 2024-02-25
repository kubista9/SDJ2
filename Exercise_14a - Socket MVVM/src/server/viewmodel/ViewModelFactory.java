package server.viewmodel;
import server.model.Model;

public class ViewModelFactory
{
  private ManageExerciseViewModel manageExerciseViewModel;
  private ListExerciseViewModel listExerciseViewModel;

  public ViewModelFactory(Model model, ViewState viewState)
  {
    this.manageExerciseViewModel=new ManageExerciseViewModel(model,viewState);
    this.listExerciseViewModel=new ListExerciseViewModel(model,viewState);
  }

  public ManageExerciseViewModel getManageExerciseViewModel()
  {
    return manageExerciseViewModel;
  }

  public ListExerciseViewModel getListExerciseViewModel()
  {
    return listExerciseViewModel;
  }

}
