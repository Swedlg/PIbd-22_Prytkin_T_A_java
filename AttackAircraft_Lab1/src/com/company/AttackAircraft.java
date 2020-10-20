package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class AttackAircraft  {


    private int startPosX;

    private int startPosY;

    private int pictureWidth;

    private int pictureHeight;

    public int maxSpeed;

    public float weight;

    public Color mainColor;
    public Color DopColor;
    public Color DopColor2;
    public Color DopColor3;

    public boolean propeller;

    public boolean chassis;

    public boolean antenna;

    public boolean camouflage;

    public boolean rockets;

    public boolean bombs;

    public AttackAircraft(int maxSpeed, float weight, Color mainColor, Color dopColor, Color dopColor2, Color dopColor3, boolean propeller, boolean chassis, boolean antenna, boolean rockets, boolean bombs)
    {
        System.out.println("AtackAircraft");
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
    }

    public void SetPosition(int x, int y, int width, int height)
    {
        System.out.println("SetPosition");
        startPosX = x;
        startPosY = y;
        pictureWidth = width;
        pictureHeight = height;
    }

    public void MoveTransport(Directions direction)
    {
        System.out.println("MoveTransport");

        System.out.println(startPosX + " " + startPosY);

        try {
            int leftbody = 0;//выступ левой части
            int topbudy = 100;//выступ основной части корабля
            float step = maxSpeed * 100 / weight;
            int atackAircraftWidth = 200;
            int atackAircraftHeight = 100;
            switch (direction) {
                case Right:
                    if (startPosX + step < pictureWidth - atackAircraftWidth) {
                        startPosX += step;
                    }
                    break;
                case Left:
                    if (startPosX - step > leftbody) {
                        startPosX -= step;
                    }
                    break;
                case Up:
                    if (startPosY - step > topbudy) {
                        startPosY -= step;
                    }
                    break;
                case Down:
                    if (startPosY + step < pictureHeight - atackAircraftHeight) {
                        startPosY += step;
                    }
                    break;
            }
        }
        catch (Exception ignored){}

        System.out.println(startPosX + " " +  startPosY);
    }

    public void drawTransport(Graphics g) throws IOException {



        //startPosX += 10;
        //startPosY += 10;

        //Pen pen = new Pen(MainColor);
        //Brush brush;
        if (camouflage)
        {
            g.setColor(mainColor);
            //brush = new SolidBrush(mainColor);
        }
        else
        {
            g.setColor(DopColor3);
            //brush = new SolidBrush(DopColor3);
        }

        //pen.Width = 16;


        /*самолет
        Point point1 = new Point((int)startPosX + 100, (int)startPosY - 100);
        Point point2 = new Point((int)startPosX + 110, (int)startPosY - 75);
        Point point3 = new Point((int)startPosX + 110, (int)startPosY - 10);
        Point point4 = new Point((int)startPosX + 200, (int)startPosY + 25);
        Point point5 = new Point((int)startPosX + 200, (int)startPosY + 50);
        Point point6 = new Point((int)startPosX + 110, (int)startPosY + 50);
        Point point7 = new Point((int)startPosX + 110, (int)startPosY + 75);
        Point point8 = new Point((int)startPosX + 125, (int)startPosY + 100);
        Point point9 = new Point((int)startPosX + 110, (int)startPosY + 100);
        Point point10 = new Point((int)startPosX + 100, (int)startPosY + 110);//
        Point point11 = new Point((int)startPosX + 90, (int)startPosY + 100);
        Point point12 = new Point((int)startPosX + 75, (int)startPosY + 100);
        Point point13 = new Point((int)startPosX + 90, (int)startPosY + 75);
        Point point14 = new Point((int)startPosX + 90, (int)startPosY + 50);
        Point point15 = new Point((int)startPosX, (int)startPosY + 50);
        Point point16 = new Point((int)startPosX, (int)startPosY + 25);
        Point point17 = new Point((int)startPosX + 90, (int)startPosY - 10);
        Point point18 = new Point((int)startPosX + 90, (int)startPosY - 75);
         */

        int[] x = {startPosX + 100, startPosX + 110, startPosX + 110, startPosX + 200, startPosX + 200, startPosX + 110, startPosX + 110, startPosX + 125,
                startPosX + 110, startPosX + 100, startPosX + 90, startPosX + 75, startPosX + 90, startPosX + 90, startPosX, startPosX, startPosX + 90, startPosX + 90};

        int[] y = {startPosY - 100, startPosY - 75, startPosY - 10, startPosY + 25, startPosY + 50, startPosY + 50, startPosY + 75, startPosY + 100, startPosY + 100, startPosY + 110,
                startPosY + 100, startPosY + 100, startPosY + 75, startPosY + 50, startPosY + 50, startPosY + 25, startPosY - 10, startPosY - 75};

        g.fillPolygon(x, y, 18);

        Graphics2D g2 = (Graphics2D) g;

        if (propeller)
        {
            g.setColor(DopColor2);
            //pen = new Pen(DopColor2);
            //pen.Width = 3;
            g2.setStroke(new BasicStroke(3));
            g2.drawLine(startPosX + 85, startPosY - 95, startPosX + 115, startPosY - 95);

        }
        if (chassis)
        {
            g.setColor(DopColor2);
            //pen = new Pen(DopColor2);
            //pen.width = 3;
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
            //pen = new Pen(DopColor2);
            //pen.Width = 3;
            g2.setStroke(new BasicStroke(3));
            g2.drawLine(startPosX + 100, startPosY + 95, startPosX + 100, startPosY + 120);
        }
        if (rockets)
        {
            g.setColor(DopColor);
            //pen = new Pen(DopColor);
            //pen.Width = 5;
            g2.setStroke(new BasicStroke(5));

            g2.drawLine(startPosX + 25, startPosY + 10, startPosX + 25, startPosY + 35);
            g2.drawLine(startPosX + 50, startPosY, startPosX + 50, startPosY + 25);
            g2.drawLine(startPosX + 75, startPosY - 10, startPosX + 75, startPosY + 15);

            g2.drawLine(startPosX + 125, startPosY - 10, startPosX + 125, startPosY + 15);
            g2.drawLine(startPosX + 150, startPosY, startPosX + 150, startPosY + 25);
            g2.drawLine(startPosX + 175, startPosY + 10, startPosX + 175, startPosY + 35);

        }
        if (bombs)
        {
            g.setColor(DopColor);
            //brush = new SolidBrush(DopColor);
            g.fillOval(startPosX + 93, startPosY - 25, 14, 28);
            g.fillOval(startPosX + 93, startPosY + 25, 14, 28);
        }
    }
}
