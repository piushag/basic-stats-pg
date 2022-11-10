package view;

import model.BasicStatsModel;

import javax.swing.*;


/**
 * The MedianView class implements the logic to add and display the median field, and compute the median.
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

            double median = ViewUtils.median(model.getArrayDouble());
            jtfMedian.setText("" + median);
        }

    }

    public JTextField getJtfField() {
        return jtfMedian;
    }

    public void setJtfMedian(JTextField jtfMedian) {
        this.jtfMedian = jtfMedian;
    }
}