package client.viewmodel;
import server.model.Model;

public class ViewModelFactory
{
  private ManageExerciseViewModel manageExerciseViewModel;
  private ListExerciseViewModel listExerciseViewModel;

  public ViewModelFactory(Model model)
  {
    this.manageExerciseViewModel = new ManageExerciseViewModel(model);
    this.listExerciseViewModel = new ListExerciseViewModel(model);
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
