package com.fruitninja.model.fruit;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;

public class BananaFruit extends Fruit{

    public BananaFruit(float x, float y) {
        this(x, y, Fruit.BANANA_TEXTURE, 80);
    }

    private BananaFruit(float x, float y, Texture texture, float speed) {
        super(x, y, texture, speed);
    }

    private BananaFruit(Rectangle bounds, Sprite sprite, float speed) {
        super(bounds, sprite, speed);
    }

}
