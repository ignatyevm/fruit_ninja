package com.fruitninja.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.TimeUtils;
import com.fruitninja.FruitNinjaMain;
import com.fruitninja.model.fruit.BananaFruit;
import com.fruitninja.model.fruit.Fruit;
import com.fruitninja.model.fruit.PineappleFruit;
import com.fruitninja.model.fruit.WatermelonFruit;
import com.fruitninja.view.GameScreen;
import com.fruitninja.view.LoseMenuScreen;

public class GameController {

    private long lastSpawnTime = 0;

    private void spawnFruit() {
        float randomX = MathUtils.random(0f, Gdx.graphics.getWidth() - Fruit.DEFAULT_WIDTH);

        Fruit randomFruit;
        int fruitProbability = MathUtils.random(0 , 10);
        if (fruitProbability >= 0 && fruitProbability <= 4) {
            randomFruit = new WatermelonFruit(randomX, Gdx.graphics.getHeight());
        } else if (fruitProbability >= 5 && fruitProbability <= 7){
            randomFruit = new BananaFruit(randomX, Gdx.graphics.getHeight());
        } else {
            randomFruit = new PineappleFruit(randomX, Gdx.graphics.getHeight());
        }

        GameScreen.fruits.add(randomFruit);

        lastSpawnTime = TimeUtils.millis();
    }

    public static int health = 5;
    public static int score = 0;

    public void handle() {

        if (health <= 0) {
            FruitNinjaMain.game.setScreen(new LoseMenuScreen());
        }

        if (TimeUtils.millis() - lastSpawnTime > MathUtils.random(700, 2000)) spawnFruit();

        if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
            float x = Gdx.input.getX();
            float y = Gdx.graphics.getHeight() - Gdx.input.getY();
            for (Fruit fruit : GameScreen.fruits) {
                if (fruit.getBounds().contains(x, y)) {
                    fruit.health--;
                    if (fruit.health <= 0) {
                        score++;
                        GameScreen.fruits.remove(fruit);
                    }
                    break;
                }
            }
        }

        for (Fruit fruit : GameScreen.fruits) {
            fruit.getBounds().y -= fruit.getSpeed() * Gdx.graphics.getDeltaTime();
            if (fruit.getBounds().y + Fruit.DEFAULT_HEIGHT < 0) {
                health--;
                GameScreen.fruits.remove(fruit);
                break;
            }
        }

    }

}
