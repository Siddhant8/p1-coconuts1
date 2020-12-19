package com.company;

import javax.swing.*;
import java.awt.*;

public class TeaShop{
    public TeaShop(){
        JFrame menu = new JFrame("Home");

        menu.setBounds(100, 100, 418, 315);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel greeting = new JLabel("What tea Would You Like To Purchase?");


        FlowLayout flow = new FlowLayout(); // Create a layout manager
        flow.setHgap(10);                   // Set the horizontal gap
        flow.setVgap(10);
        flow.setAlignment(FlowLayout.CENTER);
        Container content = menu.getContentPane(); // Get the content pane
        content.setLayout(new GridLayout(2,2,10,10));

        content.setLayout(flow); // Set the container layout mgr


        content.add(greeting);

        menu.setVisible(true);
    }
    public static void main(String args[]){
        TeaShop frame = new TeaShop();
    }
}

