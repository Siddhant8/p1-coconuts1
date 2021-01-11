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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.lang.Math;
import java.util.Random;

public class PracticeUI {

    JTextField numPeople = new JTextField(5);
    JButton printPeople = new JButton("Click for population");

    JTextField numMaskers = new JTextField(5);
    JButton printMaskers = new JButton("Click for maskers");

    JTextField numInitCases = new JTextField(5);
    JButton printInitCases  = new JButton("Click for init cases");

    JTextField numDays = new JTextField(5);
    JButton printDays = new JButton("Click for day number");



    public PracticeUI(PracticeControl practiceControl){
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


        content.add(numPeople);

        content.add(printPeople);

        content.add(numMaskers);
        content.add(printMaskers);
        content.add(numInitCases);
        content.add(printInitCases);

        content.add(numDays);
        content.add(printDays);


        printPeople.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e){

            }

            public void mouseReleased(MouseEvent e){
                practiceControl.setNumPeople(numPeople);
                System.out.println(Integer.parseInt(numPeople.getText()));
            }




        });

        printMaskers.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e){

            }

            public void mouseReleased(MouseEvent e){
                practiceControl.setNumPeople(numMaskers);
                System.out.println(Integer.parseInt(numMaskers.getText()));
            }


        });


        printInitCases.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e){

            }

            public void mouseReleased(MouseEvent e){
                practiceControl.setNumPeople(numInitCases);
                System.out.println(Integer.parseInt(numInitCases.getText()));
            }


        });

        printDays.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e){

            }

            public void mouseReleased(MouseEvent e){
                practiceControl.setNumPeople(numDays);
                System.out.println(Integer.parseInt(numDays.getText()));
            }




        });



        covidTracker.setVisible(true);
    }







    public void setVisible(boolean b) {
    }
}
