package controller;

import model.BasicStatsModel;
import view.BasicStatsView;


/**
 * The UndoController class is the controller class to undo the last added number.
 * Calls the method to undo last added number, or reset all fields if only one number is present and undo is clicked.
 */
public class UndoController implements Controller{

    BasicStatsView bsView;

    public UndoController(BasicStatsView bsView) {
        this.bsView = bsView;
    }


    @Override
    public void updateModels(BasicStatsModel model) {
        model.undo();
        bsView.update(model);

    }

    @Override
    public void updateModels(BasicStatsModel model, String number) {

    }
}
