package com.mygdx.game.Model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Background
{
    private BackgroundComponent[] backgroundComponents;
    private final int SPEED = 3;
    private Texture texture;

    public Background(Texture texture)
    {
        this.texture = texture;

        backgroundComponents = new BackgroundComponent[] {
                new BackgroundComponent(new Vector2(0, 0)),
                new BackgroundComponent(new Vector2(640, 0))
        };
    }

    public void update()
    {
        for (BackgroundComponent backgroundComponent : backgroundComponents)
        {
            backgroundComponent.pos.x -= SPEED;
        }

        if(backgroundComponents[0].pos.x <= -640)
        {
            backgroundComponents[0].pos.x = 0;
            backgroundComponents[1].pos.x = 640;
        }
    }

    public void render(SpriteBatch batch)
    {
        for (BackgroundComponent backgroundComponent : backgroundComponents)
        {
            batch.draw(texture, backgroundComponent.pos.x, 0);
        }
    }

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