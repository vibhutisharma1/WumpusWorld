import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;

/*
 * Vibhuti Sharma
 */
public class WumpusPanel extends JPanel implements KeyListener {
	public static final int PLAYING = 0;
	public static final int DEAD = 1;
	public static final int WON = 2;
	int status;
	WumpusPlayer player;
	WumpusMap map;
	private BufferedImage arrow;
	private BufferedImage black;
	private BufferedImage gold;
	private BufferedImage ladder;
	private BufferedImage pit;
	private BufferedImage breeze;
	private BufferedImage wumpus;
	private BufferedImage deadWumpus;
	private BufferedImage stench;
	private BufferedImage playerUp;
	private BufferedImage playerDown;
	private BufferedImage playerLeft;
	private BufferedImage playerRight;
	private BufferedImage floor;
	boolean win = false;// win
	boolean kill = false;// kill wumpus
	boolean cheat = false;// hack
	boolean firstb = false;

	public WumpusPanel() {
		super();
		setSize(700, 700);
		addKeyListener(this);
		try {

			ladder = ImageIO.read((new File("Wumpus World Images/ladder.gif")));
			arrow = ImageIO.read((new File("Wumpus World Images/arrow.gif")));
			black = ImageIO.read((new File("Wumpus World Images/black.GIF")));
			breeze = ImageIO.read((new File("Wumpus World Images/breeze.gif")));
			deadWumpus = ImageIO.read((new File("Wumpus World Images/deadWumpus.GIF")));
			gold = ImageIO.read((new File("Wumpus World Images/gold.gif")));
			pit = ImageIO.read((new File("Wumpus World Images/pit.gif")));
			playerDown = ImageIO.read((new File("Wumpus World Images/playerDown.png")));
			playerLeft = ImageIO.read((new File("Wumpus World Images/playerLeft.png")));
			playerRight = ImageIO.read((new File("Wumpus World Images/playerRight.png")));
			playerUp = ImageIO.read((new File("Wumpus World Images/playerUp.png")));
			stench = ImageIO.read((new File("Wumpus World Images/stench.gif")));
			wumpus = ImageIO.read((new File("Wumpus World Images/wumpus.gif")));
			System.out.println("All the images printed.");

		} catch (Exception e) {
			e.printStackTrace();
		}
		reset();
		System.out.println(map.toString());
	}

	public void reset() {
		status = PLAYING;
		map = new WumpusMap();
		player = new WumpusPlayer();
		player.setRowPosistion(map.getLadderRow());
		player.setColPosition(map.getLadderCol());
		cheat = false;
	}

