package com.company;

import java.awt.*;

public class AttackAircraft extends Plane {

    //Цвета
    private Color colorOfCamouflage;
    private Color colorOfCannonsAndBombs;

    //Наличие камуфляжа
    public boolean camouflage;

    //Наличие ракет
    public boolean rockets;

    //Наличие бомб
    public boolean bombs;

    //Количесвто ракет и бомб
    private CountOfCannonsAndBombs countOfCannonsAndBombs;

    //Экземпляр класс ракет и бомб
    private ICannonsAndBombs cannonsAndBombs;

    //Тип ракет и бомб
    private TypeOfCannonsAndBombs typeOfCannonsAndBombs ;

    public AttackAircraft(int maxSpeed, int weight, Color colorOfPassengerPlane, Color colorOfDetail, Color colorOfCamouflage, Color colorOfCannonsAndBombs, boolean propeller, boolean chassis, boolean antenna, boolean rockets, boolean bombs, CountOfCannonsAndBombs countOfCannonsAndBombs, TypeOfCannonsAndBombs typeOfCannonsAndBombs)
    {
        super(maxSpeed, weight, colorOfPassengerPlane,colorOfDetail, propeller, chassis, antenna, 200, 100);
        this.maxSpeed = maxSpeed;
        this.weight = weight;
        this.colorOfPassengerPlane = colorOfPassengerPlane;
        this.colorOfDetail = colorOfDetail;
        this.colorOfCamouflage = colorOfCamouflage;
        this.colorOfCannonsAndBombs = colorOfCannonsAndBombs;
        this.rockets = rockets;
        this.bombs = bombs;
        camouflage = rockets || bombs;

        if (camouflage){
            this.countOfCannonsAndBombs = countOfCannonsAndBombs;
            this.typeOfCannonsAndBombs = typeOfCannonsAndBombs;


            switch(typeOfCannonsAndBombs) {

                case First:
                    cannonsAndBombs = new TypeOfCannonsAndBombs1(countOfCannonsAndBombs);
                    break;
                case Second:
                    cannonsAndBombs = new TypeOfCannonsAndBombs2(countOfCannonsAndBombs);
                    break;
                case Third:
                    cannonsAndBombs = new TypeOfCannonsAndBombs3(countOfCannonsAndBombs);
                    break;
                default:
                    break;

            }
        }
    }

    /**
     * Установить количесвто ракет и бомб
     * @param countOfCannonsAndBombs Количество ракет и бомб
     */
    public void setCountOfCannonsAndBombs(CountOfCannonsAndBombs countOfCannonsAndBombs, TypeOfCannonsAndBombs formOfCannonsAndBombs) {

        System.out.println("Устанавливается количество ракет и бомб: " + countOfCannonsAndBombs);

        if (camouflage){
            this.countOfCannonsAndBombs = countOfCannonsAndBombs;
            this.typeOfCannonsAndBombs = formOfCannonsAndBombs;


            switch(typeOfCannonsAndBombs) {

                case First:
                    cannonsAndBombs = new TypeOfCannonsAndBombs1(countOfCannonsAndBombs);
                    break;
                case Second:
                    cannonsAndBombs = new TypeOfCannonsAndBombs2(countOfCannonsAndBombs);
                    break;
                case Third:
                    cannonsAndBombs = new TypeOfCannonsAndBombs3(countOfCannonsAndBombs);
                    break;
                default:
                    break;
            }
        }
        else {
            System.out.println("Не удалось установить ракеты и бомбы! Самолет пассажирский!");
        }
    }

    /**
     * Метод отрисовка самолета
     * @param g Полотно отрисовки
     */
    public void drawAttackAircraft(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;
        g.setColor(colorOfCamouflage);

        g2.setStroke(new BasicStroke(10));
        g2.drawLine(startPosX + 100, startPosY - 100, startPosX + 110, startPosY - 75);
        g2.drawLine(startPosX + 110, startPosY - 75, startPosX + 110, startPosY - 10);
        g2.drawLine(startPosX + 110, startPosY - 10, startPosX + 200, startPosY + 25);
        g2.drawLine(startPosX + 200, startPosY + 25, startPosX + 200, startPosY + 50);
        g2.drawLine(startPosX + 200, startPosY + 50, startPosX + 110, startPosY + 50);
        g2.drawLine(startPosX + 110, startPosY + 50, startPosX + 110, startPosY + 75);
        g2.drawLine(startPosX + 110, startPosY + 75, startPosX + 125, startPosY + 100);
        g2.drawLine(startPosX + 125, startPosY + 100, startPosX + 110, startPosY + 100);
        g2.drawLine(startPosX + 110, startPosY + 100, startPosX + 100, startPosY + 110);
        g2.drawLine(startPosX + 100, startPosY + 110, startPosX + 90, startPosY + 100);
        g2.drawLine(startPosX + 90, startPosY + 100, startPosX + 75, startPosY + 100);
        g2.drawLine(startPosX + 75, startPosY + 100, startPosX + 90, startPosY + 75);
        g2.drawLine(startPosX + 90, startPosY + 75, startPosX + 90, startPosY + 50);
        g2.drawLine(startPosX + 90, startPosY + 50, startPosX, startPosY + 50);
        g2.drawLine(startPosX, startPosY + 50, startPosX, startPosY + 25);
        g2.drawLine(startPosX, startPosY + 25, startPosX + 90, startPosY - 10);
        g2.drawLine(startPosX + 90, startPosY - 10, startPosX + 90, startPosY - 75);
        g2.drawLine(startPosX + 90, startPosY - 75, startPosX + 100, startPosY - 100);

        super.drawTransport(g);
        cannonsAndBombs.drawDetail(g, startPosX, startPosY, colorOfCannonsAndBombs);
    }
}
