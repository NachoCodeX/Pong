package graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import tools.Entity;

public class Player2 extends Entity {
	private static boolean kup, kdown, move;

	public Player2() {
		x = Game.WIDTH + 140;
		y = Game.HEIGHT / 2;
		w = 10;
		h = 80;
		vel = 10;
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x, y, w, h);

	}

	@Override
	public void update() {

		move();
		collision();
	}

	private void collision() {
		if (y >= 445) {
			y = 445;

		} else if (y < 45) {
			y = 45;
		}

		if (getRect().intersects(Ball.getRect())) {
			if (kup) {
				moveUp();

			} else if (kdown) {
				moveDown();
			} else {
				if (!Player.isMove() && Ball.moveUp()) {
					moveUp();
				} else if (!Player.isMove() && Ball.moveDown()) {
					moveDown();
				}
			}
		}
	}

	public Rectangle getRect() {
		return new Rectangle(x, y, w, h);
	}

	private void moveUp() {
		Player.playerhit = 2;
		Ball.setMoveUp(true, Player.playerhit);
	}

	private void moveDown() {
		Player.playerhit = 2;
		Ball.setMoveDown(true, Player.playerhit);
	}

	private void move() {
		if (kup) {
			y -= vel;
			// System.out.println(y);

		} else if (kdown) {
			y += vel;
			// System.out.println(y);

		}
	}

	public static boolean isMove() {
		return move;
	}

	public static void setMove(boolean move) {
		Player2.move = move;
	}

	public static boolean isKup() {
		return kup;
	}

	public static void setKup(boolean kup) {
		Player2.kup = kup;
	}

	public static boolean isKdown() {
		return kdown;
	}

	public static void setKdown(boolean kdown) {
		Player2.kdown = kdown;
	}

}
