package tools;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Entity {
	protected static int w, h, vel;
	protected int x, y;
	public static int playerhit = 1 + (int) (Math.random() * 2);

	public abstract void render(Graphics g);

	public abstract void update();

	protected abstract Rectangle getRect();

}
