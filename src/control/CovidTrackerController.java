package control;

import model.CovidTrackerModel;
import ui.CovidTrackerView;

public class CovidTrackerController {
    private CovidTrackerView view;
    private CovidTrackerModel model;

    public CovidTrackerController(CovidTrackerView view, CovidTrackerModel model){
        this.view = view;
        this.model = model;
    }
}
