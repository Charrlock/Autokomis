package com.game.src.main;

import com.game.src.main.classes.Car;
import com.game.src.main.classes.Client;

import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import javax.swing.*;


public class Game implements ActionListener {

    Scanner scanner = new Scanner(System.in);
    Random random = new Random();

    ArrayList<Car> junkyard = new ArrayList<>();
    ArrayList<Car> garage = new ArrayList<>();
    ArrayList<Car> sold = new ArrayList<>();
    ArrayList<Client> potentialClients = new ArrayList<>();
    ArrayList<Client> availableClients = new ArrayList<>();
    ArrayList<Client> happyClients = new ArrayList<>();



    JFrame frame = new JFrame();
    JTextField moneyField = new JTextField();
    JTextField dayField = new JTextField();
    JTextField moneyDisplayedField = new JTextField();
    JTextArea gameArea = new JTextArea();
    JTextField junkyardVisit = new JTextField();


    //Buttons
    JButton JunkyardBtn = new JButton();
    JButton ClientsBtn = new JButton();
    JButton MechanicsBtn = new JButton();
    JButton AdvertisingBtn = new JButton();

    int day = 0;
    double money = 0.0;
    String moneyDisplayed = money + "$";
    JLabel daysPassed = new JLabel();

    public void nextDay(){
        this.day = day + 1;
    }

    public void addMoney(double gain){
        this.money = money + gain;
    }

