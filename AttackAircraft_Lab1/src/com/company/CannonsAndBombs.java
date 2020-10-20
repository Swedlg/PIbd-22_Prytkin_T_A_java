package com.company;

import java.awt.*;

public class CannonsAndBombs {

    //Количество пушек и бомб
    private int countOfCannonsAndBombs;

    public CannonsAndBombs(int countOfCannonsAndBombs) {
        this.countOfCannonsAndBombs = countOfCannonsAndBombs;
    }

    /**
     * Отрисовка пушек и бомб
     * @param g Полотно для отрисовки
     * @param startPosX Координата X
     * @param startPosY Координата Y
     * @param dopColor Цвет для отрисовки
     */
    public void drawCannonsAndBombs(Graphics g, int startPosX, int startPosY, Color dopColor) {
        if(countOfCannonsAndBombs != 0) {
            Graphics2D g2 = (Graphics2D) g;
            g.setColor(dopColor);
            g2.setStroke(new BasicStroke(5));

            for (int i = 0; i < countOfCannonsAndBombs; i += 2) {
                g2.drawLine(startPosX + 25 * ((i/2) + 1), startPosY + 10 - 10  * ((i/2) + 1), startPosX + 25 * ((i/2) + 1), startPosY + 35 - 10  * ((i/2) + 1));
                g2.drawLine(startPosX + 200 - 25 * ((i/2) + 1) , startPosY + 10 - 10  * ((i/2) + 1), startPosX + 200 - 25 * ((i/2) + 1), startPosY + 35 - 10  * ((i/2) + 1));
                g.fillOval(startPosX + 93, startPosY - 45 + 40 * (i/2), 14, 28);
            }
        }
    }
}
