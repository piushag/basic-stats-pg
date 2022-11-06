package gui.view;

import gui.BasicStats;
import model.BasicStatsModel;
import java.util.*;
import javax.swing.*;

//import java.awt.*;
//import java.awt.event.*;

/**
 Implements all the logic for adding the mean
 */
public class MeanView implements View
{
    private JTextField jtfMean;

    public MeanView(JPanel jpStats) {
        jtfMean = new JTextField(5);
        jtfMean.setEditable(false);
        jpStats.add(new JLabel("Mean:"));
        jpStats.add(jtfMean);
    }

    public void update(BasicStatsModel model){
        if (model.getArrayDouble().length == 0) {
            jtfMean.setText("");
        }else {
            // Compute and set the mean
            double mean = BasicStats.mean(model.getArrayDouble());
            jtfMean.setText("" + mean);
        }

    }
}