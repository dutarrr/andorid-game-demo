package com.dutar.catchfly;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Main extends ApplicationAdapter {
    SpriteBatch batch;
    Texture imgBackground;
    float screenX;
    float screenY;

    @Override
    public void create() {
        batch = new SpriteBatch();
        imgBackground = new Texture("background.png");
        screenX = Gdx.graphics.getWidth();
        screenY = Gdx.graphics.getHeight();

        System.out.println("x: " + screenX);
        System.out.println("y: "+ screenY);
    }

    @Override
    public void render() {
//		Gdx.gl.glClearColor(0, 0, 1, 0);
//		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(imgBackground, 0, 0, screenX, screenY);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        imgBackground.dispose();
    }
}
