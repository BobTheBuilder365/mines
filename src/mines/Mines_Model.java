package mines;

// 11 		Initialisiert neues Spielfeld
// 11.1		Platziert Bomben
// 12 		Initialisiert neues Spielfeld
// 12.1		Platziert Bomben
// 13		Own Exception class, which happen, when Mine was found

// 15		S
// 15.1		Count the mines, when a Field is revealed
//			Maximum is 8 cells around the revealed Cell

// Start
public class Mines_Model {

	// 11
	private class Cell {
		public boolean isMine = false;
		public boolean isRevealed = false;
	}
	
	// 13
	public static class Boom extends Exception{
		public Boom() {
			super("Mine found!");
		}
	}

	// 11.1
	private Cell[][] gameBoard;

	// 12
	protected void newGame(int width, int height) {
		gameBoard = new Cell[height][width]; // 1D = reihen 2D= Spalten
		for (int row = 0; row < height; row++) { // In jeder Reiehe
			for (int col = 0; col < width; col++) { // für jede Spalte
				gameBoard[row][col] = new Cell();
			}
		}
		// 12.1
		for (int i = 0; i < width * height / 6; i++) {
			int row = (int) (Math.random() * height);
			int col = (int) (Math.random() * width);
			gameBoard[row][col].isMine = true;
		}
	}

	// 15
	protected int revealCell(int row, int col) throws Boom {
		// Game over if Mine is there
		if (gameBoard[row][col].isMine) throw new Boom();
		gameBoard[row][col].isRevealed = true;
		return countMines(row, col);
	}

	// 15.1
	private int countMines(int row, int col) {
		int minRow = Math.max(-1, 0);
		int maxRow = Math.min(gameBoard.length - 1, row + 1);
		int minCol = Math.max(0, col - 1);
		int maxCol = Math.min(gameBoard[0].length - 1, col + 1);
		// How many Mines are there?
		int count = 0;
		
		// Von der ersten Reihe bis zur letzten Reihe
		for (int r = minRow; r <= maxRow; r++) {
			// In dieser Reihe von der ersten Spalte bis zur letzten Spalte
			for (int c = minCol; c <= maxCol;c++) {
				// Zählen
				if (gameBoard[r][c].isMine) count++;
				
			}
		}
		return count;
	}

}
