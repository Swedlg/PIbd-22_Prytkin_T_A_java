package com.company;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class FrameParking {

    private Parking parking;

    public JFrame frame;
    private JTextField textFieldOfIndex;

    public FrameParking() {
        initialize();
    }

    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        if (parking != null) {
            parking.draw(g2);
        }
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 1006, 669);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        parking = new Parking(697, 608);
        MyPanelParking panel = new MyPanelParking(parking);

        panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        panel.setBounds(10, 11, 697, 608);
        frame.getContentPane().add(panel);

        JButton buttonParkPlane = new JButton("Припарковать военный самолет");
        buttonParkPlane.addActionListener(arg0 -> {

            JColorChooser colorDialog = new JColorChooser();
            JOptionPane.showMessageDialog(frame, colorDialog);
            if (colorDialog.getColor() != null) {
                Plane plane = new Plane(1250, 2500, Color.YELLOW, Color.GREEN, true, true, true, 200, 100);
                if (parking.add(plane)) {
                    frame.repaint();
                } else {
                    JOptionPane.showMessageDialog(frame, "Доки переполнены");
                }
            }

        });
        buttonParkPlane.setBounds(713, 11, 267, 89);
        frame.getContentPane().add(buttonParkPlane);

        JButton buttonParkAttackAircraft = new JButton("Припарковать штурмовик");
        buttonParkAttackAircraft.addActionListener(e -> {

            JColorChooser colorDialog = new JColorChooser();
            JOptionPane.showMessageDialog(frame, colorDialog);
            if (colorDialog.getColor() != null) {
                JColorChooser otherColorDialog = new JColorChooser();
                JOptionPane.showMessageDialog(frame, otherColorDialog);
                if (otherColorDialog.getColor() != null) {
                    AttackAircraft attackAircraft = new AttackAircraft(1250, 2500, Color.BLUE, Color.RED, Color.GREEN, Color.YELLOW, true, true, true, true, true, CountOfCannonsAndBombs.getCountOfCannonsAbdBox(6), TypeOfCannonsAndBombs.getTypeOfCannonsAndBombs(1));
                    if (parking.add(attackAircraft)) {
                        frame.repaint();
                    } else {
                        JOptionPane.showMessageDialog(frame, "Доки переполнены");
                    }
                }
            }

        });
        buttonParkAttackAircraft.setBounds(713, 111, 267, 89);
        frame.getContentPane().add(buttonParkAttackAircraft);

        JLabel labelPlace = new JLabel("Место:");
        labelPlace.setBounds(789, 211, 50, 14);
        frame.getContentPane().add(labelPlace);

        textFieldOfIndex = new JTextField();
        textFieldOfIndex.setBounds(849, 208, 131, 20);
        frame.getContentPane().add(textFieldOfIndex);
        textFieldOfIndex.setColumns(10);

        JButton buttonTakeFromParking = new JButton("Забрать самолет");
        buttonTakeFromParking.addActionListener(e -> {

            if (!textFieldOfIndex.getText().equals("")) {
                try {
                    ITransport plane = parking.remove(Integer.parseInt(textFieldOfIndex.getText()));
                    if (plane != null) {
                        FrameAttackAircraft frameAttackAircraft = new FrameAttackAircraft();
                        frameAttackAircraft.setPlane();
                        frame.repaint();
                    } else {
                        JOptionPane.showMessageDialog(frame, "Самолета на таком месте нет");
                    }
                } catch (NumberFormatException | IOException ex) {
                    JOptionPane.showMessageDialog(frame, "Неверно введены данные по индексу");
                }
            }


        });
        buttonTakeFromParking.setBounds(713, 236, 267, 89);
        frame.getContentPane().add(buttonTakeFromParking);
    }
}
