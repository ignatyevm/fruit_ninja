package com.fruitninja.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.fruitninja.FruitNinjaMain;


public class MainMenuScreen implements Screen {

    private Texture background;
    private Stage stage;
    private Skin textSkin;
    private Texture buttonTexture;
    private Rectangle buttonBounds;

    @Override
    public void show() {
        stage = new Stage(new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()));
        textSkin = new Skin(Gdx.files.internal("ui/skin.json"));
        background = new Texture("main_menu_background.png");

        buttonTexture = new Texture("ui/button_background.png");
        buttonTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        buttonBounds = new Rectangle(308, 170, 170, 80);

        Label buttonText = new Label("Start", textSkin.get("default", Label.LabelStyle.class));
        buttonText.setColor(Color.GREEN);
        buttonText.setFontScale(0.35f);
        buttonText.setPosition(355, 140);
        stage.addActor(buttonText);

        Label title = new Label("Fruit Ninja", textSkin.get("default", Label.LabelStyle.class));
        title.setColor(Color.YELLOW);
        title.setFontScale(0.5f);
        title.setPosition(290, 270);
        stage.addActor(title);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.getBatch().begin();
        stage.getBatch().draw(background, 0, 0, 800, 506);
        stage.getBatch().draw(buttonTexture, buttonBounds.x, buttonBounds.y, buttonBounds.width, buttonBounds.height);
        stage.getBatch().end();

        stage.act();
        stage.draw();

        if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
            float x = Gdx.input.getX();
            float y = Gdx.graphics.getHeight() - Gdx.input.getY();
            if (buttonBounds.contains(x, y)) {
                FruitNinjaMain.game.setScreen(new GameScreen());
            }
        }
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
        buttonTexture.dispose();
        stage.dispose();
    }
}
