package gui;

import controller.AddNumberController;
import controller.ResetController;
import gui.view.*;
import model.BasicStatsModel;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

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

        BasicStatsGUI gui = new BasicStatsGUI();

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

    /**
     * Compute the mean of an array of numbers.
     */
    public static double mean(double ... numbers) {
        double sum = 0;
        for (double num : numbers) {
            sum += num;
        }
        return sum / numbers.length;
    }

    /**
     * Compute the median of an array of numbers.
     */
    public static double median(double ... numbers) {
      Arrays.sort(numbers);

      int size = numbers.length;
      double median = 0.0;

      if (size > 0) {
        if (size % 2 == 0) {
          median = (numbers[size >> 1] + numbers[(size >> 1) - 1])/2;
        }
        else {
          median = numbers[size >> 1];
        }
      }

      return median;
    }

    /**
     * Compute the mode of an array of numbers.
     */
    public static double mode(double ... numbers) {
      double mode = 0.0;
      int modeCount = 0;

      for (double num: numbers) {

        int count = 0;

        for (double otherNum: numbers) {
          if (num == otherNum) {
            count++;
          }
        }

        if (count > modeCount) {
          modeCount = count;
          mode = num;
        }

      }

      return mode;
    }

    /**
     * Compute the maximum of an array of numbers.
     */
    public static double max(double ... numbers) {
        Arrays.sort(numbers);
        int size = numbers.length;
        return numbers[size-1];
    }
}
