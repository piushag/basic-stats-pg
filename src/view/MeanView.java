package view;

import model.BasicStatsModel;

import javax.swing.*;

/**
 * The MeanView class implements the logic to add and display the mean field, and compute the mean.
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
//            double mean = ViewUtils.mean(model.getArrayDouble());
            double mean = new SimpleStatisticView.MeanStatistic().computeStatistic(model.getArrayDouble());
            jtfMean.setText("" + mean);
        }

    }


    public JTextField getJtfField() {
        return jtfMean;
    }

    public void setJtfMean(JTextField jtfMean) {
        this.jtfMean = jtfMean;
    }
}