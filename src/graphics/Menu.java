package graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Menu {

	// private Rectangle[] rect;

	public Menu() {
		// rect = new Rectangle[3];
		// rect[0] = new Rectangle((Window.WIDTH / 2) - 50, (Window.HEIGHT / 2)
		// - 90, 100, 50);
		// rect[1] = new Rectangle((Window.WIDTH / 2) - 85, (Window.HEIGHT / 2)
		// - 30, 170, 50);
		// rect[2] = new Rectangle((Window.WIDTH / 2) - 40, (Window.HEIGHT / 2)
		// + 30, 85, 40);
	}

	public void render(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);

		Graphics2D g2d = (Graphics2D) g;

		g2d.setColor(Color.white);
		g2d.setFont(new Font("Arial", Font.PLAIN, 50));

		g2d.drawString("Play", (Game.WIDTH / 2) - 50, (Game.HEIGHT / 2) - 50);
		g2d.drawString("Play", (Game.WIDTH / 2) - 50, (Game.HEIGHT / 2) - 50);
		// g2d.draw(rect[0]);
		g2d.drawString("Options", (Game.WIDTH / 2) - 85, (Game.HEIGHT / 2) + 10);
		// g2d.draw(rect[1]);

		g2d.drawString("Exit", (Game.WIDTH / 2) - 40, (Game.HEIGHT / 2) + 70);
		// g2d.draw(rect[2]);
	}

	public void update() {

	}

}
