package com.dutar.catchfly;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Random;

public class Main extends ApplicationAdapter {
    SpriteBatch batch;
    Sprite sprite;

    Texture imgBackground;
    Texture imgFly;
    Texture imgGameOver;
    float screenX;
    float screenY;
    Fly[] flys = new Fly[1];

    BitmapFont fontName;
    BitmapFont fontSurName;

    @Override
    public void create() {
        batch = new SpriteBatch();
        screenX = Gdx.graphics.getWidth();
        screenY = Gdx.graphics.getHeight();

        //******************************************************
        imgBackground = new Texture("background.png");
        imgFly = new Texture("fly.png");

        //hareketli sinek
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
        //******************************************************

        //******************************************************
        imgGameOver = new Texture("gameover.png");
        sprite = new Sprite(imgGameOver);
        sprite.setPosition(screenX / 2 - sprite.getWidth() / 2, screenY / 2 - sprite.getHeight() / 2);
        //***************************************************

        //***************************************************
        fontName = new BitmapFont();
        fontName.setColor(Color.WHITE);
        fontName.getData().setScale(4);

        fontSurName = new BitmapFont();
        fontSurName.setColor(Color.WHITE);
        fontSurName.getData().setScale(4);
        //***************************************************

    }

    @Override
    public void render() {
        batch.begin();
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        //******************************************************
        batch.draw(imgBackground, 0, 0, screenX, screenY);
        fontName.draw(batch,"Düzgün",50,50);
        fontName.draw(batch,"Tutar",100,100);
        //******************************************************

        //******************************************************
        batch.draw(sprite, sprite.getX(), sprite.getY());
        //******************************************************

        //******************************************************
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
        //******************************************************


        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        imgBackground.dispose();
        imgFly.dispose();
    }
}
