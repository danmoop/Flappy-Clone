package com.mygdx.game.Scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.GameObjects.Background;
import com.mygdx.game.Manager.Scene;
import com.mygdx.game.Manager.SceneManager;

public class IntroScene extends Scene
{
    private SceneManager manager;

    private Texture playButton;
    private Texture bird;
    private Background background;
    private OrthographicCamera camera;

    public IntroScene(SceneManager manager)
    {
        this.manager = manager;

        playButton = new Texture("playbtn.png");
        bird = new Texture("bird.png");

        background = (Background) addObject(new Background());

        camera = new OrthographicCamera(426, 653);
    }

    @Override
    public void start()
    {
        System.out.println(getClass().getName() + " started");

        camera.setToOrtho(false, 426, 653);
    }

    @Override
    public void update()
    {
        camera.update();

        background.update();

        if(Gdx.input.isButtonPressed(0))
            manager.open(new PlayScene(manager));
    }

    @Override
    public void render(SpriteBatch batch)
    {
        batch.setProjectionMatrix(camera.combined);

        Gdx.gl.glClearColor(0.5f, 0.5f, 0.8f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();

        background.render(batch);

        batch.draw(
                playButton,
                426 / 2f - playButton.getWidth() / 2f,
                653 / 2f - playButton.getHeight() / 2f
        );

        batch.draw(
                bird,
                426 / 2f - 75,
                653 / 2f + 150,
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