package tools;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import graphics.Player;

public class KeyBoard implements KeyListener {

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();

		if (code == KeyEvent.VK_UP) {
			Player.kup = true;
		} else if (code == KeyEvent.VK_DOWN) {
			Player.kdown = true;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		Player.kup = false;
		Player.kdown = false;

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
