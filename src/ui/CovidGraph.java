package ui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Scanner;

import java.lang.Math;
import java.util.Random;

public class CovidGraph extends JFrame{
    //initializes the variables in my calculations
    public int numberOfPeople = 0;
    public int maskWearers = 0;
    public int numberOfCases = 0;
    public int numberOfDays = 0;
    public double newCases = 0;
    public String state = "";

    public int population = 0;
    public int maskers = 0;
    public int casesAlready = 0;
    public int dayToday = 0;

    public int min1 = 25;
    public int max1= 70;
    public int min2 = 0;
    public int max2 = 25;
    public int min3 = 0;
    public int max3 = 25;
    public int min4 = 1;
    public int max4 = 10;

    //creates ArrayList of data values

    public ArrayList<Integer> dataSet = new ArrayList<Integer>();

    //initializes the statics for the UI frame
    public static JTextField inputPeople = new JTextField(5);
    public static JTextField inputMasks = new JTextField(5);
    public static JTextField inputCases = new JTextField(5);
    public static JTextField inputDays = new JTextField(5);
    public static JButton calculate = null;
    public static JLabel labelDayNumber = new JLabel();
    public static JLabel caseNumbers = new JLabel();
    public static JLabel status = new JLabel();
    public static JLabel enterPopulation = new JLabel("Enter Number of People Total:");
    public static JLabel enterMaskWearers = new JLabel("Enter Number of People Wearing Masks:");
    public static JLabel enterCasesSoFar = new JLabel("Enter the Initial Number of Cases:");
    public static JLabel enterDayNumber = new JLabel("Enter the day number:");
    public static JLabel createPeople = new JLabel();
    public static JLabel createMaskers = new JLabel();
    public static JLabel createCases = new JLabel();
    public static JLabel createDays = new JLabel();

    public static Container frameContainer;


    public void generatePeople(){
        Random random = new Random();
        population = random.nextInt(max1 - min1) + min1;
        String stringPopulation = String.valueOf(population);
        createPeople.setText("Number of people to enter:" + stringPopulation);
    }

    public void generateMaskWearers(){
        Random random1 = new Random();
        maskers = random1.nextInt(max2-min2) + min2;
        String stringMaskers = String.valueOf(maskers);
        createMaskers.setText("Number of maskwearers to enter:" + stringMaskers);
    }

    public void generateCases(){
        Random random2 = new Random();
        casesAlready = random2.nextInt(max3 - min3) + min3;
        String stringCasesAlready = String.valueOf(casesAlready);
        createCases.setText("Number of present cases to enter:" + stringCasesAlready);
    }

    public void generateDay(){
        Random random3 = new Random();
        dayToday = random3.nextInt(max4 - min4) + min4;
        String stringDayToday = String.valueOf(dayToday);
        createDays.setText("The day number customer needs to enter:" + stringDayToday);
    }

    //Method to take an input of the number of people in the simulation
    public void addPeople(){
        numberOfPeople = Integer.parseInt(inputPeople.getText());
        System.out.println(numberOfPeople);
    }
    //method to take an input of the number of people wearing masks in the simulation
    public void addMaskWearers(){
        maskWearers = Integer.parseInt(inputMasks.getText());
        System.out.println(maskWearers);
    }
    //takes an input of the number of current cases
    public void addCases(){

        numberOfCases = Integer.parseInt(inputCases.getText());
        System.out.println(numberOfCases);
    }
    //finds out what day it is
    public void addDays(){
        numberOfDays = Integer.parseInt(inputDays.getText());
        labelDayNumber.setText("Day:" + String.valueOf(numberOfDays));
        System.out.println(numberOfDays);
    }

    //Calculates the number of cases based off the calculus logistic growth equation
    //Uses the variable inputs
    public void calculateTotal() {

        {
            addPeople();
            addMaskWearers();
            addCases();
            addDays();
        }

        double doubleMaskWearers = maskWearers;
        System.out.println(doubleMaskWearers);
        double calculationProportion = doubleMaskWearers / numberOfPeople;
        System.out.println(calculationProportion);
        System.out.println(numberOfDays);
        double doubleNumberOfDays = (double) numberOfDays;
        System.out.println(doubleNumberOfDays);
        double exponent = calculationProportion * doubleNumberOfDays;
        System.out.println(exponent);
        double rate = Math.pow(2.72, exponent);
        System.out.println(rate);
        newCases = rate * numberOfCases;
        int casesToday = (int)newCases;
        System.out.println(newCases);
        System.out.println(casesToday);
        caseNumbers.setText("Number of Cases:" + String.valueOf(casesToday));
        if(numberOfCases > 10.0){
            state = "outdoor dining only";
            status.setText(state);
        }else{
            state = "indoor dining OK";
            status.setText(state);
        }
        dataSet.add(casesToday);
        System.out.println(dataSet);
    }

    void handleEnterKeyPressForInputPeople() {
        inputPeople.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    addPeople();
                    //inputPeople.setText("");
                }
            }

        });
    }

    void handleEnterKeyPressForInputMasks() {
        inputMasks.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    addMaskWearers();
                    //inputMasks.setText("");
                }
            }

        });
    }

    void handleEnterKeyPressForInputCases() {
        inputCases.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    addCases();
                    //inputCases.setText("");
                }
            }

        });
    }


    void handleEnterKeyPressForInputDays() {
        inputDays.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    addDays();
                    //inputDays.setText("");
                }
            }

        });
    }


    void initiateCalculate() {
        calculate = new JButton("Calculate");
        calculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                calculateTotal();

            }
        });
    }



    //constructor
    public CovidGraph(){
        //creates the Frame for the UI
        JFrame covidTracker = new JFrame("Simulate an exponential Covid-Case Growth calculator");
        covidTracker.setBounds(100, 100, 418, 315);
        covidTracker.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FlowLayout flow = new FlowLayout(); // Create a layout manager
        flow.setHgap(10);                   // Set the horizontal gap
        flow.setVgap(10);
        flow.setAlignment(FlowLayout.CENTER);
        Container content = covidTracker.getContentPane(); // Get the content pane
        content.setLayout(new GridLayout(2,2,10,10));

        content.setLayout(flow); // Set the container layout mgr

        generatePeople();
        generateMaskWearers();
        generateCases();
        generateDay();

        content.add(createPeople);
        content.add(createMaskers);
        content.add(createCases);
        content.add(createDays);

        content.add(enterPopulation);

        content.add(inputPeople);
        handleEnterKeyPressForInputPeople();


        content.add(enterMaskWearers);
        content.add(inputMasks);
        handleEnterKeyPressForInputMasks();

        content.add(enterCasesSoFar);
        content.add(inputCases);
        handleEnterKeyPressForInputCases();

        content.add(enterDayNumber);
        content.add(inputDays);
        handleEnterKeyPressForInputDays();

        initiateCalculate();
        content.add(calculate);


        content.add(labelDayNumber);


        content.add(caseNumbers);

        content.add(status);

        covidTracker.setVisible(true);
    }


    //running code
    public static void main(String[] args) {
        //creates new object and calls all of the methods I created
        //CovidGraph frame = new CovidGraph();

        ui.CovidGraph object = new ui.CovidGraph();


        //object.calculateTotal();

        //final calculation is decimal
    }

}


