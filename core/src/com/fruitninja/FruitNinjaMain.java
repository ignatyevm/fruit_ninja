package com.fruitninja;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.fruitninja.view.GameScreen;
import com.fruitninja.view.MainMenuScreen;

public class FruitNinjaMain extends Game {

    public static Game game = null;

    @Override
    public void create() {
        if (game == null) {
            game = this;
        }
        this.setScreen(new MainMenuScreen());
    }

}
