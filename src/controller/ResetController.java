package controller;

import gui.BasicStatsGUI;
import gui.view.View;
import model.BasicStatsModel;

import java.util.ArrayList;

public class ResetController implements Controller{

    BasicStatsGUI gui;

    public ResetController(BasicStatsGUI gui) {
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
