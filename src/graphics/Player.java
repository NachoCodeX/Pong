package graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import tools.Entity;

public final class Player extends Entity {

	// private int w, h, x, y, vel;
	private static boolean kup, kdown, move, space;
	public static int points;

	public Player() {
		points = 0;
		w = 10;
		h = 80;
		x = 40;
		y = Game.HEIGHT / 2;
		vel = 0;
		kup = kdown = move = false;
	}

	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x, y, w, h);

	}

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

	private void moveUp() {
		Player.playerhit = 1;
		Ball.setMoveUp(true, Player.playerhit);
	}

	private void moveDown() {

		Player.playerhit = 1;
		Ball.setMoveDown(true, Player.playerhit);
	}

	public Rectangle getRect() {
		return new Rectangle(x, y, w, h);
	}

	private void move() {
		if (kup) {
			y -= vel;

		} else if (kdown) {
			y += vel;

		}

	}

	public static boolean isKup() {
		return kup;
	}

	public static void setKup(boolean kup) {
		Player.kup = kup;
	}

	public static boolean isKdown() {
		return kdown;
	}

	public static void setKdown(boolean kdown) {
		Player.kdown = kdown;
	}

	public static boolean isMove() {
		return move;
	}

	public static void setMove(boolean move) {
		Player.move = move;
	}

	public static boolean isSpace() {
		return space;
	}

	public static void setSpace(boolean space) {
		Player.space = space;
	}

	public static void setVel(int vel) {
		Player.vel = vel;
	}

}
