package com.company;

import java.awt.*;

public class Parking<T extends ITransport, ICannonsAndBombs> {

    private final Object[] places;

    private final int pictureWidth;

    private final int pictureHeight;

    private final int placeSizeWidth = 250;

    private final int placeSizeHeight = 230;

    /**
     * Конструктор парковки
     * @param pictureWidth Ширина картинки
     * @param pictureHeight Высота картинки
     */
    public Parking(int pictureWidth, int pictureHeight) {
        int width = pictureWidth / placeSizeWidth;
        int height = pictureHeight / placeSizeHeight;
        places = new Object[width * height];
        this.pictureWidth = pictureWidth;
        this.pictureHeight = pictureHeight;
    }

    /**
     * Добавить самолет на парковку
     * @param plane Самолет
     * @return Получилось ли добавить
     */
    public boolean add(T plane) {
        for (int i = 0; i < places.length; i++)
        {
            if (places[i] == null)
            {
                places[i] = plane;
                plane.setPosition(10 + ((i / 2) * 250), 100 + ((i % 2) * 230), pictureWidth, pictureHeight);
                return true;
            }
        }
        return false;
    }

    /**
     * Убрать самолет с парковки
     * @param index Индекс на парковке
     * @return Самолет полученный по индексу
     */
    public T remove(int index)
    {

        if (places.length > index && index >= 0 && places[index] != null)
        {
            Object plane = places[index];

            System.out.println(plane.getClass().getName());
            places[index] = null;

            return ((T) plane);
        }

        return null;
    }

    /**
     * Больше или равно?
     * @param countForCompare число
     * @return результат проверки
     */
    public boolean MoreOrEquals(int countForCompare) {
        int count = 0;
        for (Object place : places) {
            if (place != null) {
                count++;
            }
        }
        return (countForCompare >= count);
    }

    /**
     * Меньше или равно?
     * @param countForCompare число
     * @return результат проверки
     */
    public boolean LessOrEquals(int countForCompare) {
        int count = 0;
        for (Object place : places) {
            if (place != null) {
                count++;
            }
        }
        return (countForCompare <= count);
    }


    /**
     * Отрисовка всех самолетов на парковке
     * @param g Полотно
     */
    public void draw(Graphics g)
    {
        drawMarking(g);
        for (Object place : places) {
            if (place != null) {
                ((T) place).drawTransport(g);
            }
        }
    }

    /**
     * Отрисовка маркировки на парковке
     * @param g Полотно
     */
    private void drawMarking(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(3.0f));

        for (int i = 0; i < pictureWidth / placeSizeWidth; i++)
        {
            for (int j = 0; j < pictureHeight / placeSizeHeight + 1; ++j)
            {//линия рамзетки места
                g.drawLine( i * placeSizeWidth, j * placeSizeHeight, i * placeSizeWidth + placeSizeWidth / 2, j * placeSizeHeight);
            }
            g.drawLine( i * placeSizeWidth, 0, i * placeSizeWidth, (pictureHeight / placeSizeHeight) * placeSizeHeight);
        }
    }
}
