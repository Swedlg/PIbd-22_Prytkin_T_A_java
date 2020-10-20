package com.company;

import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {

    //Экземпляр самолета
    private AttackAircraft attackAircraft;

    /**
     * Установить экземпляр класса AttackAircraft
     * @param attackAircraft Экземпляр самолета
     */
    public void setAttackAircraft(AttackAircraft attackAircraft) {
        this.attackAircraft = attackAircraft;
    }

    /**
     * Отрисовка панельки с самолетом
     * @param g Полотно JPanel
     */
    public void paint(Graphics g) {
        if (attackAircraft != null) {
            Graphics2D g2 = (Graphics2D) g;
            g2.drawImage((new ImageIcon("sky-2868089_1920.jpg")).getImage(), 0, 0,this);
            attackAircraft.drawTransport(g);
        }
    }
}
