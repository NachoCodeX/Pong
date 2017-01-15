package tools;

public enum GameState {
	MENU, SELECTGAME, PAUSE, OPTIONS, GAME, GAMECPU, SELECTMODE;

	private int dificulty;

	public int getDificulty() {
		return dificulty;
	}

	public void setDificulty(int dificulty) {
		this.dificulty = dificulty;
	}

}
