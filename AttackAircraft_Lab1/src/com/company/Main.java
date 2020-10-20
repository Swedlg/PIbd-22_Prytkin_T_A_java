package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Main {

    //Главное окно
    private JFrame frame;

    //Панель
    private MyPanel panel;

    //Набор строк для JComboBox
    private String[] jComboBoxVars = {"Две пушки и бомбы", "Четыре пушки и бомбы", "Шесть пушек и бомб"};

    //Самолет
    private AttackAircraft attackAircraft;

    Random rnd = new Random();

    //Количество пушек и бомб
    private int countOfCannonsAndBombs = 2;

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

    /**
     * Инициализация окна
     */
    private void initialize() throws IOException {

        //Главное окно
        frame = new JFrame("ПИбд-22 || Прыткин Тимофей || Вариант 21 - Штурмовик.");
        frame.setBounds(100, 100, 1068, 678);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        //Панель для отрисовки самолета
        panel = new MyPanel();
        panel.setBounds(10, 11, 1032, 475);
        attackAircraft = new AttackAircraft(rnd.nextInt(500) + 1000, rnd.nextInt(1000) + 2000, Color.BLUE, Color.RED, Color.GREEN, Color.YELLOW, true, true, true, true, true, countOfCannonsAndBombs);
        panel.setAttackAircraft(attackAircraft);
        attackAircraft.SetPosition(150+(int)(Math.random()*50), 150+(int)(Math.random()*50), panel.getWidth(), panel.getHeight());
        panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        frame.getContentPane().add(panel);

        //Кнопка создания нового штурмовика
        JButton button_CreateAttackAircraft = new JButton("Create Attack Aircraft");
        button_CreateAttackAircraft.addActionListener(e -> {
            System.out.println("Создается новый штурмовик.");
            attackAircraft = new AttackAircraft(rnd.nextInt(500) + 1000, rnd.nextInt(1000) + 2000, Color.BLUE, Color.RED, Color.GREEN, Color.YELLOW, rnd.nextBoolean(), rnd.nextBoolean(), rnd.nextBoolean(), true, true, countOfCannonsAndBombs);
            panel.setAttackAircraft(attackAircraft);
            attackAircraft.SetPosition(150+(int)(Math.random()*50), 150+(int)(Math.random()*50), panel.getWidth(), panel.getHeight());
            frame.repaint();
        });
        button_CreateAttackAircraft.setBounds(10, 497, 210, 131);
        button_CreateAttackAircraft.setFocusable(false);
        frame.getContentPane().add(button_CreateAttackAircraft);

        //Кнопка для создания нового пассажирского самолета
        JButton button_CreatePlane = new JButton("Create Plane");
        button_CreatePlane.addActionListener(e -> {
            System.out.println("Создается новый пассажирский самолет.");
            countOfCannonsAndBombs = 0;
            attackAircraft = new AttackAircraft(rnd.nextInt(500) + 1000, rnd.nextInt(1000) + 2000, Color.BLUE, Color.RED, Color.GREEN, Color.YELLOW, rnd.nextBoolean(), rnd.nextBoolean(), rnd.nextBoolean(), false, false, countOfCannonsAndBombs);
            panel.setAttackAircraft(attackAircraft);
            attackAircraft.SetPosition(150+(int)(Math.random()*50), 150+(int)(Math.random()*50), panel.getWidth(), panel.getHeight());
            frame.repaint();
        });
        button_CreatePlane.setBounds(230, 497, 210, 131);
        button_CreatePlane.setFocusable(false);
        frame.getContentPane().add(button_CreatePlane);

        //Кнопка для передвижения самолета вправо
        JButton button_Right = new JButton(new ImageIcon(ImageIO.read(new File("bRight.png"))));
        button_Right.addActionListener(e -> {
            attackAircraft.MoveTransport(Directions.Right);
            frame.repaint();
        });
        button_Right.setBounds(982, 568, 60, 60);
        button_Right.setFocusable(false);
        frame.getContentPane().add(button_Right);

        //Кнопка для передвижения самолета вниз
        JButton button_Down = new JButton(new ImageIcon(ImageIO.read(new File("bDown.png"))));
        button_Down.addActionListener(e -> {
            attackAircraft.MoveTransport(Directions.Down);
            frame.repaint();
        });
        button_Down.setBounds(912, 568, 60, 60);
        button_Down.setFocusable(false);
        frame.getContentPane().add(button_Down);

        //Кнопка для передвижения самолета влево
        JButton button_Left = new JButton(new ImageIcon(ImageIO.read(new File("bLeft.png"))));
        button_Left.addActionListener(e -> {
            attackAircraft.MoveTransport(Directions.Left);
            frame.repaint();
        });
        button_Left.setBounds(842, 568, 60, 60);
        button_Left.setFocusable(false);
        frame.getContentPane().add(button_Left);

        //Кнопка для передвижения самолета вверх
        JButton button_Up = new JButton(new ImageIcon(ImageIO.read(new File("bUp.png"))));
        button_Up.addActionListener(arg0 -> {
            attackAircraft.MoveTransport(Directions.Up);
            frame.repaint();
        });
        button_Up.setBounds(912, 497, 60, 60);
        button_Up.setFocusable(false);
        frame.getContentPane().add(button_Up);

        //Селектор выбора количества ракет и бомб
        JComboBox<String> comboBox = new JComboBox<>(jComboBoxVars);
        comboBox.addActionListener(e -> {
            if (Objects.equals(comboBox.getSelectedItem(), "Две пушки и бомбы")) {
                countOfCannonsAndBombs = 2;
            } else if (Objects.equals(comboBox.getSelectedItem(), "Четыре пушки и бомбы")) {
                countOfCannonsAndBombs = 4;
            } else if (comboBox.getSelectedItem().equals("Шесть пушек и бомб")) {
                countOfCannonsAndBombs = 6;
            }
            attackAircraft.setCountOfCannonsAndBombs(countOfCannonsAndBombs);
            frame.repaint();
        });
        comboBox.setBounds(450, 497, 175, 39);
        comboBox.setFocusable(false);
        frame.getContentPane().add(comboBox);
    }
}
