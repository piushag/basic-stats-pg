package controller;

import view.BasicStatsView;
import model.BasicStatsModel;

import javax.swing.*;

/**
 * The AddNumberController class is the controller class to add a number.
 * Implements the logic to update the model and views.
 */
public class AddNumberController implements Controller {

    private BasicStatsView bsView;


    public AddNumberController(BasicStatsView bsView) {
        this.bsView = bsView;
    }


    @Override
    public void updateModels(BasicStatsModel model) {

    }

    @Override
    public void updateModels(BasicStatsModel model, String number) {

        Double num = null;
        try {
            num = Double.parseDouble(number);
            model.addNumber(num);
        } catch (NumberFormatException ex) {
//            String message = "Not a valid number";
//            JOptionPane.showMessageDialog(new JFrame(), message, "Error",
//                    JOptionPane.ERROR_MESSAGE);
            throw new RuntimeException(ex);
        }
        bsView.update(model);

    }
}
