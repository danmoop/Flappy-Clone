package com.mygdx.game.Model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Bird implements GameObject
{
    private Vector2 pos;
    private Texture texture;

    public Bird(Texture texture)
    {
        this.texture = texture;
        this.pos = new Vector2(
                Gdx.graphics.getWidth() / 2f - 75f,
                Gdx.graphics.getHeight() / 2f - 75f
        );
    }

    @Override
    public void update()
    {
    }

    @Override
    public void render(SpriteBatch batch)
    {
        batch.draw(texture, pos.x, pos.y, 150 ,150);
    }

    @Override
    public void dispose()
    {
        texture.dispose();
    }
}