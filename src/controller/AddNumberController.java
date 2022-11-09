package controller;

import view.BasicStatsView;
import model.BasicStatsModel;

import javax.swing.*;

public class AddNumberController implements Controller {

    private BasicStatsView gui;


    public AddNumberController(BasicStatsView gui) {
        this.gui = gui;
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
            String message = "Not a valid number";
            JOptionPane.showMessageDialog(new JFrame(), message, "Error",
                    JOptionPane.ERROR_MESSAGE);
            throw new RuntimeException(ex);
        }
        gui.update(model);

    }
}