	public void paint(Graphics g) {
		Font s = new Font("Times New Roman", Font.BOLD, 23);
		Font q = new Font("Times New Roman", Font.BOLD, 18);
		g.setFont(s);

		g.setColor(Color.GRAY);
		g.fillRect(0, 0, 700, 700);
		for (int x = 0; x < 10; x++) {
			for (int y = 0; y < 10; y++) {
				g.drawImage(floor, 50 * x + 100, 50 * y + 50, null);
			}
		}

		g.setColor(Color.BLACK);

		g.fillRect(0, 600, 175, 100);

		g.fillRect(180, 600, 800, 100);

		g.setColor(Color.GREEN);
		g.drawString("Messages", 190, 625);
		g.drawString("Inventory", 5, 625);

		for (int r = 0; r < 10; r++) {
			for (int c = 0; c < 10; c++) {
				if (map.getSquare(r, c).isWumpus() == true) {
					g.drawImage(wumpus, r * 50 + 100, c * 50 + 50, null);
				} else if (map.getSquare(r, c).isDeadWumpus() == true) {
					g.drawImage(deadWumpus, r * 50 + 100, c * 50 + 50, null);
				}
			}
		}
		for (int r = 0; r < 10; r++) {
			for (int c = 0; c < 10; c++) {
				if (map.getSquare(r, c).isBreeze() == true) {
					g.drawImage(breeze, r * 50 + 100, c * 50 + 50, null);
				}
			}
		}
		for (int r = 0; r < 10; r++) {
			for (int c = 0; c < 10; c++) {
				if (map.getSquare(r, c).isStench() == true) {
					g.drawImage(stench, r * 50 + 100, c * 50 + 50, null);
				}
				if (player.isArrow() == true) {
					g.drawImage(arrow, 10, 635, null);
				}
			}
		}
		for (int r = 0; r < 10; r++) {
			for (int c = 0; c < 10; c++) {
				if (map.getSquare(r, c).isLadder() == true) {
					g.drawImage(ladder, r * 50 + 100, c * 50 + 50, null);
					map.getSquare(r, c).setVisited(true);
				}

			}
		}
		for (int r = 0; r < 10; r++) {
			for (int c = 0; c < 10; c++) {
				if (map.getSquare(r, c).isGold() == true) {
					g.drawImage(gold, r * 50 + 100, c * 50 + 50, null);
				}
				if (player.isGold() == true) {
					g.drawImage(gold, 75, 635, null);
				}
			}
		}
		for (int r = 0; r < 10; r++) {
			for (int c = 0; c < 10; c++) {
				if (map.getSquare(r, c).isPit() == true) {
					g.drawImage(pit, r * 50 + 100, c * 50 + 50, null);
				}
			}
		}

		g.setColor(Color.RED);
		g.setFont(q);
		int x = 639;
		for (int r = 0; r < 10; r++) {
			for (int c = 0; c < 10; c++) {
				if (map.getSquare(r, c) == map.getSquare(player.isRowPosition(), player.getColPosition())) {
					if (player.getDirection() == 0) {
						g.drawImage(playerUp, player.getColPosition() * 50 + 100, player.isRowPosition() * 50 + 50,
								null);
						// System.out.println(player.isRowPosition());
						// System.out.println(player.isColPosition());
					} else if (player.getDirection() == 1) {
						g.drawImage(playerRight, player.getColPosition() * 50 + 100, player.isRowPosition() * 50 + 50,
								null);
						// System.out.println(player.isRowPosition());
						// System.out.println(player.isColPosition());
					} else if (player.getDirection() == 2) {
						g.drawImage(playerDown, player.getColPosition() * 50 + 100, player.isRowPosition() * 50 + 50,
								null);
						// System.out.println(player.isRowPosition());
						// System.out.println(player.isColPosition());
					} else if (player.getDirection() == 3) {
						g.drawImage(playerLeft, player.getColPosition() * 50 + 100, player.isRowPosition() * 50 + 50,
								null);
						// System.out.println(player.isRowPosition());
						// System.out.println(player.isColPosition());
					}
					if (map.getSquare(c, r).isPit() == true) {
						g.drawString("You fell down a pit, to your death(n for new game)", 190, 640);
					} else if (map.getSquare(c, r).isWumpus() == true) {
						g.drawString("You are eaten by the Wumpus./n (n for new game)", 190, 640);
					} else if (win != false) {
						g.drawString("You win/n (N for new game)", 190, 640);
					} else if (map.getSquare(c, r).isPit() == false && map.getSquare(c, r).isWumpus() == false) {
						if (map.getSquare(c, r).isLadder() == true) {
							if (x == 639)
								x = 640;
							else if (x == 640)
								x = 655;
							else if (x == 655)
								x = 670;
							else if (x == 670)
								x = 685;
							g.drawString("You bump into a ladder", 190, x);
						}
						if (map.getSquare(c, r).isBreeze() == true) {
							if (x == 639)
								x = 640;
							else if (x == 640)
								x = 655;
							else if (x == 655)
								x = 670;
							else if (x == 670)
								x = 685;
							g.drawString("You feel a breeze.", 190, x);
						}
						if (map.getSquare(c, r).isStench() == true) {
							if (x == 639)
								x = 640;
							else if (x == 640)
								x = 655;
							else if (x == 655)
								x = 670;
							else if (x == 670)
								x = 685;
							g.drawString("You smell a stench.", 190, x);
						}
						if (map.getSquare(c, r).isGold() == true) {
							if (x == 639)
								x = 640;
							else if (x == 640)
								x = 655;
							else if (x == 655)
								x = 670;
							else if (x == 670)
								x = 685;
							g.drawString("You see a glimmer.", 190, x);
						}
						if (kill == true) {
							if (x == 639)
								x = 640;
							else if (x == 640)
								x = 655;
							else if (x == 655)
								x = 670;
							else if (x == 670)
								x = 685;
							g.drawString("You hear a scream", 190, x);
							kill = false;
						}
					}
				}
			}
		}
		for (int r = 0; r < 10; r++) {
			for (int c = 0; c < 10; c++) {
				if (map.getSquare(r, c).isVisited() != true) {
					if (cheat == false) {
						g.drawImage(black, r * 50 + 100, c * 50 + 50, null);
					}
				}
			}
		}
	}

