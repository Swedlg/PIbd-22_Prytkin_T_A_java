package com.company;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class MyPanel extends JPanel {

    private AttackAircraft attackAircraft;

    public void setAttackAircraft(AttackAircraft attackAircraft) {
        this.attackAircraft = attackAircraft;
    }

    public void paint(Graphics g) {
        if (attackAircraft != null) {
            try {
                Graphics2D g2 = (Graphics2D) g;
                g2.drawImage((new ImageIcon("sky-2868089_1920.jpg")).getImage(), 0, 0,this);

                attackAircraft.drawTransport(g);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
