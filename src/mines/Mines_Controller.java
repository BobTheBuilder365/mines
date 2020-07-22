package mines;

import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import mines.Mines_Model.Boom;

// 8	S
// 9	S
// 10	S

// 13	In einem Spiel möchten wir die "Events" der einzelnen Buttons abonnieren
// 13.1	Was soll jetzt passieren, wenn mit der Maus geklickt wird?
//		Müssen im "2D-Array" den gedrücktenb Button finden

// Start
public class Mines_Controller {

	// 8
	private Mines_Model model;
	private Mines_View view;

	// 9
	private int width = 7;
	private int height = 6;

	// START
	public Mines_Controller(Mines_Model model, Mines_View view) {
		this.model = model;
		this.view = view;

		// 10 Neues Spiel starten
		this.newGame();
	}

	// 10 Ruft im "model" und "view" ein neues Spiel auf
	private void newGame() {

		model.newGame(width, height);
		view.newGame(width, height); // 10.1

		// 13
		for (int row = 0; row < height; row++) {
			for (int col = 0; col < width; col++) {
				view.buttons[row][col].setOnMouseClicked(this::mouseClicked); // Buttons, wir möchten deine MouseEvents
			}
		}

	}

	// 13
	private void mouseClicked(MouseEvent e) {
		// 13.1
		int row = -1;
		int col = -1;
		for (int r = 0; row == -1 && r < height;r++) {
			for (int c = 0; col == -1 && c < width; c++) {
				if (e.getSource() == view.buttons[r][c]) {
					row = r; col = c;
				}
			}
		}
		// 14
		// (Left-click, right-click,???)
		if (e.getButton() == MouseButton.PRIMARY) {
			// Ask the "model" if there is a Mine
			try {
				int numMines = model.revealCell(row, col);
				view.buttons[row][col].setText(Integer.toString(numMines));
			} catch (Boom boom) { // When Exception happen, we want to do somethin in the view
				view.showBoom();
			}
		} else if (e.getButton() == MouseButton.SECONDARY) {
			// TODO: Mark this button in UI
		} else {
			// Not interesting, ignore
		}
		
		// TODO: check for game over
	}
}
