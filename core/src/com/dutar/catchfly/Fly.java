package com.dutar.catchfly;

import com.badlogic.gdx.graphics.Texture;

public class Fly {
    //private Texture Image;
    private float XCoordinate;
    private float YCoordinate;
    private float Width;
    private float Height;
    private float VelocityX;
    private float VelocityY;

    public float getXCoordinate() {
        return XCoordinate;
    }

    public void setXCoordinate(float XCoordinate) {
        this.XCoordinate = XCoordinate;
    }

    public float getYCoordinate() {
        return YCoordinate;
    }

    public void setYCoordinate(float YCoordinate) {
        this.YCoordinate = YCoordinate;
    }

    public float getWidth() {
        return Width;
    }

    public void setWidth(float width) {
        Width = width;
    }

    public float getHeight() {
        return Height;
    }

    public void setHeight(float height) {
        Height = height;
    }

    public float getVelocityX() {
        return VelocityX;
    }

    public void setVelocityX(float velocityX) {
        VelocityX = velocityX;
    }

    public float getVelocityY() {
        return VelocityY;
    }

    public void setVelocityY(float velocityY) {
        VelocityY = velocityY;
    }
}
