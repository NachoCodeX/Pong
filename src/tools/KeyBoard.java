package tools;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import graphics.Player;
import graphics.Player2;

public class KeyBoard implements KeyListener {

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();

		if (code == KeyEvent.VK_W) {
			Player.setKup(true);
			Player.setMove(true);

		} else if (code == KeyEvent.VK_S) {
			Player.setKdown(true);
			Player.setMove(true);
		}

		if (code == KeyEvent.VK_UP) {
			Player2.setKup(true);
			Player2.setMove(true);
		} else if (code == KeyEvent.VK_DOWN) {
			Player2.setKdown(true);
			Player2.setMove(true);
		}

		if (code == KeyEvent.VK_SPACE && !Player.isMove()) {
			Player.setSpace(true);
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		Player.setKdown(false);
		Player.setKup(false);

		Player2.setKdown(false);
		Player2.setKup(false);

		Player.setMove(false);
		Player2.setMove(false);

		Player.setSpace(false);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
