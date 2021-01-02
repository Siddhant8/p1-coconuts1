package ui;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.*;


public class MainMenu extends JFrame{

    public MainMenu(){

        //Creates the main Frame
        JFrame menu = new JFrame("Home");

        menu.setBounds(100, 100, 418, 315);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu.setBackground(Color.red);
        JButton covidButton = new JButton("Covid Calculator");

        //Adds actionListeners to the buttons
        covidButton.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e){
                CovidGraph graph = new CovidGraph();

            }
            public void mouseReleased(MouseEvent e){
            }
        });
        JButton jukeBox = new JButton("JukeBox");
        jukeBox.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                JukeBoxUI musicArea = new JukeBoxUI();
                //Add a feature that senses if a window has already been opened so that you don't open multiple
            }

            public void mouseReleased(MouseEvent e) {

            }
        });
        JButton teaShop = new JButton("Shopping");
        teaShop.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                TeaShop musicArea = new TeaShop();
                //Add a feature that senses if a window has already been opened so that you don't open multiple
            }

            public void mouseReleased(MouseEvent e) {

            }
        });

        JLabel greeting = new JLabel("Welcome to Coconuts Tea Shop");

        //creates the layout of the UI
        FlowLayout flow = new FlowLayout(); // Create a layout manager
        flow.setHgap(10);                   // Set the horizontal gap
        flow.setVgap(10);
        flow.setAlignment(FlowLayout.CENTER);
        Container content = menu.getContentPane(); // Get the content pane
        content.setLayout(new GridLayout(2,2,10,10));

        content.setLayout(flow); // Set the container layout mgr

        //adds the buttons to the UI
        content.add(jukeBox);

        content.add(teaShop);

        content.add(covidButton);

        content.add(greeting);

        menu.setVisible(true);


    }

    public static void main(String args[]){
        MainMenu frame = new MainMenu();
    }

}
