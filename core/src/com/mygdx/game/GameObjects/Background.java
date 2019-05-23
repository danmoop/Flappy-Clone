package com.mygdx.game.GameObjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Background implements GameObject
{
    private final int SPEED = 2;
    private BackgroundComponent[] backgroundComponents;
    private Texture texture;

    public Background()
    {
        this.texture = new Texture("bg.jpg");

        backgroundComponents = new BackgroundComponent[] {
                new BackgroundComponent(new Vector2(0, 0)),
                new BackgroundComponent(new Vector2(426, 0))
        };
    }

    @Override
    public void update()
    {
        for (BackgroundComponent backgroundComponent : backgroundComponents)
        {
            backgroundComponent.pos.x -= SPEED;
        }

        if(backgroundComponents[0].pos.x <= -426)
        {
            backgroundComponents[0].pos.x = 0;
            backgroundComponents[1].pos.x = 426;
        }
    }

    @Override
    public void render(SpriteBatch batch)
    {
        for (BackgroundComponent backgroundComponent : backgroundComponents)
        {
            batch.draw(texture, backgroundComponent.pos.x, 0);
        }
    }

    @Override
    public void dispose()
    {
        texture.dispose();
    }

    class BackgroundComponent
    {
        private Vector2 pos;

        BackgroundComponent(Vector2 pos)
        {
            this.pos = pos;
        }
    }
}