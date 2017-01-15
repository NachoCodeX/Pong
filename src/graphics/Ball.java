package graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public final class Ball {

	private static int x, y, w, h, vel;
	private static boolean moveup, movedown;
	private static byte velx, vely;
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
		// g.drawRect(rect[1].x, rect[1].y, rect[1].width, rect[1].height);
	}

	public static Rectangle getRect() {
		return new Rectangle(x, y, w, h);
	}

	public void update() {
		if (moveUp() && !moveDown()) {
			x += (velx) * vel;
			y += (vely) * vel;
			if (getRect().intersects(rect[0])) {
				setMoveDown(true, (byte) 1, (byte) 1);
				System.out.println(":<");
			}
		} else if (moveDown() && !moveUp()) {
			x += (velx) * vel;
			y += (vely) * vel;

			if (getRect().intersects(rect[1])) {
				setMoveUp(true, (byte) 1, (byte) -1);
				System.out.println(":c");
			}
		} else {
			x -= vel;

		}
	}

	private boolean moveUp() {
		return moveup;
	}

	private boolean moveDown() {
		return movedown;
	}

	public static void setMoveUp(boolean moveup, byte... velxy) {
		Ball.moveup = moveup;
		movedown = false;
		velx = velxy[0];
		vely = velxy[1];
	}

	public static void setMoveDown(boolean movedown, byte... velxy) {
		Ball.movedown = movedown;
		moveup = false;
		velx = velxy[0];
		vely = velxy[1];
	}

	public static boolean getMoveup() {
		return Ball.moveup;
	}

	public static boolean getMoveDown() {
		return Ball.movedown;
	}

}
