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

    Texture imgFly;
    float imgFlyX;
    float imgFlyY;
    float imgFlyWidth;
    float imgFlyHeight;

    int state = 0;
    float velocity = 0;
    float gravity = 0.1f;


    @Override
    public void create() {
        batch = new SpriteBatch();

        screenX = Gdx.graphics.getWidth();
        screenY = Gdx.graphics.getHeight();

        imgBackground = new Texture("background.png");

        imgFly = new Texture("fly.png");
        imgFlyX = screenX / 1.5f;
        imgFlyY = screenY / 2;
        imgFlyWidth = screenX / 15;
        imgFlyHeight = screenY / 10;
    }

    @Override
    public void render() {
//		Gdx.gl.glClearColor(0, 0, 1, 0);
//		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if (state == 0) { //End
            if (Gdx.input.justTouched()) {
                if (state == 0)
                    state = 1;
            }
        } else if (state == 1) { //start
            if (imgFlyY > 0 && imgFlyY < screenY / 1.1f) {
                velocity += gravity;
                imgFlyY -= velocity;
            } else if (imgFlyY <= 0) {
                state = 0;
                imgFlyY = screenY / 2;
                velocity = 0;
            } else if (imgFlyY >= screenY / 1.1f) {
                imgFlyY = screenY / 1.11f;
                velocity = 0;
            }

            if (Gdx.input.justTouched())
                velocity -= 3;
        }

        batch.begin();
        batch.draw(imgBackground, 0, 0, screenX, screenY);
        batch.draw(imgFly, imgFlyX, imgFlyY, imgFlyWidth, imgFlyHeight);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        imgBackground.dispose();
        imgFly.dispose();
    }
}
