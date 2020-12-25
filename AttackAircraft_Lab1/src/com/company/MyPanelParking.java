package com.company;

import javax.swing.*;
import java.awt.*;

public class MyPanelParking extends JPanel {

    private ParkingCollection parkingCollection;
    private String currentParking = null;

    public MyPanelParking(ParkingCollection parkingCollection) {
        this.parkingCollection = parkingCollection;
    }

    public void paint(Graphics g) {
        if (currentParking != null) {
            if (parkingCollection != null) {
                parkingCollection.get(currentParking).draw(g);
            }
        }
    }

    public void setParking(String currentParking) {
        this.currentParking = currentParking;
    }
}
