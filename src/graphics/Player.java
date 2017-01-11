package graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public final class Player {

	private int w, h, x, y, vel;
	public static boolean kup, kdown;

	public Player() {
		w = 10;
		h = 80;
		x = 40;
		y = Game.HEIGHT / 2;
		vel = 10;
		kup = kdown = false;
	}

	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x, y, w, h);

	}

	public void update() {
		collision();
		move();
	}

	private void collision() {
		if (y >= 445) {
			y = 445;

		} else if (y < 45) {
			y = 45;
		}

		if (getRect().intersects(Ball.getRect())) {
			if (kup) {
				Ball.setMoveUp(true, (byte) 1, (byte) -1);
			} else if (kdown) {
				Ball.setMoveDown(true, (byte) 1, (byte) 1);
			}
		}

	}

	public Rectangle getRect() {
		return new Rectangle(x, y, w, h);
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

}
