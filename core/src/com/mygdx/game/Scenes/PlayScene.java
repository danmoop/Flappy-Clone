package com.mygdx.game.Scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Manager.Scene;
import com.mygdx.game.Manager.SceneManager;
import com.mygdx.game.Model.Background;

public class PlayScene implements Scene
{
    private Background background;

    private SceneManager manager;

    public PlayScene(SceneManager manager)
    {
        this.manager = manager;
    }

    @Override
    public void start()
    {
        background = new Background(new Texture("bg.jpg"));

        System.out.println(getClass().getName() + " started");
    }

    @Override
    public void update()
    {
        background.update();
    }

    @Override
    public void render(SpriteBatch batch)
    {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();

        background.render(batch);

        batch.end();
    }

    @Override
    public void resize(int width, int height)
    {
    }

    @Override
    public void dispose()
    {
        background.dispose();
    }
}
