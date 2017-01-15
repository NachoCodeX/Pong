package graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public final class MenuPlay {
	private Rectangle[] rec;
	private int x = (Game.WIDTH / 2) - 150, y = (Game.HEIGHT / 2) - 100;

	public MenuPlay() {
		rec = new Rectangle[5];
		// rec[0] = new Rectangle(x, y - 25, 215, 30);
		rec[1] = new Rectangle(x, y + 15, 285, 30);
		rec[2] = new Rectangle(x, y + 55, 325, 30);
		rec[3] = new Rectangle(x, y + 95, 295, 30);
		rec[4] = new Rectangle(10, 10, 150, 20);

	}

	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.WHITE);
		g2d.setFont(new Font("Arial", Font.PLAIN, 20));
		g2d.drawString("< Menu Principal", 10, 30);
		g2d.setFont(new Font("Arial", Font.PLAIN, 30));
		g2d.drawString("Player vs Player", x, y);
		// g2d.draw(rec[0]);

		g2d.drawString("Player vs CPU(EASY)", x, y + 40);
		// g2d.draw(rec[1]);
		g2d.drawString("Player vs CPU(MEDIUM)", x, y + 80);
		// g2d.draw(rec[2]);
		g2d.drawString("Player vs CPU(HARD)", x, y + 120);
		// g2d.draw(rec[3]);
		// g2d.draw(rec[4]);
	}

}
