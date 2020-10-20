package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Main {

    private JFrame frame;
    private MyPanel panel;

    Random rnd = new Random();

    private int countOfCannonAndBombs = 2;

    public Main() throws IOException {
        initialize();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Main main = new Main();
                main.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private void initialize() throws IOException {
        frame = new JFrame();
        frame.setBounds(100, 100, 1068, 678);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        panel = new MyPanel();
        panel.setAttackAircraft(new AttackAircraft(rnd.nextInt(500) + 1000, rnd.nextInt(1000) + 2000, Color.BLUE, Color.RED, Color.GREEN, Color.YELLOW, rnd.nextBoolean(), rnd.nextBoolean(), rnd.nextBoolean(), rnd.nextBoolean(), rnd.nextBoolean()));
        panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        panel.setBounds(10, 11, 1032, 475);
        frame.getContentPane().add(panel);

        JButton button_CreateAttackAircraft = new JButton("Create Attack Aircraft");
        button_CreateAttackAircraft.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        button_CreateAttackAircraft.setBounds(10, 497, 210, 131);
        frame.getContentPane().add(button_CreateAttackAircraft);

        JButton button_CreatePlane = new JButton("Create Plane");
        button_CreatePlane.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        button_CreatePlane.setBounds(230, 497, 210, 131);
        frame.getContentPane().add(button_CreatePlane);

        JButton button_Right = new JButton(new ImageIcon(ImageIO.read(new File("bRight.png"))));
        button_Right.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        button_Right.setBounds(982, 568, 60, 60);
        frame.getContentPane().add(button_Right);

        JButton button_Down = new JButton(new ImageIcon(ImageIO.read(new File("bDown.png"))));
        button_Down.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        button_Down.setBounds(912, 568, 60, 60);
        frame.getContentPane().add(button_Down);

        JButton button_Left = new JButton(new ImageIcon(ImageIO.read(new File("bLeft.png"))));
        button_Left.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        button_Left.setBounds(842, 568, 60, 60);
        frame.getContentPane().add(button_Left);

        JButton button_Up = new JButton(new ImageIcon(ImageIO.read(new File("bUp.png"))));
        button_Up.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        button_Up.setBounds(912, 497, 60, 60);
        frame.getContentPane().add(button_Up);

        JComboBox comboBox = new JComboBox();
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (comboBox.getSelectedItem().equals("Two")) {
                    countOfCannonAndBombs = 2;
                } else if (comboBox.getSelectedItem().equals("Four")) {
                    countOfCannonAndBombs = 4;
                } else if (comboBox.getSelectedItem().equals("Six")) {
                    countOfCannonAndBombs = 6;
                }
            }
        });
        comboBox.setBounds(450, 497, 125, 39);
        frame.getContentPane().add(comboBox);
    }
}
