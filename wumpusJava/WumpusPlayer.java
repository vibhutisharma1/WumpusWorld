/*
 * Vibhuti Sharma
 */

public class WumpusPlayer {

	public static final int NORTH = 0;
	public static final int EAST = 1;
	public static final int SOUTH = 2;
	public static final int WEST = 3;

	private int direction;
	private boolean arrow;
	private boolean gold;
	private int colPosition;
	private int rowPosition;

	public WumpusPlayer() {
		this.direction = NORTH;
		gold = false;
		arrow = true;
	}

	public static int getNORTH() {
		return NORTH;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public boolean isArrow() {
		return arrow;
	}

	public void setArrow(boolean arrow) {
		this.arrow = arrow;
	}

	public boolean isGold() {
		return gold;
	}

	public void setGold(boolean gold) {
		this.gold = gold;
	}

	public int getColPosition() {
		return colPosition;
	}

	public void setColPosition(int colPosition) {
		this.colPosition = colPosition;
	}

	public int getRowPosistion() {
		return rowPosition;
	}

	public void setRowPosistion(int rowPosistion) {
		this.rowPosition = rowPosistion;
	}

	public static int getEAST() {
		return EAST;
	}

	public static int getSOUTH() {
		return SOUTH;
	}

	public static int getWEST() {
		return WEST;
	}

	public int isRowPosition() {
		return rowPosition;
	}
}