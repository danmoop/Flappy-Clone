package com.mygdx.game.Scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.GameObjects.Background;
import com.mygdx.game.GameObjects.Bird;
import com.mygdx.game.GameObjects.Obstacles;
import com.mygdx.game.Manager.Scene;
import com.mygdx.game.Manager.SceneManager;

public class PlayScene extends Scene
{
    private Background background;
    private SceneManager manager;
    private Bird bird;
    private Obstacles obstacles;

    PlayScene(SceneManager manager)
    {
        this.manager = manager;
    }

    @Override
    public void start()
    {
        background = (Background) addObject(new Background());
        bird = (Bird) addObject(new Bird());
        obstacles = (Obstacles) addObject(new Obstacles());

        System.out.println(getClass().getName() + " started");
    }

    @Override
    public void update()
    {
        updateGameObjects();

        if(bird.getPos().y <= 150)
            manager.open(new IntroScene(manager));
    }

    @Override
    public void render(SpriteBatch batch)
    {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();

        renderGameObjects(batch);

        batch.end();
    }

    @Override
    public void resize(int width, int height)
    {
    }
}