package com.mygdx.game.GameObjects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface GameObject
{
    void update();
    void render(SpriteBatch batch);
    void dispose();
}