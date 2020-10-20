package com.company;

import java.awt.*;

public class AttackAircraft  {

    //Начальная координата X
    private int startPosX;

    //Начальная координата Y
    private int startPosY;

    //Ширина окна
    private int pictureWidth;

    //Высота окна
    private int pictureHeight;

    //Максимальная скорость самолета
    public int maxSpeed;

    //Максимальный вес самолета
    public float weight;

    //Цвета
    public Color mainColor;
    public Color DopColor;
    public Color DopColor2;
    public Color DopColor3;

    //Наличие пропеллера
    public boolean propeller;

    //Наличие шасси
    public boolean chassis;

    //Наличие атнены
    public boolean antenna;

    //Наличие камуфляжа
    public boolean camouflage;

    //Наличие ракет
    public boolean rockets;

    //Наличие бомб
    public boolean bombs;

    //Количесвто ракет и бомб
    public int countOfCannonsAndBombs;

    //Экземпляр класс ракет и бомб
    CannonsAndBombs cannonsAndBombs;

    public AttackAircraft(int maxSpeed, float weight, Color mainColor, Color dopColor, Color dopColor2, Color dopColor3, boolean propeller, boolean chassis, boolean antenna, boolean rockets, boolean bombs, int countOfCannonsAndBombs)
    {
        this.maxSpeed = maxSpeed;
        this.weight = weight;
        this.mainColor = mainColor;
        this.DopColor = dopColor;
        this.DopColor2 = dopColor2;
        this.DopColor3 = dopColor3;
        this.propeller = propeller;
        this.chassis = chassis;
        this.antenna = antenna;
        this.rockets = rockets;
        this.bombs = bombs;
        camouflage = rockets || bombs;
        
        if (camouflage){
            this.countOfCannonsAndBombs = countOfCannonsAndBombs;
            cannonsAndBombs = new CannonsAndBombs(countOfCannonsAndBombs);
        }
    }

    /**
     * Установить количесвто ракет и бомб
     * @param countOfCannonsAndBombs Количество ракет и бомб
     */
    public void setCountOfCannonsAndBombs(int countOfCannonsAndBombs) {

        System.out.println("Устанавливается количество ракет и бомб: " + countOfCannonsAndBombs);

        if (camouflage){
            this.countOfCannonsAndBombs = countOfCannonsAndBombs;
            cannonsAndBombs = new CannonsAndBombs(countOfCannonsAndBombs);
        }
        else {
            System.out.println("Не удалось установить ракеты и бомбы! Самолет пассажирский!");
        }
    }

    /**
     * Метод установки начальной позиции самолета
     * @param x координата X
     * @param y координата Y
     * @param width ширина окна
     * @param height высота окна
     */
    public void SetPosition(int x, int y, int width, int height)
    {
        startPosX = x;
        startPosY = y;
        pictureWidth = width;
        pictureHeight = height;
    }

    /**
     * Метод передвижения транспорта
     * @param direction Направление переджвиженния
     */
    public void MoveTransport(Directions direction)
    {
        try {

            //выступ левой части
            int leftLedge = 0;

            //выступ основной части корабля
            int topLedge = 100;

            //Дискретный шан перемещения самолета
            float step = maxSpeed * 100 / weight;

            //Ширина самолета
            int attackAircraftWidth = 200;

            //Высота самолета
            int attackAircraftHeight = 100;

            switch (direction) {
                case Right:
                    if (startPosX + step < pictureWidth - attackAircraftWidth) {
                        startPosX += step;
                    }
                    break;
                case Left:
                    if (startPosX - step > leftLedge) {
                        startPosX -= step;
                    }
                    break;
                case Up:
                    if (startPosY - step > topLedge) {
                        startPosY -= step;
                    }
                    break;
                case Down:
                    if (startPosY + step < pictureHeight - attackAircraftHeight) {
                        startPosY += step;
                    }
                    break;
            }
        }
        catch (Exception ignored){}
    }

    /**
     * Метод отрисовка самолета
     * @param g Полотно отрисовки
     */
    public void drawTransport(Graphics g) {

        if (camouflage)
        {
            g.setColor(mainColor);
        }
        else
        {
            g.setColor(DopColor3);
        }

        int[] x = {startPosX + 100, startPosX + 110, startPosX + 110, startPosX + 200, startPosX + 200, startPosX + 110, startPosX + 110, startPosX + 125,
                startPosX + 110, startPosX + 100, startPosX + 90, startPosX + 75, startPosX + 90, startPosX + 90, startPosX, startPosX, startPosX + 90, startPosX + 90};

        int[] y = {startPosY - 100, startPosY - 75, startPosY - 10, startPosY + 25, startPosY + 50, startPosY + 50, startPosY + 75, startPosY + 100, startPosY + 100, startPosY + 110,
                startPosY + 100, startPosY + 100, startPosY + 75, startPosY + 50, startPosY + 50, startPosY + 25, startPosY - 10, startPosY - 75};

        g.fillPolygon(x, y, 18);

        Graphics2D g2 = (Graphics2D) g;

        if (propeller)
        {
            g.setColor(DopColor2);
            g2.setStroke(new BasicStroke(3));
            g2.drawLine(startPosX + 85, startPosY - 95, startPosX + 115, startPosY - 95);

        }
        if (chassis)
        {
            g.setColor(DopColor2);
            g2.setStroke(new BasicStroke(3));
            g2.drawLine(startPosX + 100, startPosY - 75, startPosX + 100, startPosY - 50);
            g.drawOval(startPosX + 97, startPosY - 65, 6, 6);
            g2.drawLine(startPosX + 75, startPosY + 35, startPosX + 75, startPosY + 60);
            g.drawOval(startPosX + 72, startPosY + 44, 6, 6);
            g2.drawLine(startPosX + 125, startPosY + 35, startPosX + 125, startPosY + 60);
            g.drawOval(startPosX + 122, startPosY + 44, 6, 6);
        }
        if (antenna)
        {
            g.setColor(DopColor2);
            g2.setStroke(new BasicStroke(3));
            g2.drawLine(startPosX + 100, startPosY + 95, startPosX + 100, startPosY + 120);
        }
        if(camouflage){
            cannonsAndBombs.drawCannonsAndBombs(g, startPosX, startPosY, Color.RED);
        }
    }
}
