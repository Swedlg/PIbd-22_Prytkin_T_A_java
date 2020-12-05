package com.company;

import java.awt.*;

public interface ICannonsAndBombs {

    /**
     * Отрисовка орудия
     * @param g полотно
     * @param startPosX начальная позиция X
     * @param startPosY начальная пози2ция Y
     * @param dopColor Цвет
     */
    void drawDetail(Graphics g, int startPosX, int startPosY, Color dopColor);

    /**
     * Установить количество ракет и бомб
     * @param countOfCannonsAndBombs количесвто ракет и бомб
     */
    void setCountOfCannonsAndBombs(CountOfCannonsAndBombs countOfCannonsAndBombs);
}
