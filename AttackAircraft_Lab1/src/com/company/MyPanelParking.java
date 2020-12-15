package com.company;

import javax.swing.*;
import java.awt.*;

public class MyPanelParking extends JPanel {

    private final Parking<ITransport, ICannonsAndBombs> parking;

    public MyPanelParking(Parking<ITransport, ICannonsAndBombs> parking) {
        this.parking = parking;
    }

    public void paint(Graphics g) {
        if (parking != null) {
            parking.draw(g);
        }
    }
}
