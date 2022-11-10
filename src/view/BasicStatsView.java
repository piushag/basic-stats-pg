package view;

import java.util.*;
import javax.swing.*;

import java.util.List;

import model.BasicStatsModel;

import view.*;


/**
 * Create a simple GUI that includes:
 * - a text field and a button that allows the user to enter numbers.
 * - a button that allows the user to clear all entered numbers.
 * - a panel with labels and text fields for count, median, and mean.
 * - a text area that shows all numbers.
 * <p>
 * For the MVC architecture pattern, these are the views and controllers.
 */
public class BasicStatsView implements View {
    public static final String APP_TITLE = "Simple stats";

    private static BasicStatsModel model = new BasicStatsModel();

    private JFrame jfMain = new JFrame(APP_TITLE);


    private List<View> childViews = new ArrayList<>();

    public BasicStatsView() {

    }

    public void update(BasicStatsModel model) {
        for (View view : childViews) {
            view.update(model);
        }
    }

    @Override
    public JTextField getJtfField() {
        return null;
    }


    public void addView(View view) {
        childViews.add(view);
    }

    public void removeView(View view) {
        childViews.remove(view);
    }

    public List<View> getChildViews() {
        return childViews;
    }

    public void setChildViews(List<View> childViews) {
        this.childViews = childViews;
    }

}
