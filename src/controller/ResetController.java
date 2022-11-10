package controller;

import view.BasicStatsView;
import model.BasicStatsModel;


/**
 * The ResetController class is the controller class to rest the view.
 * Implements the logic to reset all the fields to the state after initial launch.
 */
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
