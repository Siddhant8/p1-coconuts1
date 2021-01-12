package ui;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.lang.Math;

import java.io.IOException;
import java.io.File;

public class PracticeControl {
    PracticeModel model;
    PracticeUI view;

    public PracticeControl() throws IOException{
        this.model = new PracticeModel();
        this.view = new PracticeUI(this);
        view.setVisible(true);
    }


    public void setNumPeople(JTextField textfield){
        model.setNumPeople(Integer.parseInt(textfield.getText()));
    }

    public void setNumMaskers(JTextField textfield){model.setNumMaskers(Integer.parseInt(textfield.getText()));}

    public void setNumInitCases(JTextField textfield){model.setNumInitCases(Integer.parseInt(textfield.getText()));}

    public void setNumDays(JTextField textfield){model.setNumDays(Integer.parseInt(textfield.getText()));}

    public void setCasesToday(JButton button){model.setCasesToday();}

    public void setNumCase(JLabel label){model.setNumCase();}


}
