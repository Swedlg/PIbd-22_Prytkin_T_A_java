package com.company;

import java.awt.*;

public abstract class FlyingTransport implements ITransport {

    //Начальная координата X
    protected int startPosX;

    //Начальная координата Y
    protected int startPosY;

    //Высота картинки
    protected int pictureWidth;

    //Ширина картинки
    protected int pictureHeight;

    //Максимальная скорость
    public int maxSpeed;

    //Вес
    public int weight;

    //Цвет обычного самолета
    public Color colorOfPassengerPlane;

    //Цвет деталей (шасси, антена, пропеллер)
    public Color colorOfDetail;

    /**
     * Устанавливаеь позицию самолета
     * @param x Координата X
     * @param y Координата Y
     * @param width Ширина окна
     * @param height Высота окна
     */
    public void setPosition(int x, int y, int width, int height)
    {
        startPosX = x;
        startPosY = y;
        pictureWidth = width;
        pictureHeight = height;
    }

    public abstract void drawTransport(Graphics g);

    public abstract void moveTransport(Directions direction);
}
