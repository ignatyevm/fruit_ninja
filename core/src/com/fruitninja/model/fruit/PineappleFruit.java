package com.fruitninja.model.fruit;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class PineappleFruit extends Fruit {

    public PineappleFruit(float x, float y) {
        this(x, y, Fruit.PINEAPPLE_TEXTURE, 50, 3);
        setSize(96, 90);
    }

    private PineappleFruit(float x, float y, Texture texture, float speed, int max_health) {
        super(x, y, texture, speed, max_health);
    }

    private PineappleFruit(Rectangle bounds, Texture texture, float speed, int max_health) {
        super(bounds, texture, speed, max_health);
    }

}
