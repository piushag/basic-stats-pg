package controller;

import model.BasicStatsModel;
import view.BasicStatsView;

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
