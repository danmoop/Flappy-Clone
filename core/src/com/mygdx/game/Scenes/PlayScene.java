package com.mygdx.game.Scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
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
    private boolean gameOver;
    private Texture gameOverTexture;
    private OrthographicCamera camera;

    private int scoreInteger;
    private BitmapFont scoreText;

    PlayScene(SceneManager manager)
    {
        this.manager = manager;
    }

    @Override
    public void start()
    {
        gameOver = false;
        background = (Background) addObject(new Background());
        bird = (Bird) addObject(new Bird());
        obstacles = (Obstacles) addObject(new Obstacles());
        gameOverTexture = new Texture("gameOver.png");

        camera = new OrthographicCamera(426, 653);
        camera.setToOrtho(false, 426, 653);

        scoreInteger = 0;
        scoreText = new BitmapFont();

        scoreText.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        scoreText.getData().setScale(2);

        System.out.println(getClass().getName() + " started");
    }

    @Override
    public void update()
    {
        if(!gameOver)
        {
            updateGameObjects();
            camera.update();
        }

        if(bird.getPos().y < 0)
            gameOver = true;

        for (int i = 0; i < Obstacles.getPipes().length; i++)
        {
            if (bird.getPos().x + 75 > Obstacles.getPipes()[i].getPos().x && bird.getPos().x < Obstacles.getPipes()[i].getPos().x + 102)
            {
                if (bird.getPos().y + 75 > Obstacles.getPipes()[i].getPos().y - Obstacles.getPipes()[i].getOffset() + 590 || bird.getPos().y < Obstacles.getPipes()[i].getPos().y - Obstacles.getPipes()[i].getOffset() + 350)
                    gameOver = true;
            }

            // pretty poor pipe walk-by detection, simply comparing x coordinates
            if(!gameOver && bird.getPos().x == Obstacles.getPipes()[i].getPos().x)
                scoreInteger++;
        }

        if(gameOver && Gdx.input.justTouched())
        {
            try
            {
                Thread.sleep(500);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            manager.open(new IntroScene(manager));
        }
    }

    @Override
    public void render(SpriteBatch batch)
    {
        batch.setProjectionMatrix(camera.combined);

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();

        if(!gameOver)
            renderGameObjects(batch);
        else
            batch.draw(gameOverTexture, 426 / 2f - 89.75f, 653 / 2f - 119.75f, 179.5f, 239.5f);

        scoreText.draw(batch, "Score: " + scoreInteger, 426 / 2f, 653 - 30);

        batch.end();
    }

    @Override
    public void resize(int width, int height)
    {
    }

    @Override
    public void dispose()
    {
        gameOverTexture.dispose();
        disposeGameObjects();
    }
}