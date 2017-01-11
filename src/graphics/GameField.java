package graphics;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;

public class GameField {

	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;

		g2d.setColor(Color.WHITE);
		Stroke oldstroke = g2d.getStroke();
		g2d.setStroke(new BasicStroke(7));
		g2d.drawRect(20, 35, Game.WIDTH + 150, Game.HEIGHT - 100);
		Stroke dotted = new BasicStroke(7, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[] { 9 }, 0);
		g2d.setStroke(dotted);
		g2d.drawLine(500, Game.HEIGHT - 72, 500, 42);
		g2d.setStroke(oldstroke);

	}

}
