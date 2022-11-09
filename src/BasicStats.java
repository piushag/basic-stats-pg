import controller.AddNumberController;
import controller.ResetController;
import gui.BasicStatsView;
import gui.view.*;
import model.BasicStatsModel;

import javax.swing.*;
import java.awt.*;
import java.util.*;

/**
 * A simple class to compute basic, descriptive statistics.
 */
public class BasicStats {

    public static final String APP_TITLE = "Simple stats";

    public static void main(String ... args) {

        System.out.println("Let's do some basic statistics...");

        BasicStatsModel model = new BasicStatsModel();

        JFrame jfMain = new JFrame(APP_TITLE);

        // Create the main frame of the application, and set size and position
        jfMain.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        jfMain.setSize(600, 400);
        jfMain.setLocationRelativeTo(null);

        // Panel that shows stats about the numbers

        JPanel jpStats = new JPanel(new FlowLayout(FlowLayout.CENTER));

        BasicStatsView gui = new BasicStatsView();

        //new stuff
        CountView countView = new CountView(jpStats);
        MedianView medianView = new MedianView(jpStats);
        MeanView meanView = new MeanView(jpStats);
        MaxView maxView = new MaxView(jpStats);
        NumbersView numbersView = new NumbersView(jfMain);
        AddNumberView addNumberView = new AddNumberView(model);
        ResetView resetView = new ResetView(model);


        ResetController reset = new ResetController(gui);
        resetView.addController(reset);

        AddNumberController add = new AddNumberController(gui);
        addNumberView.addController(add);



        gui.addView(countView);
        gui.addView(medianView);
        gui.addView(meanView);
        gui.addView(maxView);
        gui.addView(numbersView);
        gui.addView(addNumberView);
        gui.addView(resetView);



        jfMain.getContentPane().add(jpStats, BorderLayout.CENTER);


        JPanel jpInput = new JPanel(new FlowLayout(FlowLayout.CENTER));
        jpInput.add(addNumberView.show());
        jpInput.add(addNumberView.getButton());
        jpInput.add(resetView.getButton());

        jfMain.getContentPane().add(jpInput, BorderLayout.NORTH);

        jfMain.setVisible(true);

    }
}