    Timer timer = new Timer(1000, new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            daysPassed.setText(String.valueOf(day));
            moneyDisplayedField.setText(money + "$");

        }
    });




    public Game() {

        //Populating junkyard

        junkyard.add(new Car("BMW", true, true, false, true, true, false, "Premium"));
        junkyard.add(new Car("BMW", false, true, true, true, true, false, "Premium"));
        junkyard.add(new Car("BMW", true, false, true, true, true, false, "Premium"));
        junkyard.add(new Car("BMW", true, true, true, false, true, false, "Premium"));
        junkyard.add(new Car("BMW", true, true, true, true, false, false, "Premium"));

        // Frame

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900,590);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(null);
        frame.setResizable(false);

        // Day indicator

        dayField.setBounds(700,0,100,50);
        dayField.setBackground(new Color(100,100,100));
        dayField.setForeground(new Color(25,25,25));
        dayField.setFont(new Font(Font.MONOSPACED,Font.BOLD,30));
        dayField.setBorder(BorderFactory.createBevelBorder(1));
        dayField.setHorizontalAlignment(JTextField.LEFT);
        dayField.setOpaque(true);
        dayField.setEditable(false);
        dayField.setText("Day: ");

        //Money indicator

        moneyField.setBounds(0,0,110,50);
        moneyField.setBackground(new Color(100,100,100));
        moneyField.setForeground(new Color(25,25,25));
        moneyField.setFont(new Font(Font.MONOSPACED,Font.BOLD,30));
        moneyField.setBorder(BorderFactory.createBevelBorder(1));
        moneyField.setHorizontalAlignment(JTextField.LEFT);
        moneyField.setEditable(false);
        moneyField.setText("Money: ");

        moneyDisplayedField.setBounds(110,0,190,50);
        moneyDisplayedField.setBackground(new Color(100,100,100));
        moneyDisplayedField.setForeground(new Color(25,25,25));
        moneyDisplayedField.setFont(new Font(Font.MONOSPACED,Font.BOLD,30));
        moneyDisplayedField.setBorder(BorderFactory.createBevelBorder(1));
        moneyDisplayedField.setHorizontalAlignment(JTextField.LEFT);
        moneyDisplayedField.setEditable(false);
        moneyDisplayedField.setText(money + "$");

        junkyardVisit.setBounds(300,50,600,550);
        junkyardVisit.setBackground(new Color(150,150,150));
        junkyardVisit.setForeground(new Color(25,25,25));
        junkyardVisit.setFont(new Font(Font.MONOSPACED,Font.BOLD,30));
        junkyardVisit.setBorder(BorderFactory.createBevelBorder(1));
        junkyardVisit.setHorizontalAlignment(JTextField.LEFT);
        junkyardVisit.setEditable(false);
        junkyardVisit.setText("Hello there");

        //Game Area

        gameArea.setBounds(300,50,600,550);
        gameArea.setLineWrap(true);
        gameArea.setWrapStyleWord(true);
        gameArea.setBackground(new Color(100,100,100));
        gameArea.setForeground(new Color(25,25,25));
        gameArea.setFont(new Font(Font.MONOSPACED,Font.BOLD,30));
        gameArea.setBorder(BorderFactory.createBevelBorder(1));
        gameArea.setEditable(false);

        // Buttons

        JunkyardBtn.setBounds(0,50,300,125);
        JunkyardBtn.setFont(new Font(Font.MONOSPACED,Font.BOLD,25));
        JunkyardBtn.setFocusable(false);
        JunkyardBtn.addActionListener(this);
        JunkyardBtn.setText("Junkyard");

        ClientsBtn.setBounds(0,175,300,125);
        ClientsBtn.setFont(new Font(Font.MONOSPACED,Font.BOLD,25));
        ClientsBtn.setFocusable(false);
        ClientsBtn.addActionListener(this);
        ClientsBtn.setText("Clients");

        MechanicsBtn.setBounds(0,300,300,125);
        MechanicsBtn.setFont(new Font(Font.MONOSPACED,Font.BOLD,25));
        MechanicsBtn.setFocusable(false);
        MechanicsBtn.addActionListener(this);
        MechanicsBtn.setText("Mechanics");

        AdvertisingBtn.setBounds(0,425,300,125);
        AdvertisingBtn.setFont(new Font(Font.MONOSPACED,Font.BOLD,25));
        AdvertisingBtn.setFocusable(false);
        AdvertisingBtn.addActionListener(this);
        AdvertisingBtn.setText("Advertising");

        daysPassed.setBounds(800,0,100,50);
        daysPassed.setBackground(new Color(100,100,100));
        daysPassed.setForeground(new Color(25,25,25));
        daysPassed.setFont(new Font(Font.MONOSPACED,Font.BOLD,25));
        daysPassed.setBorder(BorderFactory.createBevelBorder(1));
        daysPassed.setOpaque(true);
        daysPassed.setHorizontalAlignment(JTextField.CENTER);
        daysPassed.setText(String.valueOf(day));

        //Adding fields and buttons to the frame

        frame.add(moneyDisplayedField);
        frame.add(AdvertisingBtn);
        frame.add(MechanicsBtn);
        frame.add(ClientsBtn);
        frame.add(JunkyardBtn);

        frame.add(gameArea);
        frame.add(moneyField);
        frame.add(dayField);
        frame.add(daysPassed);
        frame.setVisible(true);
        timer.start();

        //startDay();
    }

    public void startDay() {
        JunkyardBtn.setEnabled(true);
        ClientsBtn.setEnabled(true);
        MechanicsBtn.setEnabled(true);
        AdvertisingBtn.setEnabled(true);
        gameArea.setText("Game setting up");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JunkyardBtn.setEnabled(false);
        ClientsBtn.setEnabled(false);
        MechanicsBtn.setEnabled(false);
        AdvertisingBtn.setEnabled(false);

        if(e.getSource() == JunkyardBtn) {
            addMoney(2.0);
            gameArea.setText("Junkyard is being browsed");
            String input = scanner.nextLine();
            if (input.equals("1")) {
                gameArea.setText("Car chosen");
            }
            makeChoice();
        }
        if (e.getSource() == ClientsBtn) {
            addMoney(2.0);
        }
        if (e.getSource() == MechanicsBtn) {
            addMoney(2.0);
        }
        if (e.getSource() == AdvertisingBtn) {
            addMoney(2.0);
        }
        day += 1;


    }

    public void makeChoice() {




        startDay();
    }


}
