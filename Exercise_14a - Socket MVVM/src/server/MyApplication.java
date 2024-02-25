package server;

import client.view.ViewHandler;
import client.viewmodel.ViewModelFactory;
import javafx.stage.Stage;
import server.mediator.ExercisesServer;
import server.model.Model;
import server.model.ModelManager;

import java.io.IOException;

public class MyApplication {
	private static ExercisesServer server;
	private static Stage primaryStage;

	public static void main(String[] args) throws IOException {
		Model model = new ModelManager();
		server = new ExercisesServer(model);
		Thread serverThread = new Thread(server);
		serverThread.start();

		ViewModelFactory viewModelFactory = new ViewModelFactory(model);
		ViewHandler view = new ViewHandler(viewModelFactory);

		view.start(primaryStage);
	}

//	@Override public void stop(){
//		try {
//			server.close();
//		} catch (IOException e) {
//			throw new RuntimeException(e);
//		}
//	}
}
