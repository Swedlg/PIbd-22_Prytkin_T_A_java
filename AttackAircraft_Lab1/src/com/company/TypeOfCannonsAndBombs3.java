package com.company;

import java.awt.*;

public class TypeOfCannonsAndBombs3 implements ICannonsAndBombs {

    //Количество пушек и бомб
    private CountOfCannonsAndBombs countOfCannonsAndBombs;

    public TypeOfCannonsAndBombs3(CountOfCannonsAndBombs countOfCannonsAndBombs){
        setCountOfCannonsAndBombs(countOfCannonsAndBombs);
    }

    /**
     * Метод установки количества пушек и бомб
     * @param countOfCannonsAndBombs Количесвто
     */
    public void setCountOfCannonsAndBombs(CountOfCannonsAndBombs countOfCannonsAndBombs) {
        this.countOfCannonsAndBombs = countOfCannonsAndBombs;
    }

    /**
     * Отрисовка пушек и бомб
     * @param g Полотно для отрисовки
     * @param startPosX Координата X
     * @param startPosY Координата Y
     * @param dopColor Цвет для отрисовки
     */
    public void drawDetail(Graphics g, int startPosX, int startPosY, Color dopColor) {
        if (countOfCannonsAndBombs != null) {
            Graphics2D g2 = (Graphics2D) g;
            g.setColor(dopColor);
            g2.setStroke(new BasicStroke(5));

            int tempCount;
            switch (countOfCannonsAndBombs) {

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

                g2.drawArc(startPosX - 7 + 25 * ((i / 2) + 1), startPosY - 10 - 10 * ((i / 2) + 1), 15, 40, 180, 180);
                g2.drawArc(startPosX + 193 - 25 * ((i / 2) + 1), startPosY - 10 - 10 * ((i / 2) + 1), 15, 40, 180, 180);

                int[] x = {startPosX + 90, startPosX + 100, startPosX + 110, startPosX + 100};

                int[] y = {startPosY - 40 + 40 * (i / 2), startPosY - 55 + 40 * (i / 2), startPosY - 40 + 40 * (i / 2), startPosY - 25 + 40 * (i / 2)};

                g.fillPolygon(x, y, 4);

            }
        } else {
            System.out.println("Количества бомб и ракет не существует");
        }
    }
}
