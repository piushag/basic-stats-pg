package controller;

import gui.BasicStatsView;
import model.BasicStatsModel;

public class ResetController implements Controller{

    BasicStatsView gui;

    public ResetController(BasicStatsView gui) {
        this.gui = gui;
    }



    @Override
    public void updateModels(BasicStatsModel model) {
        model.reset();
        gui.update(model);
    }

    @Override
    public void updateModelsWithNums(BasicStatsModel model, String text) {

    }
}
