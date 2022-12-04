import controller.AddNumberController;
import controller.ResetController;
import controller.UndoController;
import view.*;

import model.BasicStatsModel;

import javax.swing.*;
import java.awt.*;

/**
 * Creates a simple GUI that includes:
 * - a text field and a button that allows the user to enter numbers.
 * - a button that allows the user to clear all entered numbers.
 * - a panel with labels and text fields for count, median, mean, and max.
 * - a text area that shows all numbers.
 */
public class BasicStats {

    public static final String APP_TITLE = "Simple stats";
    private static BasicStatsModel model;

    private static JFrame jfMain ;

    private static JPanel jpStats;

    private static JPanel jpInput;


    private static BasicStatsView bsView;



    public static void main(String ... args) {

        model = new BasicStatsModel();

        jfMain = new JFrame(APP_TITLE);

        // Create the main frame of the application, and set size and position
        jfMain.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        jfMain.setSize(600, 400);
        jfMain.setLocationRelativeTo(null);

        // Panel that shows stats about the numbers

        jpStats = new JPanel(new FlowLayout(FlowLayout.CENTER));

        bsView = new BasicStatsView();

        //Adding the views
        CountView countView = new CountView(jpStats);
        MedianView medianView = new MedianView(jpStats);
        MeanView meanView = new MeanView(jpStats);
        MaxView maxView = new MaxView(jpStats);
        NumbersView numbersView = new NumbersView(jfMain);
        AddNumberView addNumberView = new AddNumberView(model);
        ResetView resetView = new ResetView(model);
        UndoView undoView = new UndoView(model);

        ResetController reset = new ResetController(bsView);
        resetView.addController(reset);

        AddNumberController add = new AddNumberController(bsView);
        addNumberView.addController(add);

        UndoController undo = new UndoController(bsView);
        undoView.addController(undo);

        bsView.addView(countView);
        bsView.addView(medianView);
        bsView.addView(meanView);
        bsView.addView(maxView);
        bsView.addView(numbersView);
        bsView.addView(addNumberView);
        bsView.addView(resetView);
        bsView.addView(undoView);

        jfMain.getContentPane().add(jpStats, BorderLayout.CENTER);

        // Panel with a text field/button to enter numbers and a button to reset the application
        jpInput = new JPanel(new FlowLayout(FlowLayout.CENTER));
        jpInput.add(addNumberView.show());
        jpInput.add(addNumberView.getButton());
        jpInput.add(resetView.getButton());
        jpInput.add(undoView.getButton());

        jfMain.getContentPane().add(jpInput, BorderLayout.NORTH);

        jfMain.setVisible(true);

    }

    public static BasicStatsModel getModel() {
        return model;
    }

    public static void setModel(BasicStatsModel model) {
        BasicStats.model = model;
    }

    public static JFrame getJfMain() {
        return jfMain;
    }

    public static void setJfMain(JFrame jfMain) {
        BasicStats.jfMain = jfMain;
    }

    public static JPanel getJpStats() {
        return jpStats;
    }

    public static void setJpStats(JPanel jpStats) {
        BasicStats.jpStats = jpStats;
    }

    public static JPanel getJpInput() {
        return jpInput;
    }

    public static void setJpInput(JPanel jpInput) {
        BasicStats.jpInput = jpInput;
    }

    public static BasicStatsView getBsView() {
        return bsView;
    }

    public static void setBsView(BasicStatsView bsView) {
        BasicStats.bsView = bsView;
    }
}
