package mines;

import javafx.application.Application;
import javafx.stage.Stage;


public class Mines extends Application {
	
	// Start
	private Mines_View view; // Die View
	private Mines_Model model; // Das Model
	private Mines_Controller controller; // Der Controller
	
	
	// Start
	public void start(Stage primaryStage) throws Exception {
		this.model = new Mines_Model(); // Hat keine Abhänigkeiten und kann deshalb zuerst erstellt werden
		this.view = new Mines_View(primaryStage, model); // Die View erhält eine Referenz aufs Model und das "Stage" Objekt
		this.controller = new Mines_Controller(model, view); // Der Controller erhält Referenzen aufs Model und View
		view.start(); // Um GUI anzuzeigen
	}

	// Start
	public static void main(String[] args) {
		launch();
	}

}
