package mines;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
// 1= 	Verlinkung "View" mit "Stage" und "Model"

// 2 bis 3 beinhaltet die "GUI" Gkomponenten, welche wir brauchen
// 2=	"Menubar" Implementierung
// 2.1=	"VBox" for controls and information displays
// 3=	"GridPane" zum anzeigen des als 2D-array gespeicherten Spielfelds
//		und den deklarierten Buttons.

// 4= 	Unsere Wurzel also oberste Layout Pane wird eine BorderPane
// 4.1	"Top" organisiert "MenuBar" (menus)
// 4.2	"Right" organisiert Box
// 4.3	"Center" organisiert "GridPane" (gamegrid)	

// 5= 	Szene wird an Wurzel übergeben und auf der Bühne die Szene gestellt
//		Scene(Wurzel) -> stage.SetTitle -> styling -> stage.setScene(scene)
//		Code:
//		Neue "scene" welche die "root" beinhaltet
//		"stage" setzt Titel - setTitle(""))
//		"scene" wird gestylt
//		"stage" setzt "scene" - setScene(scene)

// 6= 	Sobald alles bereit ist werden wir in "start" die Benutzeroberfläche zeigen

// 7.	"newGame" erzeugt neues Spielfeld und wird vom Controller verwendet
// 7.1	"Button"s Array wird erzeugt
// 7.2	For-Schleife, welche für jede Zelle des "2D Arrays" 
// 7.3	ein "Button" Objekt erzeugt
// 7.4	und das "Button" Objekt im "2D-Array" speichert (MODEL)
// 7.5	EBENSO werden dem "gameGrid" alle Buttons hinzugefügt (VIEW)

// Start
public class Mines_View {
	
	// 1 	
	// Instanzvariablen / Attribute der "View"
	// Die "View" will Zugriff auf die "Stage" und das "Model"
	protected Stage stage; // Link zur "Stage"
	protected Mines_Model model; // Link zum "Model"
	
	
	// 2 		
	protected MenuBar menus = new MenuBar();
	protected Menu menuFile = new Menu("Game");
	protected MenuItem miAbout = new MenuItem("About");
	
	// 2.1		
	protected VBox rightPane = new VBox();
	protected Label lblGameOver = new Label("Playing");
	
	// 3
	protected GridPane gameGrid = new GridPane();
	protected Button[][] buttons;
	
	


	public Mines_View(Stage primaryStage, Mines_Model model) {
		// 1
		// beim Aufruf des Konstruktors der "View" instanzieren/speichern wir erst die
		// Instanzvariablen/Attribute der "View" also die "Stage" und "Model"
		this.stage = primaryStage;
		this.model = model;
		
		// 4
		BorderPane root = new BorderPane();
		// 4.1
		root.setTop(menus); 
		menus.getMenus().add(menuFile);
		menuFile.getItems().add(miAbout);
		// 4.2
		rightPane.getChildren().add(lblGameOver);
		root.setRight(rightPane);
		// 11
		rightPane.getStyleClass().add("vbox");
		
		// 4.3
		root.setCenter(gameGrid);
		
		// 5
		Scene scene = new Scene(root);
		stage.setTitle("Mines Game");
		//scene.getStylesheets().add(getClass().getResource("mines.css").toExternalForm());
		stage.setScene(scene);
	}

	public void start() {
		// 6
		stage.show();
		
	}

	// 7
	// Methode wird vom "Controller" aufgerufen
	// input: Breite und Höhe 
	// output: void
	protected void newGame(int width, int height) {
		gameGrid.getChildren().clear(); // "Säubert" das letzte Spielfeld
		buttons = new Button[height][width]; // 7.1
		for (int row = 0; row < height; row++) { // 7.2
			for (int col = 0; col < width; col++) {
				Button btn = new Button(); // 7.3
				buttons[row][col] = btn;  // 7.4
				gameGrid.add(btn, col, row); // 7.5
			}
		}
	}

	// 14
	public void showBoom() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Boom!"); // Titel
		alert.setHeaderText("You hit a mine!"); // What happen
		alert.setContentText("Game over, you lose!"); // Consequenz
		alert.showAndWait(); // Programm stops till user prove that he saw the Alert
		
	}
}
