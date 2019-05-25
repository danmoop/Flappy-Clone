package com.mygdx.game.GameObjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

public class Bird implements GameObject
{
    private Random random;

    private final String[] BIRDS = {"bird.png", "bird2.png", "bird3.png"};

    private Vector2 pos;
    private Texture texture;
    private float vy = 0;
    private final float GRAVITY = -0.7f;

    public Bird()
    {
        random = new Random();

        this.texture = new Texture(BIRDS[random.nextInt(BIRDS.length)]);

        this.pos = new Vector2(
                426 / 2f - 76f,
                653 / 2f + 150f
        );
    }

    @Override
    public void update()
    {
        vy += GRAVITY;

        pos.y += vy;

        if((Gdx.input.justTouched() || Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) && pos.y <= Gdx.graphics.getHeight() - 75)
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