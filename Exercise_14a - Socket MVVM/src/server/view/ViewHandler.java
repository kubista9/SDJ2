package server.view;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import server.viewmodel.ViewModelFactory;

public class ViewHandler
{
  private ManageExerciseViewController manageExerciseViewController;
  private ListExerciseViewController listExerciseViewController;
  private ViewModelFactory viewModelFactory;
  private Stage primaryStage;
  private Scene currentScene;

  public ViewHandler(ViewModelFactory viewModelFactory)
  {
    this.viewModelFactory=viewModelFactory;
    currentScene = new Scene(new Region());
  }

  public void start(Stage primaryStage)
  {
    this.primaryStage = primaryStage;
    openView("list");
  }

  public void openView(String id)
  {
    Region root = null;
    switch (id)
    {
      case "list":
        root = loadListExerciseView("ListExercisesView.fxml");
        break;
      case "manage":
        root = loadManageExerciseView("ManageExerciseView.fxml");
        break;
    }
    currentScene.setRoot(root);
    String title = "";
    if (root.getUserData() != null)
    {
      title += root.getUserData();
    }
    primaryStage.setTitle(title);
    primaryStage.setScene(currentScene);
    primaryStage.setWidth(root.getPrefWidth());
    primaryStage.setHeight(root.getPrefHeight());
    primaryStage.show();
  }

  public void closeView()
  {
    primaryStage.close();
  }

  private Region loadListExerciseView(String fxmlFile)
  {
    if (listExerciseViewController == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        Region root = loader.load();
        listExerciseViewController = loader.getController();
        listExerciseViewController
            .init(this, viewModelFactory.getListExerciseViewModel(), root);
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    else
    {
      listExerciseViewController.reset();
    }
    return listExerciseViewController.getRoot();
  }

  private Region loadManageExerciseView(String fxmlFile)
  {
    if (manageExerciseViewController == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        Region root = loader.load();
        manageExerciseViewController = loader.getController();
        manageExerciseViewController
            .init(this, viewModelFactory.getManageExerciseViewModel(), root);
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    else
    {
      manageExerciseViewController.reset();
    }
    return manageExerciseViewController.getRoot();
  }
}
