package com.mygdx.game.Manager;

import java.util.Stack;

public class SceneManager
{
    private Stack<Scene> scenes;

    public SceneManager()
    {
        scenes = new Stack<>();
    }

    public void open(Scene scene)
    {
        if(scenes.size() == 0)
        {
            scenes.add(scene);
        }
        else
        {
            scenes.peek().dispose();

            scenes.pop();
            scenes.add(scene);
        }

        scenes.peek().start();
    }

    public Scene getActiveScene()
    {
        return scenes.peek();
    }
}