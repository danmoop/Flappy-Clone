package com.mygdx.game.Manager;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.GameObjects.GameObject;

import java.util.ArrayList;
import java.util.List;

public abstract class Scene
{
    private List<GameObject> sceneObjects;

    protected Scene()
    {
        this.sceneObjects = new ArrayList<>();
    }

    protected GameObject addObject(GameObject gameObject)
    {
        sceneObjects.add(gameObject);

        return gameObject;
    }

    protected void renderGameObjects(SpriteBatch batch)
    {
        for (GameObject sceneObject : sceneObjects)
        {
            sceneObject.render(batch);
        }
    }

    protected void updateGameObjects()
    {
        for (GameObject sceneObject : sceneObjects)
        {
            sceneObject.update();
        }
    }

    private void disposeGameObjects()
    {
        for (GameObject sceneObject : sceneObjects)
        {
            sceneObject.dispose();
        }
    }

    public abstract void start();

    public abstract void update();
    public abstract void render(SpriteBatch batch);
    public abstract void resize(int width, int height);

    public void dispose()
    {
        System.out.println(getClass().getName() + " disposed");

        disposeGameObjects();
    }
}