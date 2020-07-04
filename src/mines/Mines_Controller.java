package mines;

//Planung und Design - START
public class Mines_Controller {
	private Mines_Model model;
	private Mines_View view;
	
	// The controller is responsible for width and height of the game grid.
	// Initially, these will be constants. Later, they may be taken from the
	// View as game options chosen by the player.
	private int width = 10;
	private int height = 8;

	public Mines_Controller(Mines_Model model, Mines_View view) {
		this.model = model;
		this.view = view;
		
		this.newGame();
	}

	private void newGame() {
		model.newGame(width, height);
		view.newGame(width, height);
	}
}
//Planung und Design - ENDE