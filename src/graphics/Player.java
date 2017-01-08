package graphics;

import java.awt.Color;
import java.awt.Graphics;

public class Player {

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
		if (y >= 445) {
			y = 445;

		} else if (y < 45) {
			y = 45;
		}

		if (kup) {
			y -= vel;
			System.out.println(y);
		} else if (kdown) {
			y += vel;
			System.out.println(y);
		}
	}

}
