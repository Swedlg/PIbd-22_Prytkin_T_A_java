package com.company;

import java.awt.*;

public interface ITransport {
    /**
     * Задает позицию транспорту
     * @param x Координата X
     * @param y Координата Y
     * @param width Ширина окна
     * @param height Высота окна
     */
    void setPosition(int x, int y, int width, int height);

    /**
     * Передвижение транспорта с выбранную сторону
     * @param direction Направление
     */
    void moveTransport(Directions direction);

    /**
     * Отрисовка транспорта
     * @param g Полотно для отрисовки
     */
    void drawTransport(Graphics g);
}
