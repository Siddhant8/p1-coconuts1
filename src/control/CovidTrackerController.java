package control;

import model.CovidTrackerModel;
import ui.CovidTrackerView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class CovidTrackerController {
    public CovidTrackerView view;
    public CovidTrackerModel model;

    public CovidTrackerController(){
        this.view = view;
        this.model = model;
        //this.view.addCalculateListener(new CalculateListener());
    }


    public void setNumberOfMaskWearers(JTextField inpPeople){
        model.people(Integer.parseInt(inpPeople.getText()));
    }
}

class CalculateListener extends CovidTrackerController implements ActionListener {

    public CalculateListener(CovidTrackerView view, CovidTrackerModel model) {
        super();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int numberOfPeople = 0;
        int maskWearers = 0;
        int nonMaskWearers = 0;
        int numberOfCases = 0;
        int numberOfDays = 0;
        double newCases = 0;
        int casesToday;
        String state = "";

        try{
            numberOfPeople = view.getInputPeople();
            maskWearers = view.getInputMasks();
            numberOfCases = view.getInputCases();
            numberOfDays = view.getInputDays();
            nonMaskWearers = numberOfPeople - maskWearers;
            model.calculateTotal();

        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }
}
