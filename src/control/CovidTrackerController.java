package control;

import model.CovidTrackerModel;
import ui.CovidTrackerView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CovidTrackerController {
    private CovidTrackerView view;
    private CovidTrackerModel model;

    public CovidTrackerController(CovidTrackerView view, CovidTrackerModel model){
        this.view = view;
        this.model = model;
        //this.view.addCalculateListener(new CalculateListener());
    }


    public void setNumberOfMaskWearers(JTextField inpPeople){
        model.people(Integer.parseInt(inpPeople.getText()));
    }
}

class CalculateListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
