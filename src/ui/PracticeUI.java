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

import java.io.File;
import java.io.IOException;

public class PracticeUI {

    //sets my UI components
    JTextField numPeople = new JTextField(5);
    JButton printPeople = new JButton("Click for population");

    JTextField numMaskers = new JTextField(5);
    JButton printMaskers = new JButton("Click for maskers");

    JTextField numInitCases = new JTextField(5);
    JButton printInitCases  = new JButton("Click for init cases");

    JTextField numDays = new JTextField(5);
    JButton printDays = new JButton("Click for day number");

    JLabel numCasesToday = new JLabel();

    JButton calculate = new JButton("Calcuate the number of Cases");

    //constructor that creates and adds UI components
    public PracticeUI(PracticeControl practiceControl) throws IOException{
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

        content.add(calculate);

        content.add(numCasesToday);


        //adds mouse listeners for inputs
        printPeople.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e){

            }

            public void mouseReleased(MouseEvent e){
                practiceControl.setNumPeople(numPeople);

            }


        });

        printMaskers.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e){

            }

            public void mouseReleased(MouseEvent e){
                practiceControl.setNumInitCases(numMaskers);

            }


        });


        printInitCases.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e){

            }

            public void mouseReleased(MouseEvent e){
                practiceControl.setNumInitCases(numInitCases);

            }


        });

        printDays.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e){

            }

            public void mouseReleased(MouseEvent e){
                practiceControl.setNumDays(numDays);

            }

        });

        //adds mouseListeners to calculate cases
        calculate.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e){

            }

            public void mouseReleased(MouseEvent e){
                try{

                    practiceControl.setCasesToday(calculate);
                    //practiceControl.setNumCase(numCasesToday);

                }catch(IOException ioException) {
                    ioException.printStackTrace();
                }


            }

        });




        covidTracker.setVisible(true);
    }







    public void setVisible(boolean b) {
    }
}
