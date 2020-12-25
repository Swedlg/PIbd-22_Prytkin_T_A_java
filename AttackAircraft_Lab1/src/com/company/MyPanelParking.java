package com.company;

import javax.swing.*;
import java.awt.*;

public class MyPanelParking extends JPanel {

    private final Parking<ICannonsAndBombs, ITransport> parking;

    public MyPanelParking(Parking<ICannonsAndBombs, ITransport> parking) {
        this.parking = parking;
    }

    public void paint(Graphics g) {
        if (parking != null) {
            parking.draw(g);
        }
    }
}
