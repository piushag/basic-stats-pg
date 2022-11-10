package view;

import java.util.*;
import javax.swing.*;

import java.util.List;

import model.BasicStatsModel;



/**
 * The BasicStatsView class is the Composite class of View.
 * implements the logic to add the views and update them.
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


    /**
     * Add a view to the list of views.
     * @param view
     */
    public void addView(View view) {
        childViews.add(view);
    }

    /**
     * Remove a view from the list of views.
     * @param view
     */
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
