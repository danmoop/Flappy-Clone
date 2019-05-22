package com.mygdx.game.Scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Manager.Scene;
import com.mygdx.game.Manager.SceneManager;

public class IntroScene implements Scene
{
    private SceneManager manager;

    public IntroScene(SceneManager manager)
    {
        this.manager = manager;
    }

    @Override
    public void start()
    {
        System.out.println(getClass().getName() + " started");
    }

    @Override
    public void update()
    {
        if(Gdx.input.isButtonPressed(0))
            manager.open(new PlayScene(manager));
    }

    @Override
    public void render(SpriteBatch batch)
    {

    }

    @Override
    public void resize(int width, int height)
    {

    }

    @Override
    public void dispose()
    {

    }
}
