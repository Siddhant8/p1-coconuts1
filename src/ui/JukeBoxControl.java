package ui;

import javax.swing.*;
import java.io.IOException;

public class JukeBoxControl {

    JukeBoxModel model;
    JukeBoxUI view;


    public JukeBoxControl() throws IOException {

        this.model = new JukeBoxModel();
        this.view = new JukeBoxUI(this); //standard MVC style
        view.setVisible(true);


    }

    public void setUrl(JTextField textfield) throws IOException {

        model.setUrl(textfield.getText());
        //IMPORTANT NOTE: use the name of the object and NOT the name of the class in the method! EZ error to make!
    }

    public String getCassette(int i) throws IOException { //NOTE: need to pass in an integer so that method call goes through the arrayList multiple times

        //Remember, i is an iterator. This means I'm going to use this to iterate through a list!
        model.arrangeUrls();
        return model.collectUrls.get(i);
        /**Need to return a string BECAUSE we will make a list of cassettes initialized with that string!*/

    }

    public int getCassetteLength() throws IOException {
        model.arrangeUrls(); //need to preset array to eliminate previous instances (don't want duplicate URLs)
        return model.collectUrls.size(); //return size so that the loop in UI loops number of times = the number of URLs
    }
}
