package mines;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Mines_View {
	private Mines_Model model;
	protected Stage stage;
	
	public Mines_View(Stage stage, Mines_Model model) {
		this.stage = stage;
		this.model = model;

		BorderPane root = new BorderPane();

		// Create and add menus
		
		// Add VBox on the right
			
		// Add game grid
//		root.setCenter(gameGrid);
		
		Scene scene = new Scene(root);
		stage.setTitle("Mines Game");
		scene.getStylesheets().add(
				getClass().getResource("mines.css").toExternalForm());
		stage.setScene(scene);;
	}

	public void start() {
		stage.show();
	}
	
	/**
	 * Initialize a new game. Called from the controller.
	 */

}
