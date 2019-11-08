package com.fruitninja.model.fruit;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Fruit {

    public static final float DEFAULT_WIDTH = 48f;
    public static final float DEFAULT_HEIGHT = 48f;

    public static Texture WATERMELON_TEXTURE = null;
    public static Texture BANANA_TEXTURE = null;
    public static Texture PINEAPPLE_TEXTURE = null;

    public static void loadTextures() {
        WATERMELON_TEXTURE = new Texture("fruits/watermelon.png");
        WATERMELON_TEXTURE.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        BANANA_TEXTURE = new Texture("fruits/banana.png");
        BANANA_TEXTURE.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        PINEAPPLE_TEXTURE = new Texture("fruits/pineapple.png");
        PINEAPPLE_TEXTURE.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
    }

    public static void unloadTextures() {
        WATERMELON_TEXTURE.dispose();
        BANANA_TEXTURE.dispose();
        PINEAPPLE_TEXTURE.dispose();
    }

    private Rectangle bounds;
    private Texture texture;
    private float speed;
    private int max_health;
    public int health;

    public void setSize(int width, int height) {
        bounds.width = width;
        bounds.height = height;
    }

    public Fruit(float x, float y, Texture texture, float speed, int max_health) {
        this(new Rectangle(x, y, DEFAULT_WIDTH, DEFAULT_HEIGHT), texture, speed, max_health);
    }

    public Fruit(Rectangle bounds, Texture texture, float speed, int max_health) {
        this.bounds = bounds;
        this.texture = texture;
        this.speed = speed;
        this.max_health = max_health;
        this.health = max_health;
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, bounds.x, bounds.y, bounds.width, bounds.height);
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public float getSpeed() {
        return speed;
    }

}
