package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Manager.SceneManager;
import com.mygdx.game.Scenes.IntroScene;

public class Main extends ApplicationAdapter
{

	private SceneManager sceneManager;
	private SpriteBatch batch;

	@Override
	public void create()
	{
		sceneManager = new SceneManager();
		batch = new SpriteBatch();

		sceneManager.open(new IntroScene(sceneManager));
	}

	@Override
	public void render()
	{
		sceneManager.getActiveScene().update();
		sceneManager.getActiveScene().render(batch);
	}

	@Override
	public void resize(int width, int height)
	{
		sceneManager.getActiveScene().resize(width, height);
	}

	@Override
	public void dispose()
	{
		sceneManager.getActiveScene().dispose();
	}
}