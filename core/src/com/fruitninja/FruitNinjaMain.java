package com.fruitninja;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.fruitninja.view.GameScreen;

public class FruitNinjaMain extends Game {

	private Screen gameScreen;

	@Override
	public void create() {
		gameScreen = new GameScreen();
		this.setScreen(gameScreen);
	}

}
