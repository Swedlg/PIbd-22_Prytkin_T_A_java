package com.company;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.util.Objects;

public class FrameAttackAircraft {

    //Главное окно
    public JFrame frame;

    //Панель
    private MyPanelFlyingPlane panel;

    //Набор строк для JComboBox
    private String[] jComboBoxVars = {"Две пушки и бомбы", "Четыре пушки и бомбы", "Шесть пушек и бомб"};

    //Набор строк для JComboBox
    private String[] jComboBoxFormsOfCannonsAndBombs = {"Первый тип рокет и бомб", "Второй тип рокет и бомб", "Третий тип рокет и бомб"};

    //Самолет
    private ITransport plane;

    //Количество пушек и бомб
    private CountOfCannonsAndBombs countOfCannonsAndBombs = CountOfCannonsAndBombs.getCountOfCannonsAbdBox(2);

    //Форма ракет и бомб
    private TypeOfCannonsAndBombs typeOfCannonsAndBombs = TypeOfCannonsAndBombs.getTypeOfCannonsAndBombs(1);

    public FrameAttackAircraft() {
        initialize();
    }

    /**
     * Инициализация окна
     */
    private void initialize() {

        //Главное окно
        frame = new JFrame("ПИбд-22 || Прыткин Тимофей || Вариант 21 - Штурмовик.");
        frame.setBounds(100, 100, 1068, 678);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        //Панель для отрисовки самолета
        panel = new MyPanelFlyingPlane();
        panel.setBounds(10, 11, 1032, 475);
        panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        frame.getContentPane().add(panel);

        //Кнопка для передвижения самолета вправо
        JButton button_Right = new JButton();
        button_Right.addActionListener(e -> {
            plane.moveTransport(Directions.Right);
            frame.repaint();
        });
        button_Right.setBounds(982, 568, 60, 60);
        button_Right.setFocusable(false);
        frame.getContentPane().add(button_Right);

        //Кнопка для передвижения самолета вниз
        JButton button_Down = new JButton();
        button_Down.addActionListener(e -> {
            plane.moveTransport(Directions.Down);
            frame.repaint();
        });
        button_Down.setBounds(912, 568, 60, 60);
        button_Down.setFocusable(false);
        frame.getContentPane().add(button_Down);

        //Кнопка для передвижения самолета влево
        JButton button_Left = new JButton();
        button_Left.addActionListener(e -> {
            plane.moveTransport(Directions.Left);
            frame.repaint();
        });
        button_Left.setBounds(842, 568, 60, 60);
        button_Left.setFocusable(false);
        frame.getContentPane().add(button_Left);

        //Кнопка для передвижения самолета вверх
        JButton button_Up = new JButton();
        button_Up.addActionListener(arg0 -> {
            plane.moveTransport(Directions.Up);
            frame.repaint();
        });
        button_Up.setBounds(912, 497, 60, 60);
        button_Up.setFocusable(false);
        frame.getContentPane().add(button_Up);

        //Селектор выбора количества ракет и бомб
        JComboBox<String> comboBox = new JComboBox<>(jComboBoxVars);
        comboBox.addActionListener(e -> {
            if (Objects.equals(comboBox.getSelectedItem(), "Две пушки и бомбы")) {
                countOfCannonsAndBombs = CountOfCannonsAndBombs.getCountOfCannonsAbdBox(2);
            } else if (Objects.equals(comboBox.getSelectedItem(), "Четыре пушки и бомбы")) {
                countOfCannonsAndBombs = CountOfCannonsAndBombs.getCountOfCannonsAbdBox(4);
            } else if (comboBox.getSelectedItem().equals("Шесть пушек и бомб")) {
                countOfCannonsAndBombs = CountOfCannonsAndBombs.getCountOfCannonsAbdBox(6);
            }

            if(plane instanceof AttackAircraft){
                ((AttackAircraft)plane).setCountOfCannonsAndBombs(countOfCannonsAndBombs, typeOfCannonsAndBombs);
            }

            frame.repaint();
        });
        comboBox.setBounds(450, 497, 175, 39);
        comboBox.setFocusable(false);
        frame.getContentPane().add(comboBox);

        //Селектор выбора форм ракет и бомб
        JComboBox<String> comboBoxFormsOfCannons = new JComboBox<>(jComboBoxFormsOfCannonsAndBombs);
        comboBoxFormsOfCannons.addActionListener(e -> {
            if (Objects.equals(comboBoxFormsOfCannons.getSelectedItem(), "Первый тип рокет и бомб")) {
                typeOfCannonsAndBombs = TypeOfCannonsAndBombs.getTypeOfCannonsAndBombs(1);
            } else if (Objects.equals(comboBoxFormsOfCannons.getSelectedItem(), "Второй тип рокет и бомб")) {
                typeOfCannonsAndBombs = TypeOfCannonsAndBombs.getTypeOfCannonsAndBombs(2);
            } else if (Objects.equals(comboBoxFormsOfCannons.getSelectedItem(), "Третий тип рокет и бомб")) {
                typeOfCannonsAndBombs = TypeOfCannonsAndBombs.getTypeOfCannonsAndBombs(3);
            }

            if(plane instanceof AttackAircraft){
                ((AttackAircraft)plane).setCountOfCannonsAndBombs(countOfCannonsAndBombs, typeOfCannonsAndBombs);
            }

            frame.repaint();
        });
        comboBoxFormsOfCannons.setBounds(450, 543, 175, 39);
        comboBoxFormsOfCannons.setFocusable(false);
        frame.getContentPane().add(comboBoxFormsOfCannons);
    }

    public void setPlane(ITransport plane){
        this.plane = plane;
        plane.setPosition(150+(int)(Math.random()*50), 150+(int)(Math.random()*50), panel.getWidth(), panel.getHeight());
        panel.setPlane(plane);
        frame.repaint();
    }
}
