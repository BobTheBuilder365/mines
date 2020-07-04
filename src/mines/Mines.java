package mines;

import javafx.application.Application;
import javafx.stage.Stage;


public class Mines extends Application {
	private Mines_View view;
	private Mines_Model model;
	private Mines_Controller controller;

	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		model = new Mines_Model();
		view = new Mines_View(primaryStage, model);
		controller = new Mines_Controller(model, view);
		view.start();
	}
}