	public void keyTyped(KeyEvent e) {
		char key = e.getKeyChar();

		if (key == 'w') {
			if (player.isRowPosition() == 0
					|| map.getSquare(player.getColPosition(), player.isRowPosition()).isPit() == true
					|| map.getSquare(player.getColPosition(), player.isRowPosition()).isWumpus() == true
					|| win == true) {
				player.setRowPosistion(player.isRowPosition());
			} else {
				player.setDirection(0);
				player.setRowPosistion(player.isRowPosition() - 1);
			}
		}

		else if (key == 's') {
			if (player.isRowPosition() == 9
					|| map.getSquare(player.getColPosition(), player.isRowPosition()).isPit() == true
					|| map.getSquare(player.getColPosition(), player.isRowPosition()).isWumpus() == true
					|| win == true) {
				player.setRowPosistion(player.isRowPosition());
			} else {
				player.setDirection(2);
				player.setRowPosistion(player.isRowPosition() + 1);
			}
		}

		else if (key == 'a') {
			if (player.getColPosition() == 0
					|| map.getSquare(player.getColPosition(), player.isRowPosition()).isPit() == true
					|| map.getSquare(player.getColPosition(), player.isRowPosition()).isWumpus() == true
					|| win == true) {
				player.setColPosition(player.getColPosition());
			} else {
				player.setDirection(3);
				player.setColPosition(player.getColPosition() - 1);
			}
		}

		else if (key == 'd') {
			if (player.getColPosition() == 9
					|| map.getSquare(player.getColPosition(), player.isRowPosition()).isPit() == true
					|| map.getSquare(player.getColPosition(), player.isRowPosition()).isWumpus() == true
					|| win == true) {
				player.setColPosition(player.getColPosition());
			} else {
				player.setDirection(1);
				player.setColPosition(player.getColPosition() + 1);
			}
		}
		if (key == 'n' && map.getSquare(player.getColPosition(), player.isRowPosition()).isPit() == true) {
			player.setGold(false);
			reset();
		}
		if (key == 'n' && map.getSquare(player.getColPosition(), player.isRowPosition()).isWumpus() == true) {
			player.setGold(false);
			reset();
		}
		if (key == 'n' && win == true) {
			player.setGold(false);
			win = false;
			reset();
		}
		if (key == 'p' && map.getSquare(player.getColPosition(), player.isRowPosition()).isGold() == true) {
			map.getSquare(player.getColPosition(), player.isRowPosition()).setGold(false);
			player.setGold(true);
		}
		if (key == 'c' && player.isGold() == true
				&& map.getSquare(player.getColPosition(), player.isRowPosition()).isLadder() == true) {
			win = true;
		}
		if (key == 'i' && player.isArrow() == true) {
			for (int r = (player.isRowPosition() - 1); r >= 0; r--) {
				if (map.getSquare(player.getColPosition(), r).isWumpus() == true) {
					map.getSquare(player.getColPosition(), r).setDeadWumpus(true);
					map.getSquare(player.getColPosition(), r).setWumpus(false);
					kill = true;
					break;
				}
			}
			player.setDirection(0);
			player.setArrow(false);
		} else if (key == 'k' && player.isArrow() == true) {
			for (int r = (player.isRowPosition() + 1); r <= 9; r++) {
				if (map.getSquare(player.getColPosition(), r).isWumpus() == true) {
					map.getSquare(player.getColPosition(), r).setDeadWumpus(true);
					map.getSquare(player.getColPosition(), r).setWumpus(false);
					kill = true;
					break;
				}
			}
			player.setDirection(2);
			player.setArrow(false);
		} else if (key == 'j' && player.isArrow() == true) {
			for (int r = (player.getColPosition() - 1); r >= 0; r--) {
				if (map.getSquare(r, player.isRowPosition()).isWumpus() == true) {
					map.getSquare(r, player.isRowPosition()).setDeadWumpus(true);
					map.getSquare(r, player.isRowPosition()).setWumpus(false);
					kill = true;
					break;
				}
			}
			player.setDirection(3);
			player.setArrow(false);
		} else if (key == 'l' && player.isArrow() == true) {
			for (int r = (player.getColPosition() + 1); r <= 9; r++) {
				if (map.getSquare(r, player.isRowPosition()).isWumpus() == true) {
					map.getSquare(r, player.isRowPosition()).setDeadWumpus(true);
					map.getSquare(r, player.isRowPosition()).setWumpus(false);
					kill = true;
					break;
				}
			}
			player.setDirection(1);
			player.setArrow(false);
		}
		if (key == '*' && firstb != true) {
			cheat = true;
			firstb = true;
		} else if (firstb == true && key == '*') {
			cheat = false;
			firstb = false;
		}
		map.getSquare(player.getColPosition(), player.isRowPosition()).setVisited(true);
		repaint();
	}

	public void keyPressed(KeyEvent e) {

	}

	public void keyReleased(KeyEvent e) {

	}

	public void addNotify() {
		super.addNotify();
		requestFocus();
	}
}