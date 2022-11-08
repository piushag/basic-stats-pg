package gui;

import java.util.*;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.List;

import model.BasicStatsModel;
//import gui.view.View;
import gui.view.*;


/**
 * Create a simple GUI that includes:
 * - a text field and a button that allows the user to enter numbers.
 * - a button that allows the user to clear all entered numbers.
 * - a panel with labels and text fields for count, median, and mean.
 * - a text area that shows all numbers.
 * <p>
 * For the MVC architecture pattern, these are the views and controllers.
 */
public class BasicStatsGUI implements View {
    public static final String APP_TITLE = "Simple stats";

    private static BasicStatsModel model = new BasicStatsModel();

    private JFrame jfMain = new JFrame(APP_TITLE);

    private List<View> childViews;

    public BasicStatsGUI() {

    }

    public void update(BasicStatsModel model) {
        for (View view : childViews) {
            view.update(model);
        }
    }

    public void show() {
        // Show the frame
        jfMain.setVisible(true);
    }

    public void setViews(List<View> views){
        this.childViews = views;
    }

}
