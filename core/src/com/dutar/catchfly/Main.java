package com.dutar.catchfly;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

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

    float velocityX = 5;
    float velocityY = 5;
    float gravity = 0.1f;


    @Override
    public void create() {
        batch = new SpriteBatch();

        screenX = Gdx.graphics.getWidth();
        screenY = Gdx.graphics.getHeight();

        imgBackground = new Texture("background.png");

        imgFly = new Texture("fly.png");
        imgFlyX = screenX / 2;
        imgFlyY = screenY / 2;
        imgFlyWidth = screenX / 16;
        imgFlyHeight = screenY / 9;
    }

    @Override
    public void render() {

        imgFlyX = imgFlyX + velocityX;
        imgFlyY = imgFlyY + velocityY;

        if (imgFlyX <= 0) {
            velocityX = 5;
        }
        if (imgFlyX >= screenX - imgFlyWidth) {
            velocityX = -5;
        }

        if (imgFlyY <= 0) {
            velocityY = 5;
        }
        if (imgFlyY >= screenY-imgFlyHeight) {
            velocityY = -5;
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
