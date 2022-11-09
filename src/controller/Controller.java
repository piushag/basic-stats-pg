package controller;

import gui.view.View;
import model.BasicStatsModel;

public interface Controller {

    public void updateModels(BasicStatsModel model);


    public void updateModelsWithNums(BasicStatsModel model, String text);
}
