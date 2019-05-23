package com.mygdx.game.Scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Manager.Scene;
import com.mygdx.game.Manager.SceneManager;

public class IntroScene extends Scene
{
    private SceneManager manager;

    private Texture playButton;
    private Texture bird;
    private Texture background;

    public IntroScene(SceneManager manager)
    {
        this.manager = manager;
        playButton = new Texture("playbtn.png");
        bird = new Texture("bird.png");
        background = new Texture("bg.jpg");
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
        Gdx.gl.glClearColor(0.5f, 0.5f, 0.8f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();

        batch.draw(background,0, 0);

        batch.draw(
                playButton,
                Gdx.graphics.getWidth() / 2f - playButton.getWidth() / 2f,
                Gdx.graphics.getHeight() / 2f - playButton.getHeight() / 2f
        );

        batch.draw(
                bird,
                Gdx.graphics.getWidth() / 2f - 75,
                Gdx.graphics.getHeight() / 2f + 150,
                150,150
        );

        batch.end();
    }

    @Override
    public void resize(int width, int height)
    {

    }

    @Override
    public void dispose()
    {
        System.out.println(getClass().getName() + " disposed");

        playButton.dispose();
        bird.dispose();
        background.dispose();
    }
}