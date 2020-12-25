package com.company;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class FrameParking {

    //Главное окно
    public JFrame frame;

    //Поле для ввода индекса
    private JTextField textFieldOfIndex;

    //Полк для ввода имени парковки
    private JTextField textFieldOfParkingName;

    private DefaultListModel<String> modelPlaneParking = new DefaultListModel<>();

    //Список парковок (JList)
    private JList<String> listBoxParking = new JList<>(modelPlaneParking);

    //очередь для самолетов
    private Queue<Plane> queueOfPlanes = new LinkedList<>();

    //Экземпляр коллеции парковок
    private ParkingCollection parkingCollection = new ParkingCollection(697, 608);

    /**
     * Конструктор парковки
     */
    public FrameParking() {
        initialize();
    }

    /**
     * Инициализация окна
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 1006, 681);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        MyPanelParking myPanelParking = new MyPanelParking(parkingCollection);

        myPanelParking.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        myPanelParking.setBounds(10, 11, 697, 623);
        frame.getContentPane().add(myPanelParking);

        JButton buttonParkPlane = new JButton("Припарковать военный самолет");
        buttonParkPlane.addActionListener(arg0 -> {
            if (listBoxParking.getSelectedIndex() >= 0) {
                JColorChooser colorDialog = new JColorChooser();
                JOptionPane.showMessageDialog(frame, colorDialog);
                if (colorDialog.getColor() != null) {
                    Plane plane = new Plane(1250, 2500, colorDialog.getColor(), Color.GREEN, true, true, true, 200, 100);
                    if (parkingCollection.get(listBoxParking.getSelectedValue()).add(plane)) {
                        frame.repaint();
                    } else {
                        JOptionPane.showMessageDialog(frame, "Парковка запонена");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(frame, "Выберите парковку", "Ошибка", JOptionPane.ERROR_MESSAGE);
            }
        });
        buttonParkPlane.setBounds(713, 11, 267, 89);
        frame.getContentPane().add(buttonParkPlane);

        JButton buttonParkAttackAircraft = new JButton("Припарковать штурмовик");
        buttonParkAttackAircraft.addActionListener(e -> {
            if (listBoxParking.getSelectedIndex() >= 0) {
                JColorChooser colorDialog = new JColorChooser();
                JOptionPane.showMessageDialog(frame, colorDialog);
                if (colorDialog.getColor() != null) {
                    JColorChooser otherColorDialog = new JColorChooser();
                    JOptionPane.showMessageDialog(frame, otherColorDialog);
                    if (otherColorDialog.getColor() != null) {
                        AttackAircraft attackAircraft = new AttackAircraft(1250, 2500, colorDialog.getColor(), Color.RED, Color.GREEN, otherColorDialog.getColor(), true, true, true, true, true, CountOfCannonsAndBombs.getCountOfCannonsAbdBox(6), TypeOfCannonsAndBombs.getTypeOfCannonsAndBombs(1));
                        if (parkingCollection.get(listBoxParking.getSelectedValue()).add(attackAircraft)) {
                            frame.repaint();
                        } else {
                            JOptionPane.showMessageDialog(frame, "Парковка переполнена");
                        }
                    }
                }
            } else {
                JOptionPane.showMessageDialog(frame, "Выберите парковку", "Ошибка", JOptionPane.ERROR_MESSAGE);
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
            if (listBoxParking.getSelectedIndex() >= 0) {

                if (!textFieldOfIndex.getText().equals("")) {
                    try {
                        ITransport plane = parkingCollection.get(listBoxParking.getSelectedValue()).remove(Integer.parseInt(textFieldOfIndex.getText()));

                        if (plane != null) {
                            FrameAttackAircraft frameAttackAircraft = new FrameAttackAircraft();
                            frameAttackAircraft.setPlane(plane);
                            frameAttackAircraft.frame.setVisible(true);
                            frame.repaint();
                        } else {
                            JOptionPane.showMessageDialog(frame, "Самолета на таком месте нет");
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(frame, "Неверно введены данные по индексу");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(frame, "Выберите парковку", "Ошибка", JOptionPane.ERROR_MESSAGE);
            }
        });
        buttonTakeFromParking.setBounds(713, 236, 267, 89);
        frame.getContentPane().add(buttonTakeFromParking);

        JLabel labelNameOfParking = new JLabel("Введите имя парковки:");
        labelNameOfParking.setBounds(713, 339, 126, 14);
        frame.getContentPane().add(labelNameOfParking);

        textFieldOfParkingName = new JTextField();
        textFieldOfParkingName.setBounds(849, 336, 131, 20);
        frame.getContentPane().add(textFieldOfParkingName);
        textFieldOfParkingName.setColumns(10);


        listBoxParking.setBounds(713, 359, 267, 96);
        listBoxParking.addListSelectionListener(listSelectionEvent -> {
            myPanelParking.setParking(listBoxParking.getSelectedValue());
            frame.repaint();
        });
        frame.getContentPane().add(listBoxParking);

        JButton buttonAddParking = new JButton("Добавить парковку");
        buttonAddParking.addActionListener(arg0 -> {
            if (!textFieldOfParkingName.getText().equals("")) {
                parkingCollection.addParking(textFieldOfParkingName.getText());
                reloadLevels();
                frame.repaint();
            } else {
                JOptionPane.showMessageDialog(frame, "Введите название парковки", "Ошибка", JOptionPane.ERROR_MESSAGE);
            }
        });
        buttonAddParking.setBounds(713, 461, 267, 35);
        frame.getContentPane().add(buttonAddParking);

        JButton buttonDeleteParking = new JButton("Удалить парковку");
        buttonDeleteParking.addActionListener(e -> {

            if (listBoxParking.getSelectedIndex() >= 0) {
                parkingCollection.removeParking(listBoxParking.getSelectedValue());
                reloadLevels();
                frame.repaint();
            } else {
                JOptionPane.showMessageDialog(frame, "ВЫберите парковку для удаления", "Ошибка", JOptionPane.ERROR_MESSAGE);
            }
        });
        buttonDeleteParking.setBounds(713, 507, 267, 35);
        frame.getContentPane().add(buttonDeleteParking);

        JButton buttonAddToQueue = new JButton("Добавить в очередь");
        buttonAddToQueue.addActionListener(e -> {

            if (!textFieldOfIndex.getText().equals("")) {
                try {
                    Plane plane = parkingCollection.get(listBoxParking.getSelectedValue()).remove(Integer.parseInt(textFieldOfIndex.getText()));
                    System.out.println(plane.getClass().getName());

                    queueOfPlanes.add(plane);
                    frame.repaint();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Неверно введен индекс");
                }
            } else {
                JOptionPane.showMessageDialog(frame, "Номер самолета на парковке не указан", "Ошибка", JOptionPane.ERROR_MESSAGE);
            }

        });
        buttonAddToQueue.setBounds(713, 553, 267, 35);
        frame.getContentPane().add(buttonAddToQueue);

        JButton buttonRemoveFromQueue = new JButton("Убрать из очереди");
        buttonRemoveFromQueue.addActionListener(e -> {

            if (!queueOfPlanes.isEmpty()) {
                FrameAttackAircraft frameAttackAircraft;
                frameAttackAircraft = new FrameAttackAircraft();
                frameAttackAircraft.setPlane(Objects.requireNonNull(queueOfPlanes.poll()));
                frameAttackAircraft.frame.setVisible(true);
                frame.repaint();
            } else {
                JOptionPane.showMessageDialog(frame, "В очереди закончились самолеты", "Очередь пуста", JOptionPane.ERROR_MESSAGE);
            }

        });
        buttonRemoveFromQueue.setBounds(713, 599, 267, 35);
        frame.getContentPane().add(buttonRemoveFromQueue);
    }

    private void reloadLevels() {
        int index = listBoxParking.getSelectedIndex();

        modelPlaneParking.removeAllElements();
        int i = 0;
        for (String name : parkingCollection.keySet()) {
            modelPlaneParking.add(i, name);
            i++;
        }

        int itemsCount = modelPlaneParking.size();
        if (itemsCount > 0 && (index < 0 || index >= itemsCount)) {
            listBoxParking.setSelectedIndex(0);
        } else if (index >= 0 && index < itemsCount) {
            listBoxParking.setSelectedIndex(index);
        }
    }
}
