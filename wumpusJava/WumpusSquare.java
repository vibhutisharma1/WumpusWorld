/*
 * Vibhuti Sharma
 */
public class WumpusSquare {
	private boolean ladder;
	private boolean gold;
	private boolean pit;
	private boolean breeze;
	private boolean wumpus;
	private boolean deadWumpus;
	private boolean stench;
	private boolean visited;

	public WumpusSquare() {
		ladder = false;
		gold = false;
		pit = false;
		breeze = false;
		wumpus = false;
		deadWumpus = false;
		stench = false;
		visited = false;
	}

	public boolean isLadder() {
		return ladder;
	}

	public void setLadder(boolean ladder) {
		this.ladder = ladder;
	}

	public boolean isGold() {
		return gold;
	}

	public void setGold(boolean gold) {
		this.gold = gold;
	}

	public boolean isPit() {
		return pit;
	}

	public void setPit(boolean pit) {
		this.pit = pit;
	}

	public boolean isBreeze() {
		return breeze;
	}

	public void setBreeze(boolean breeze) {
		this.breeze = breeze;
	}

	public boolean isWumpus() {
		return wumpus;
	}

	public void setWumpus(boolean wumpus) {
		this.wumpus = wumpus;
	}

	public boolean isDeadWumpus() {
		return deadWumpus;
	}

	public void setDeadWumpus(boolean deadWumpus) {
		this.deadWumpus = deadWumpus;
	}

	public boolean isStench() {
		return stench;
	}

	public void setStench(boolean stench) {
		this.stench = stench;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public String toString() {
		String s = "";
		if (wumpus == false && deadWumpus == false && ladder == false && pit == false && gold == false) {
			s += "*";
		} else if (wumpus == true) {
			s += "W";
		} else if (deadWumpus == true) {
			s += "D";
		} else if (ladder == true) {
			s += "L";
		} else if (pit == true) {
			s += "P";
		} else if (gold == true) {
			s += "G";
		}
		return s;
	}
}