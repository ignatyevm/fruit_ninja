package com.fruitninja.model.fruit;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;

public class WatermelonFruit extends Fruit{

    public WatermelonFruit(float x, float y) {
        this(x, y, Fruit.WATERMELON_TEXTURE, 100);
    }

    private WatermelonFruit(float x, float y, Texture texture, float speed) {
        super(x, y, texture, speed);
    }

    private WatermelonFruit(Rectangle bounds, Sprite sprite, float speed) {
        super(bounds, sprite, speed);
    }

}
