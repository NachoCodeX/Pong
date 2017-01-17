package graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public final class Ball {

	private static int x, y, w, h, vel;
	private static boolean moveup, movedown;
	private static int velx, vely;
	private Rectangle[] rect;

	public Ball() {
		x = (Game.WIDTH + 200) / 2;
		y = Game.HEIGHT / 2;
		vel = 5;
		w = h = 20;

		moveup = movedown = false;
		rect = new Rectangle[2];
		rect[0] = new Rectangle(20, 35, Game.WIDTH + 150, 5);
		rect[1] = new Rectangle(20, Game.HEIGHT - 70, Game.WIDTH + 150, 5);
	}

	public void render(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillOval(x, y, w, h);
		g.drawRect(x, y, w, h);
		g.setColor(Color.GREEN);

	}

	public static Rectangle getRect() {
		return new Rectangle(x, y, w, h);
	}

	public void update() {
		if (moveUp() && !moveDown()) {
			x += (velx) * vel;
			y += (vely) * vel;
			if (getRect().intersects(rect[0])) {
				setMoveDown(true, Player.playerhit);
				System.out.println(":<");
			}
		} else if (moveDown() && !moveUp()) {
			x += (velx) * vel;
			y += (vely) * vel;

			if (getRect().intersects(rect[1])) {
				setMoveUp(true, Player.playerhit);
				System.out.println(":c");
			}
		} else if (Player.isSpace()) {
			int rand = 1 + (int) (Math.random() * 20);
			System.out.println(Player.playerhit);

			if (rand == 0) {
				setMoveDown(true, Player.playerhit);
			} else {

				setMoveUp(true, Player.playerhit);
			}

		}

		point();
	}

	private void point() {
		if (x > Game.WIDTH + 170) {
			x = (Game.WIDTH + 200) / 2;
			y = Game.HEIGHT / 2;
			moveup = false;
			movedown = false;
		} else if (x < 0) {
			x = (Game.WIDTH + 200) / 2;
			y = Game.HEIGHT / 2;
			moveup = false;
			movedown = false;
		}
	}

	public static boolean moveUp() {
		return moveup;
	}

	public static boolean moveDown() {
		return movedown;
	}

	public static void setMoveUp(boolean moveup, int args) {
		Ball.moveup = moveup;
		movedown = false;

		switch (args) {
		case 1: {
			velx = 1;
			vely = -1;
			break;
		}

		case 2: {
			velx = -1;
			vely = -1;
			break;
		}

		}

	}

	public static void setMoveDown(boolean movedown, int args) {
		Ball.movedown = movedown;
		moveup = false;

		switch (args) {
		case 1: {
			velx = 1;
			vely = 1;
			break;
		}

		case 2: {
			velx = -1;
			vely = 1;
			break;
		}
		}

	}

	// public static boolean getMoveup() {
	// return Ball.moveup;
	// }
	//
	// public static boolean getMoveDown() {
	// return Ball.movedown;
	// }

}
