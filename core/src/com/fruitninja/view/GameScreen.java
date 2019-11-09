package com.fruitninja.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.fruitninja.controller.GameController;
import com.fruitninja.model.fruit.Fruit;
import com.fruitninja.utils.GameUI;

import java.util.ArrayList;

public class GameScreen implements Screen {

    private SpriteBatch batch;
    private Texture background;
    private OrthographicCamera camera;
    private GameController gameController;
    private GameUI ui;

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
        ui = new GameUI();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.setProjectionMatrix(camera.combined);
        camera.update();

        batch.begin();
        batch.draw(background, 0, 0, 800, 506);
        for (Fruit fruit : fruits) {
            fruit.render(batch);
        }
        batch.end();

        gameController.handle();

        ui.draw();
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
        ui.dispose();
        Fruit.unloadTextures();
    }
}
