package controller;

import view.BasicStatsView;
import model.BasicStatsModel;

public class ResetController implements Controller{

    BasicStatsView bsView;

    public ResetController(BasicStatsView bsView) {
        this.bsView = bsView;
    }



    @Override
    public void updateModels(BasicStatsModel model) {
        model.reset();
        bsView.update(model);
    }

    @Override
    public void updateModels(BasicStatsModel model, String number) {
    }

}
