package tools;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Entity {
	protected int x, y, w, h, vel;
	public static int playerhit = 1 + (int) (Math.random() * 2);

	public abstract void render(Graphics g);

	public abstract void update();

	protected abstract Rectangle getRect();

}
