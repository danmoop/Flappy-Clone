package com.mygdx.game.GameObjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.SnapshotArray;

import java.util.Random;

public class Obstacles implements GameObject
{
    private Texture texture;
    private SnapshotArray<Pipe> pipes;
    private Random random = new Random();

    public Obstacles()
    {
        pipes = new SnapshotArray<>();

        pipes.add(new Pipe(new Vector2(200, 130)));

        for (int i = 1; i < 4; i++)
        {
            pipes.add(new Pipe(new Vector2(
                    pipes.get(i - 1).pos.x + 200,
                    random.nextInt(60) + 130
            )));
        }

        texture = new Texture("pipe.png");
    }

    @Override
    public void update()
    {
        for (int i = 0; i < pipes.size; i++)
        {
            pipes.get(i).pos.x -= 2;
        }

        for (int i = 0; i < pipes.size; i++)
        {
            if (pipes.get(i).pos.x < -102)
            {
                pipes.add(new Pipe(new Vector2(
                        pipes.get(pipes.size - 1).pos.x + 200,
                        random.nextInt(60) + 130
                )));

                pipes.removeIndex(i);
            }
        }
    }

    @Override
    public void render(SpriteBatch batch)
    {
        for (Pipe pipe : pipes)
        {
            batch.draw(texture, pipe.pos.x, pipe.pos.y);
        }
    }

    @Override
    public void dispose()
    {
        texture.dispose();
    }

    class Pipe
    {
        private Vector2 pos;

        Pipe(Vector2 pos)
        {
            this.pos = pos;
        }
    }
}