package tools;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import graphics.Game;

public class MouseActions implements MouseListener {
	private boolean aux = false;

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

		int mx = e.getX(), my = e.getY(), playx = (Game.WIDTH / 2) - 50, playy = (Game.HEIGHT / 2) - 90,
				optionx = (Game.WIDTH / 2) - 85, optiony = (Game.HEIGHT / 2) - 30, ex = (Game.WIDTH / 2) - 40,
				ey = (Game.HEIGHT / 2) + 30;

		if (mx >= playx && mx <= playx + 100 && my >= playy && my <= playy + 50 && !aux) {
			System.out.println("Play");
			Game.gameState = GameState.SELECTGAME;
			aux = true;
		} else if (mx >= optionx && mx <= optionx + 170 && my >= optiony && my <= optiony + 50 && !aux) {
			System.out.println("Option");
			Game.gameState = GameState.OPTIONS;
		} else if (mx >= ex && mx <= ex + 85 && my >= ey && my <= ey + 40 && !aux) {
			System.out.println("Exit");
			System.exit(0);
		} else {
			int x = (Game.WIDTH / 2) - 150, y = (Game.HEIGHT / 2) - 100;

			if (mx >= 10 && mx <= 160 && my >= 10 && my <= 30) {
				System.out.println("Menu");
				Game.gameState = GameState.MENU;
				aux = false;
			} else if (mx >= x && mx <= x + 215 && my >= y - 25 && my <= y + 5) {

				Game.gameState = GameState.GAME;
			} else if (mx >= x && mx <= x + 285 && my >= y + 15 && my <= y + 45) {
				System.out.println("PLAY EASY");
			} else if (mx >= x && mx <= x + 325 && my >= y + 55 && my <= y + 85) {
				System.out.println("PLAY MEDIUM");
			} else if (mx >= x && mx <= x + 295 && my >= y + 95 && my <= y + 125) {
				System.out.println("PLAY HARD");
			}
		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
