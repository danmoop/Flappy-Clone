package com.mygdx.game.Manager;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface Scene
{
    void start();

    void update();
    void render(SpriteBatch batch);
    void resize(int width, int height);

    void dispose();
}