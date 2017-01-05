package graphics;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import tools.GameState;
import tools.MouseActions;

public class Window extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;
	private JFrame win;
	public final static int WIDTH = 800, HEIGHT = 600;
	private boolean isRun = true;
	private Thread thread;
	public static GameState gameState;
	private Menu menu;

	public Window() {
		gameState = GameState.MENU;
		menu = new Menu();
		setWindows();
	}

	private void setWindows() {

		win = new JFrame("Pong");
		win.setSize(WIDTH, HEIGHT);
		win.setResizable(false);
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		win.setLocationRelativeTo(null);

		this.addMouseListener(new MouseActions());

		win.add(this);

		win.setVisible(true);
	}

	public void start() {
		thread = new Thread(this);
		thread.start();
	}

	private void update() {
		if (gameState == GameState.MENU) {
			menu.update();
		} else if (gameState == GameState.GAME) {

		}
	}

	private void render() {
		BufferStrategy bs = this.getBufferStrategy();

		if (bs == null) {
			this.createBufferStrategy(2);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		if (gameState == GameState.MENU) {
			menu.render(g);
		} else if (gameState == GameState.GAME) {

			g.setColor(Color.BLACK);
			g.fillRect(0, 0, WIDTH + 200, HEIGHT);
			win.setSize(WIDTH + 200, HEIGHT);
		} else if (gameState == GameState.OPTIONS) {
			g.setColor(Color.BLUE);
			g.fillRect(0, 0, WIDTH, HEIGHT);
		}

		g.dispose();
		bs.show();

	}

	@Override
	public void run() {
		// El ultimo tiempo
		long lastTime = System.nanoTime();
		// Cuantos Nano-segundos tiene un segundo
		final int NS_SEG = 1000000000;
		// Las actualizaciones por segundo que queremos
		final double APS = 60.0;

		// Una operacion que nos dice cuantos NS hay por cada actualizacion
		final double NS_POR_APS = NS_SEG / APS;
		//
		double tiempoTranscurrido = 0.0;

		double delta = 0.0;

		// Imprimir las FPS y APS
		long verificarFPS = System.nanoTime();

		int aps = 0, fps = 0;

		while (isRun) {
			long now = System.nanoTime();

			tiempoTranscurrido = now - lastTime;
			lastTime = now;

			delta += tiempoTranscurrido / NS_POR_APS;

			if (delta >= 1) {
				delta--;
				// update
				update();
				aps++;
			}

			render();
			fps++;

			if (System.nanoTime() - verificarFPS >= NS_SEG) {
				verificarFPS = System.nanoTime();
				win.setTitle("FPS: " + fps + " || APS: " + aps);
				aps = 0;
				fps = 0;
			}

		}

	}

}
