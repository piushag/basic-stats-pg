package controller;

import view.BasicStatsView;
import model.BasicStatsModel;

public class ResetController implements Controller{

    BasicStatsView view;

    public ResetController(BasicStatsView gui) {
        this.view = gui;
    }



    @Override
    public void updateModels(BasicStatsModel model) {
        model.reset();
        view.update(model);
    }

    @Override
    public void updateModels(BasicStatsModel model, String number) {
    }

}
