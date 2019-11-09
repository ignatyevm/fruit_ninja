package com.fruitninja.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.fruitninja.controller.GameController;

public class GameUI {

    private Stage stage;
    private Skin skin;
    private Texture heartTexture;
    private Label scoreLabel;

    public GameUI() {
        stage = new Stage(new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()));
        skin = new Skin(Gdx.files.internal("ui/skin.json"));
        heartTexture = new Texture(Gdx.files.internal("ui/heart.png"));
        heartTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        scoreLabel = new Label("Score: " + GameController.score, skin.get("default", Label.LabelStyle.class));
        scoreLabel.setPosition(670, 400);
        scoreLabel.setFontScale(.3f);
        scoreLabel.setColor(Color.ORANGE);
        stage.addActor(scoreLabel);
    }

    public void draw() {
        scoreLabel.setText("Score: " + GameController.score);
        stage.getBatch().begin();
        for (int i = 0; i < GameController.health; i++) stage.getBatch().draw(heartTexture, 55 + (i * 25), 460, 25, 25);
        stage.getBatch().end();
        stage.act();
        stage.draw();
    }

    public void dispose() {
        heartTexture.dispose();
        stage.dispose();
    }

}
