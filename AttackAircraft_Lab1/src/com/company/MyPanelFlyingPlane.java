package com.company;

import javax.swing.*;
import java.awt.*;

public class MyPanelFlyingPlane extends JPanel {

    //Экземпляр самолета
    private Plane plane;

    /**
     * Установить экземпляр класса AttackAircraft
     * @param plane Экземпляр самолета
     */
    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    /**
     * Отрисовка панельки с самолетом
     * @param g Полотно JPanel
     */
    public void paint(Graphics g) {
        if (plane != null) {
            Graphics2D g2 = (Graphics2D) g;
            g2.drawImage((new ImageIcon("sky-2868089_1920.jpg")).getImage(), 0, 0,this);

            if(plane instanceof AttackAircraft){
                ((AttackAircraft) plane).drawAttackAircraft(g);
            } else{
                plane.drawTransport(g);
            }
        }
    }
}
