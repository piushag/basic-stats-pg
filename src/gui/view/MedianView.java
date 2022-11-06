package gui.view;

import gui.BasicStats;
import model.BasicStatsModel;
import java.util.*;
import javax.swing.*;

//import java.awt.*;
//import java.awt.event.*;

/**
 Implements all the logic for adding the median
 */
public class MedianView implements View
{
    private JTextField jtfMedian;

    public MedianView(JPanel jpStats) {
        jtfMedian = new JTextField(5);
        jtfMedian.setEditable(false);
        jpStats.add(new JLabel("Median:"));
        jpStats.add(jtfMedian);
    }

    public void update(BasicStatsModel model){
        if (model.getArrayDouble().length == 0) {
            jtfMedian.setText("");
        }else {
            // Compute and set the median
            double median = BasicStats.median(model.getArrayDouble());
            jtfMedian.setText("" + median);
        }

    }
}