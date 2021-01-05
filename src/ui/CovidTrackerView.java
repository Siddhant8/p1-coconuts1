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

    }
}
