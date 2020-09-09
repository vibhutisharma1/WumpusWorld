/*
 * Vibhuti Sharma
 */
public class WumpusMap {
	public static final int NUM_ROWS = 10;
	public static final int NUM_COLUMN = 10;
	public static final int NUM_PITS = 10;
	public WumpusSquare[][] grid = new WumpusSquare[NUM_ROWS][NUM_COLUMN];
	int ladderC;
	int ladderR;

	public WumpusMap() {
		createMap();
	}

	public void createMap() {
		int wR = 0;
		int wC = 0;

		grid = new WumpusSquare[10][10];

		for (int x = 0; x < 10; x++)

			for (int y = 0; y < 10; y++) {
				grid[x][y] = new WumpusSquare();
			}

		for (int x = 0; x < 10; x++) {
			while (true) {
				wR = (int) (Math.random() * 10) + 0;
				wC = (int) (Math.random() * 10) + 0;
				if (grid[wR][wC].isWumpus() == false && grid[wR][wC].isGold() == false
						&& grid[wR][wC].isLadder() == false && grid[wR][wC].isPit() == false) {
					grid[wR][wC].setPit(true);
					if (wC - 1 >= 0 && grid[wR][wC - 1].isPit() == false) {
						grid[wR][wC - 1].setBreeze(true);
					}
					if (wC + 1 < 10 && grid[wR][wC + 1].isPit() == false) {
						grid[wR][wC + 1].setBreeze(true);
					}
					if (wR + 1 < 10 && grid[wR + 1][wC].isPit() == false) {
						grid[wR + 1][wC].setBreeze(true);
					}
					if (wR - 1 >= 0 && grid[wR - 1][wC].isPit() == false) {
						grid[wR - 1][wC].setBreeze(true);
					}
					break;
				}
			}
		}

		while (true) {
			wC = (int) (Math.random() * 10) + 0;
			wR = (int) (Math.random() * 10) + 0;
			if (/* grid[wR][wC].isWumpus() == false && */grid[wR][wC].isPit() == false
					&& grid[wR][wC].isLadder() == false && grid[wR][wC].isBreeze() == false
					&& grid[wR][wC].isStench() == false) {
				grid[wR][wC].setGold(true);
				break;
			}
		}

		while (true) {
			wC = (int) (Math.random() * 10) + 0;
			wR = (int) (Math.random() * 10) + 0;
			if (grid[wR][wC].isPit() == false && grid[wR][wC].isLadder() == false && grid[wR][wC].isBreeze() == false
					&& grid[wR][wC].isStench() == false) {
				grid[wR][wC].setWumpus(true);
				if (wC - 1 >= 0) {
					grid[wR][wC - 1].setStench(true);
				}
				if (wC + 1 <= 9) {
					grid[wR][wC + 1].setStench(true);
				}
				if (wR + 1 <= 9) {
					grid[wR + 1][wC].setStench(true);
				}
				if (wR - 1 >= 0) {
					grid[wR - 1][wC].setStench(true);
				}
				break;
			}
		}

		while (true) {
			wC = (int) (Math.random() * 10) + 0;
			wR = (int) (Math.random() * 10) + 0;
			ladderC = wC;
			ladderR = wR;
			if (grid[wR][wC].isGold() == false && grid[wR][wC].isWumpus() == false
					&& grid[wR][wC].isPit() == false/* &&grid[wR][wC].isLadder()==false */) {
				grid[ladderR][ladderC].setLadder(true);
				break;
			}
		}
	}

	public int getLadderCol() {
		return ladderC;
	}

	public int getLadderRow() {
		return ladderR;
	}

	public WumpusSquare getSquare(int col, int row) {
		if (col < 10 || row < 10)
			return grid[row][col];
		return null;
	}

	public String toString() {
		String s = "a";
		for (int r = 0; r < 10; r++) {
			WumpusSquare[] row = grid[r];
			for (int c = 0; c < 10; c++) {
				if (row[c] != null)
					System.out.print(row[c] + "");
			}
			System.out.print("\n");
		}
		return s;
	}
}
