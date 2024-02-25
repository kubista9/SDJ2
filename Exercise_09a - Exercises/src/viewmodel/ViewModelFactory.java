package viewmodel;

import model.Model;

public class ViewModelFactory {
	private ManageExerciseViewModel manageExerciseViewModel;
	private ListExerciseViewModel listExerciseViewModel;
	private ViewState viewState;

	public ViewModelFactory(Model model) {
		viewState = new ViewState();
		this.listExerciseViewModel = new ListExerciseViewModel(model, viewState);
		this.manageExerciseViewModel = new ManageExerciseViewModel(model, viewState);
	}

	public ManageExerciseViewModel getManageExerciseViewModel() {
		return manageExerciseViewModel;
	}

	public ListExerciseViewModel getListExerciseViewModel() {
		return listExerciseViewModel;
	}
}
