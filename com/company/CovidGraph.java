package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.lang.Math;

public class CovidGraph extends JFrame{
    //initializes the variables in my calculations
    public int numberOfPeople = 0;
    public int maskWearers = 0;
    public int numberOfCases = 0;
    public int antiMaskers = 0;
    public int numberOfDays = 0;


    //initializes the statics for the UI frame
    public static JButton deckButton = null;
    public static JTextField playerCardNumbers = new JTextField(20);

    public static JButton inputPeople = null;
    public static JTextField inputMaskCases = new JTextField(20);
    public static JLabel caseNumbers = new JLabel();

    public static Container frameContainer;

    //Method to take an input of the number of people in the simulation
    public void addPeople(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Number of people:");
        numberOfPeople = scan.nextInt();
        System.out.println(numberOfPeople);
    }
    //method to take an input of the number of people wearing masks in the simulation
    public void addMaskWearers(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Number of mask wearers:");
        maskWearers = scan.nextInt();
        System.out.println(maskWearers);
    }
    //takes an input of the number of current cases
    public void addCases(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Number of cases:");
        numberOfCases = scan.nextInt();
        System.out.println(numberOfCases);
    }
    //finds out what day it is
    public void addDays(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Day number:");
        numberOfDays = scan.nextInt();
        System.out.println(numberOfDays);
    }

    //Calculates the number of cases based off the calculus logistic growth equation
    //Uses the variable inputs
    public void calculateTotal(){
        double typeConvert = maskWearers;
        System.out.println(typeConvert);
        double k = typeConvert/numberOfPeople;
        System.out.println(k);
        System.out.println(numberOfDays);
        double z = (double) numberOfDays;
        System.out.println(z);
        double t = k * z;
        System.out.println(t);
        double c = Math.pow(2.72, t);
        System.out.println(c);
        double newCases = c * numberOfCases;
        System.out.println(newCases);
    }

    //constructor
    public CovidGraph(){
        //creates the Frame for the UI
        JFrame covidTracker = new JFrame("Covid Tracker");
        covidTracker.setBounds(100, 100, 418, 315);
        covidTracker.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FlowLayout flow = new FlowLayout(); // Create a layout manager
        flow.setHgap(10);                   // Set the horizontal gap
        flow.setVgap(10);
        flow.setAlignment(FlowLayout.CENTER);
        Container content = covidTracker.getContentPane(); // Get the content pane
        content.setLayout(new GridLayout(2,2,10,10));

        content.setLayout(flow); // Set the container layout mgr


        covidTracker.setVisible(true);
    }

    //running code
    public static void main(String args[]) {
        //creates new object and calls all of the methods I created
        CovidGraph frame = new CovidGraph();

        CovidGraph object = new CovidGraph();

        object.addPeople();
        object.addMaskWearers();
        object.addCases();
        object.addDays();
        object.calculateTotal();
        //final calculation is decimal, I left it like that to make sure equation worked
    }

}
