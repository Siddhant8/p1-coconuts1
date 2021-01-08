package ui;

import javax.swing.*;
import java.io.IOException;

public class JukeBoxControl {

    JukeBoxModel model;
    JukeBoxUI view;


    public JukeBoxControl() throws IOException {

        this.model = new JukeBoxModel();
        this.view = new JukeBoxUI(this);
        view.setVisible(true);


    }

    public void setUrl(JTextField textfield) throws IOException {

        model.setUrl(textfield.getText());
        //IMPORTANT NOTE: use the name of the object and NOT the name of the class in the method! EZ error to make!
    }
}
