package com.mygdx.game.GameObjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Bird implements GameObject
{
    private Vector2 pos;
    private Texture texture;
    private float vy = 0;
    private final float GRAVITY = -0.7f;

    public Bird()
    {
        this.texture = new Texture("bird.png");
        this.pos = new Vector2(
                Gdx.graphics.getWidth() / 2f - 75f,
                Gdx.graphics.getHeight() / 2f + 150f
        );
    }

    @Override
    public void update()
    {
        vy += GRAVITY;

        pos.y += vy;

        if(Gdx.input.justTouched() && pos.y <= Gdx.graphics.getHeight() - 75)
            vy = 12;
    }

    @Override
    public void render(SpriteBatch batch)
    {
        batch.draw(texture, pos.x, pos.y, 75 ,75);
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