package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ParkingCollection {

    private final Map<String, Parking<Plane, ICannonsAndBombs>> parkingStages;

    private final int frameWidth;

    private final int frameHeight;

    public ParkingCollection(int frameWidth, int frameHeight) {
        parkingStages = new HashMap<>();
        this.frameWidth = frameWidth;
        this.frameHeight = frameHeight;
    }

    public Set<String> keySet() {
        return parkingStages.keySet();
    }

    public void addParking(String name) {
        if (!parkingStages.containsKey(name)) {
            parkingStages.put(name, new Parking<>(frameWidth, frameHeight));
        }
    }

    public void removeParking(String name) {
        parkingStages.remove(name);
    }

    public Parking<Plane, ICannonsAndBombs> get(String name) {
        if (parkingStages.containsKey(name)) {
            return parkingStages.get(name);
        }
        return null;
    }

    public Plane get(String name, int index) {
        if (parkingStages.containsKey(name)) {
            return parkingStages.get(name).get(index);
        }
        return null;
    }
}
