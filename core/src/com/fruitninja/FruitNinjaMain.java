package com.fruitninja;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.fruitninja.view.GameScreen;

public class FruitNinjaMain extends Game {

    public static Game game = null;

    private Screen gameScreen;

    @Override
    public void create() {
        if (game == null) {
            game = this;
        }
        gameScreen = new GameScreen();
        this.setScreen(gameScreen);
    }

}
