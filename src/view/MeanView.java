package view;

import model.BasicStatsModel;

import javax.swing.*;

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
            double mean = ViewUtils.mean(model.getArrayDouble());
            jtfMean.setText("" + mean);
        }

    }
}