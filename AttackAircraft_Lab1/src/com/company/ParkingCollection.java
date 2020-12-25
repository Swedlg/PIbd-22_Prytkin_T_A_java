package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ParkingCollection {

    private final Map<String, Parking<ICannonsAndBombs, Plane>> parkingStages;

    private final int frameWidth;

    private final int frameHeight;

    /**
     * Конструктор коллекции парковок
     * @param frameWidth Ширина
     * @param frameHeight Высота
     */
    public ParkingCollection(int frameWidth, int frameHeight) {
        parkingStages = new HashMap<>();
        this.frameWidth = frameWidth;
        this.frameHeight = frameHeight;
    }

    public Set<String> keySet() {
        return parkingStages.keySet();
    }

    /**
     * Добавить парковку
     * @param name Имя парковки
     */
    public void addParking(String name) {
        if (!parkingStages.containsKey(name)) {
            parkingStages.put(name, new Parking<>(frameWidth, frameHeight));
        }
    }

    /**
     * Удалит парковку
     * @param name Имя парковки
     */
    public void removeParking(String name) {
        parkingStages.remove(name);
    }

    /**
     * Получить парковку по имени
     * @param name Имя
     * @return парковка
     */
    public Parking<ICannonsAndBombs, Plane> get(String name) {
        if (parkingStages.containsKey(name)) {
            return parkingStages.get(name);
        }
        return null;
    }

    /**
     * Получить самолет из парковки по имени парковки и индексу самолета в ней
     * @param name Имя парковки
     * @param index Индекс самолета в парковке
     * @return Самолет
     */
    public Plane getByIndex(String name, int index) {
        if (parkingStages.containsKey(name)) {
            return parkingStages.get(name).get(index);
        }
        return null;
    }
}
