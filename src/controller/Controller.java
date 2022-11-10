package controller;

import model.BasicStatsModel;


/**
 * The Controller interface represents a controller of the BasicStatsModel.
 * This interface supports the MVC architecture pattern.
 */
public interface Controller {

    /**
     * Updates the BasicStatsModel to the current state after an action.
     *
     * @param model The current BasicStatsModel to be updated.
     */
    public void updateModels(BasicStatsModel model);


    /**
     * Updates the BasicStatsModel to the current state after an action - add number.
     *
     * @param model The current BasicStatsModel to be updated with the new number
     * @param number The current number being added
     *              .
     */
    void updateModels(BasicStatsModel model, String number);

}
