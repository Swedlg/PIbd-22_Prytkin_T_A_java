package com.company;

import java.awt.*;

public class CannonsAndBombs {

    //Количество пушек и бомб
    private CountOfCannonsAndBombs countOfCannonsAndBombs;

    public CannonsAndBombs(int countOfCannonsAndBombs) {
        setCountOfCannonsAndBombs(countOfCannonsAndBombs);
    }

    /**
     * Метод установки количества пушек и бомб
     * @param countOfCannonsAndBombs Количесвто
     */
    public void setCountOfCannonsAndBombs(int countOfCannonsAndBombs) {
        this.countOfCannonsAndBombs = CountOfCannonsAndBombs.getCountOfCannonsAbdBox(countOfCannonsAndBombs);
    }

    /**
     * Отрисовка пушек и бомб
     * @param g Полотно для отрисовки
     * @param startPosX Координата X
     * @param startPosY Координата Y
     * @param dopColor Цвет для отрисовки
     */
    public void drawCannonsAndBombs(Graphics g, int startPosX, int startPosY, Color dopColor) {
        if(countOfCannonsAndBombs != null) {
            Graphics2D g2 = (Graphics2D) g;
            g.setColor(dopColor);
            g2.setStroke(new BasicStroke(5));

            int tempCount;
            switch(countOfCannonsAndBombs){

                case Two:
                    tempCount = 2;
                    break;
                case Four:
                    tempCount = 4;
                    break;
                case Six:
                    tempCount = 6;
                    break;
                default:
                    tempCount = 0;
                    break;
            }

            for (int i = 0; i < tempCount; i += 2) {
                g2.drawLine(startPosX + 25 * ((i/2) + 1), startPosY + 10 - 10  * ((i/2) + 1), startPosX + 25 * ((i/2) + 1), startPosY + 35 - 10  * ((i/2) + 1));
                g2.drawLine(startPosX + 200 - 25 * ((i/2) + 1) , startPosY + 10 - 10  * ((i/2) + 1), startPosX + 200 - 25 * ((i/2) + 1), startPosY + 35 - 10  * ((i/2) + 1));
                g.fillOval(startPosX + 93, startPosY - 45 + 40 * (i/2), 14, 28);
            }
        } else {
            System.out.println("Количества бомб и ракет не существует");
        }
    }
}
