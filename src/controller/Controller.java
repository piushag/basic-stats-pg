package controller;

import model.BasicStatsModel;

public interface Controller {

    public void updateModels(BasicStatsModel model);


    void updateModels(BasicStatsModel model, String number);

}
