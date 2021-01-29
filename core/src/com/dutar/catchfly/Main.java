package com.dutar.catchfly;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import java.util.Random;

public class Main extends ApplicationAdapter {
    SpriteBatch batch;
    Texture imgBackground;
    Texture imgFly;
    float screenX;
    float screenY;

    Fly[] flys = new Fly[20];

    @Override
    public void create() {
        batch = new SpriteBatch();
        screenX = Gdx.graphics.getWidth();
        screenY = Gdx.graphics.getHeight();

        imgBackground = new Texture("background.png");
        imgFly = new Texture("fly.png");

        for (int i = 0; i < flys.length; i++) {
            Random random = new Random();

            flys[i] = new Fly();
            flys[i].setXCoordinate(random.nextInt((int) screenX));
            flys[i].setYCoordinate(random.nextInt((int) screenY));
            if (i % 2 == 0) {
                flys[i].setVelocityX(5);
                flys[i].setVelocityY(5);
            } else {
                flys[i].setVelocityX(-5);
                flys[i].setVelocityY(-5);
            }
            flys[i].setVelocityX(5);
            flys[i].setVelocityY(5);
            flys[i].setWidth(screenX / 16);
            flys[i].setHeight(screenY / 9);
        }
    }

    @Override
    public void render() {
        batch.begin();
        batch.draw(imgBackground, 0, 0, screenX, screenY);


        for (int i = 0; i < flys.length; i++) {
            if (flys[i].getXCoordinate() <= 0) {
                flys[i].setVelocityX(5);
            }
            if (flys[i].getXCoordinate() >= screenX - flys[i].getWidth()) {
                flys[i].setVelocityX(-5);
            }

            if (flys[i].getYCoordinate() <= 0) {
                flys[i].setVelocityY(5);
            }
            if (flys[i].getYCoordinate() >= screenY - flys[i].getHeight()) {
                flys[i].setVelocityY(-5);
            }

            flys[i].setXCoordinate(flys[i].getXCoordinate() + flys[i].getVelocityX());
            flys[i].setYCoordinate(flys[i].getYCoordinate() + flys[i].getVelocityY());

            batch.draw(imgFly, flys[i].getXCoordinate(), flys[i].getYCoordinate(), flys[i].getWidth(), flys[i].getHeight());

        }

        //batch.draw(imgFly, screenX / 2, screenY / 2, screenX / 16, screenX / 9);

        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        imgBackground.dispose();
        imgFly.dispose();
    }
}
