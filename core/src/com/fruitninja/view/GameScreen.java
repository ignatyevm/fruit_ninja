package com.fruitninja.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.fruitninja.controller.GameController;
import com.fruitninja.model.fruit.Fruit;
import com.fruitninja.utils.UI;

import java.util.ArrayList;

public class GameScreen implements Screen {

    SpriteBatch batch;
    Texture background;
    OrthographicCamera camera;
    GameController gameController;

    public static ArrayList<Fruit> fruits;

    public GameScreen() {
        fruits = new ArrayList<Fruit>();
    }

    @Override
    public void show() {
        Fruit.loadTextures();
        camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.position.x = Gdx.graphics.getWidth() / 2f;
        camera.position.y = Gdx.graphics.getHeight() / 2f;
        batch = new SpriteBatch();
        background = new Texture("background.jpg");
        gameController = new GameController();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        BitmapFont font = new BitmapFont();

        batch.setProjectionMatrix(camera.combined);
        camera.update();

        batch.begin();
        batch.draw(background, 0, 0, 800, 506);
        for (Fruit fruit : fruits) {
            fruit.render(batch);
        }
        batch.end();

        gameController.handle();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        background.dispose();
        batch.dispose();
        Fruit.unloadTextures();
    }
}
