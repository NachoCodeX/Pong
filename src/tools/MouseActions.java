package tools;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import graphics.Window;

public class MouseActions implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		int mx = e.getX(), my = e.getY(), playx = (Window.WIDTH / 2) - 50, playy = (Window.HEIGHT / 2) - 90,
				optionx = (Window.WIDTH / 2) - 85, optiony = (Window.HEIGHT / 2) - 30, ex = (Window.WIDTH / 2) - 40,
				ey = (Window.HEIGHT / 2) + 30;

		if (mx >= playx && mx <= playx + 100 && my >= playy && my <= playy + 50) {
			System.out.println("Play");
			Window.gameState = GameState.GAME;
		} else if (mx >= optionx && mx <= optionx + 170 && my >= optiony && my <= optiony + 50) {
			System.out.println("Option");
			Window.gameState = GameState.OPTIONS;
		} else if (mx >= ex && mx <= ex + 85 && my >= ey && my <= ey + 40) {
			System.out.println("Exit");
			System.exit(0);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
