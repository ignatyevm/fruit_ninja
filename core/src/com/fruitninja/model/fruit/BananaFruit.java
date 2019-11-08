package com.fruitninja.model.fruit;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;

public class BananaFruit extends Fruit{

    public BananaFruit(float x, float y) {
        this(x, y, Fruit.BANANA_TEXTURE, 100, 1);
    }

    private BananaFruit(float x, float y, Texture texture, float speed, int max_health) {
        super(x, y, texture, speed, max_health);
    }

    private BananaFruit(Rectangle bounds, Texture texture, float speed, int max_health) {
        super(bounds, texture, speed, max_health);
    }

}
