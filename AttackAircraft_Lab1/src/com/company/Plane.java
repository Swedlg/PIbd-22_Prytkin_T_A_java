package com.company;

import java.awt.*;

public class Plane extends FlyingTransport  {

    //Ширина самолета
    private int planeWidth = 200;

    //ВЫсота Самолета
    private int planeHeight  = 100;

    //Пропеллер
    private boolean propeller;

    //Шасси
    private boolean chassis;

    //Антенна
    private boolean antenna;

    public Plane(int maxSpeed, int weight, Color colorOfPassengerPlane, Color colorOfDetail, boolean propeller, boolean chassis, boolean antenna) {
        this.maxSpeed = maxSpeed;
        this.weight = weight;
        this.colorOfPassengerPlane = colorOfPassengerPlane;
        this.colorOfDetail = colorOfDetail;
        this.propeller = propeller;
        this.chassis = chassis;
        this.antenna = antenna;

    }

    public Plane(int maxSpeed, int weight, Color colorOfPassengerPlane, Color colorOfDetail, boolean propeller, boolean chassis, boolean antenna, int planeWidth, int planeHeight) {
        this.maxSpeed = maxSpeed;
        this.weight = weight;
        this.colorOfPassengerPlane = colorOfPassengerPlane;
        this.colorOfDetail = colorOfDetail;
        this.propeller = propeller;
        this.chassis = chassis;
        this.antenna = antenna;
        this.planeWidth = planeWidth;
        this.planeHeight = planeHeight;
    }

    /**
     * Передвижение самолета
     * @param direction направление
     */
    @Override
    public void moveTransport(Directions direction) {
        try {

            //выступ левой части
            int leftLedge = 0;

            //выступ основной части корабля
            int topLedge = 100;

            //Дискретный шан перемещения самолета
            int step = maxSpeed * 100 / weight;

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
     * отрисовка самолета
     * @param g полотно
     */
    @Override
    public void drawTransport(Graphics g) {

        g.setColor(colorOfPassengerPlane);

        int[] x = {startPosX + 100, startPosX + 110, startPosX + 110, startPosX + 200, startPosX + 200, startPosX + 110, startPosX + 110, startPosX + 125,
                startPosX + 110, startPosX + 100, startPosX + 90, startPosX + 75, startPosX + 90, startPosX + 90, startPosX, startPosX, startPosX + 90, startPosX + 90};

        int[] y = {startPosY - 100, startPosY - 75, startPosY - 10, startPosY + 25, startPosY + 50, startPosY + 50, startPosY + 75, startPosY + 100, startPosY + 100, startPosY + 110,
                startPosY + 100, startPosY + 100, startPosY + 75, startPosY + 50, startPosY + 50, startPosY + 25, startPosY - 10, startPosY - 75};

        g.fillPolygon(x, y, 18);

        Graphics2D g2 = (Graphics2D) g;

        if (propeller)
        {
            g.setColor(colorOfDetail);
            g2.setStroke(new BasicStroke(3));
            g2.drawLine(startPosX + 85, startPosY - 95, startPosX + 115, startPosY - 95);

        }
        if (chassis)
        {
            g.setColor(colorOfDetail);
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
            g.setColor(colorOfDetail);
            g2.setStroke(new BasicStroke(3));
            g2.drawLine(startPosX + 100, startPosY + 95, startPosX + 100, startPosY + 120);
        }
    }
}
