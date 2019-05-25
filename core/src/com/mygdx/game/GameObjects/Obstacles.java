package com.mygdx.game.GameObjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

public class Obstacles implements GameObject
{
    private Texture texture;
    private static Pipe[] pipes;
    private Random random = new Random();
    private final float distanceBetweenPipes = 590;

    public Obstacles()
    {
        texture = new Texture("pipe.png");

        pipes = new Pipe[2];

        int startX = 803;

        for (int i = 0; i < pipes.length; i++)
        {
            pipes[i] = new Pipe(new Vector2(startX, 0));
            startX += 354;
        }
    }

    public static Pipe[] getPipes()
    {
        return pipes;
    }

    @Override
    public void update()
    {
        for (Pipe pipe : pipes)
        {
            pipe.update();
        }
    }

    @Override
    public void render(SpriteBatch batch)
    {
        for (Pipe pipe : pipes)
        {
            pipe.render(batch);
        }
    }

    @Override
    public void dispose()
    {
        texture.dispose();
    }

    public class Pipe implements GameObject
    {
        private Vector2 pos;
        private int offset;
        private final int SPEED = 6;

        Pipe(Vector2 pos)
        {
            this.pos = pos;
            this.offset = random.nextInt(250);
        }

        public int getOffset()
        {
            return offset;
        }

        @Override
        public void update()
        {
            pos.x -= SPEED;

            if(pos.x <= -102)
            {
                pos.x = 653;
                offset = random.nextInt(250);
            }
        }

        @Override
        public void render(SpriteBatch batch)
        {
            batch.draw(texture, pos.x, pos.y - offset, 102, 350);
            batch.draw(texture, pos.x, pos.y + distanceBetweenPipes - offset, 102, 350);
        }

        @Override
        public void dispose()
        {
            texture.dispose();
        }

        public Vector2 getPos()
        {
            return pos;
        }
    }
}