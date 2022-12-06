package view;

import model.BasicStatsModel;

import javax.swing.*;


/**
 * The View interface represents a visualization of the BasicStatsModel.
 * This interface supports the MVC architecture pattern.
 */
public interface View
{
    /**
     * Updates this View to visualize the current BasicStatsModel.
     *
     * @param model The current BasicStatsModel to be visualized
     */
    public void update(BasicStatsModel model);

    /**
     * Fetches the Text Field added by the View.
     *
     */
    JTextField getJtfField();
}