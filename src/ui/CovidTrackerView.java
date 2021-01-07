package ui;

import javax.swing.*;
import java.awt.*;

public class CovidTrackerView {

    private static JTextField inputPeople = new JTextField(5);
    private static JTextField inputMasks = new JTextField(5);
    private static JTextField inputCases = new JTextField(5);
    private static JTextField inputDays = new JTextField(5);
    private static JButton calculate = null;
    private static JLabel labelDayNumber = new JLabel();
    private static JLabel caseNumbers = new JLabel();
    private static JLabel status = new JLabel();
    private static JLabel enterPopulation = new JLabel("Enter Number of People Total:");
    private static JLabel enterMaskWearers = new JLabel("Enter Number of People Wearing Masks:");
    private static JLabel enterCasesSoFar = new JLabel("Enter the Initial Number of Cases:");
    private static JLabel enterDayNumber = new JLabel("Enter the day number:");
    private static JLabel createPeople = new JLabel();
    private static JLabel createMaskers = new JLabel();
    private static JLabel createCases = new JLabel();
    private static JLabel createDays = new JLabel();

    private static Container frameContainer;

    public CovidTrackerView(){
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

        content.add(createPeople);
        content.add(createMaskers);
        content.add(createCases);
        content.add(createDays);

        content.add(enterPopulation);

        content.add(inputPeople);



        content.add(enterMaskWearers);
        content.add(inputMasks);


        content.add(enterCasesSoFar);
        content.add(inputCases);


        content.add(enterDayNumber);
        content.add(inputDays);


        
        content.add(calculate);


        content.add(labelDayNumber);


        content.add(caseNumbers);

        content.add(status);

        covidTracker.setVisible(true);
    }

}
