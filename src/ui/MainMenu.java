package ui;



import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;


public class MainMenu extends JFrame{

    public MainMenu(){

        //Creates the main Frame
        JFrame menu = new JFrame("Home");

        menu.setBounds(100, 100, 418, 315);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu.setBackground(Color.red);

        JLabel label = new JLabel(" Remember to Social Distance for the pandemic");

        JButton jukeBox = new JButton("JukeBox");
        jukeBox.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {

                try {
                    JukeBoxControl musicArea = new JukeBoxControl();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                //Add a feature that senses if a window has already been opened so that you don't open multiple
            }

            public void mouseReleased(MouseEvent e) {

            }
        });

        JButton calculator = new JButton("Coronavirus Calculator");
        calculator.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {

                try {
                    PracticeControl control = new PracticeControl();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
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

        content.add(calculator);

        content.add(greeting);

        content.add(label);


        menu.setVisible(true);


    }

    public static void main(String args[]){
        MainMenu frame = new MainMenu();
    }

}
