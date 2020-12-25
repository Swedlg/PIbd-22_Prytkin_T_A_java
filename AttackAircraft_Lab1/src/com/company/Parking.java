package com.company;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Parking<Q extends ICannonsAndBombs, T extends ITransport> {

    private final List<T> places;

    private final int countOfPlaces;

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
        this.pictureWidth = pictureWidth;
        this.pictureHeight = pictureHeight;
        int width = pictureWidth / placeSizeWidth;
        int height = pictureHeight / placeSizeHeight;
        countOfPlaces = width*height;
        places = new ArrayList<>();
    }

    /**
     * Добавить самолет на парковку
     * @param plane Самолет
     * @return Получилось ли добавить
     */
    public boolean add(T plane) {
        if (places.size() < countOfPlaces)
        {
            places.add(plane);
            return true;
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
        if (index < countOfPlaces && index >= 0 && places.get(index) != null)
        {
            T plane = places.get(index);
            places.remove(index);
            return plane;
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

        for (int i = 0; i < places.size(); i++) {
            if (places.get(i) != null) {
                T plane = places.get(i);
                plane.setPosition( (i / 2) * placeSizeWidth + 15, (i % 2) * placeSizeHeight + 105, pictureWidth, pictureHeight);
                plane.drawTransport(g);
            } else {
                return;
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

    /**
     * Вернуть самолет по индексу
     * @param index Индекс
     * @return Самолет
     */
    public T get(int index) {
        if (index >= 0 && index < places.size()) {
            return places.get(index);
        }
        return null;
    }
}
