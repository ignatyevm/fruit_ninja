package com.fruitninja.model.fruit;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;

public class WatermelonFruit extends Fruit{

    public WatermelonFruit(float x, float y) {
        this(x, y, Fruit.WATERMELON_TEXTURE, 70, 2);
    }

    private WatermelonFruit(float x, float y, Texture texture, float speed, int max_health) {
        super(x, y, texture, speed, max_health);
    }

    private WatermelonFruit(Rectangle bounds, Texture texture, float speed, int max_health) {
        super(bounds, texture, speed, max_health);
    }

}
