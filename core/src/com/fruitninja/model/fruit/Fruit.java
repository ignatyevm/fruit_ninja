package com.fruitninja.model.fruit;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Fruit {

    public static final float WIDTH = 48f;
    public static final float HEIGHT = 48f;

    public static Texture WATERMELON_TEXTURE = null;
    public static Texture BANANA_TEXTURE = null;

    public static void loadTextures() {
        WATERMELON_TEXTURE = new Texture("fruits/watermelon.png");
        WATERMELON_TEXTURE.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        BANANA_TEXTURE = new Texture("fruits/banana.png");
        BANANA_TEXTURE.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
    }

    public static void unloadTextures() {
        WATERMELON_TEXTURE.dispose();
        BANANA_TEXTURE.dispose();
    }

    private Rectangle bounds;
    private Sprite sprite;
    private float speed;

    public Fruit(float x, float y, Texture texture, float speed) {
        this(new Rectangle(x, y, WIDTH, HEIGHT), new Sprite(texture), speed);
    }

    public Fruit(Rectangle bounds, Sprite sprite, float speed) {
        this.bounds = bounds;
        this.sprite = sprite;
        this.speed = speed;
    }

    public void render(SpriteBatch batch) {
        this.sprite.setBounds(bounds.x, bounds.y, bounds.width, bounds.height);
        this.sprite.draw(batch);
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public float getSpeed() {
        return speed;
    }

}
