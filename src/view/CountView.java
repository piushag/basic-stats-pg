package view;

import model.BasicStatsModel;
import model.SimpleStatistics;

import javax.swing.*;


/**
 * The CountView class implements the logic to add and display the count field, and compute the count.
 */
public class CountView implements View
{

    private JTextField jtfCount;

    public CountView(JPanel jpStats) {
        jtfCount = new JTextField(5);
        jtfCount.setEditable(false);
        jpStats.add(new JLabel("Numbers:"));
        jpStats.add(jtfCount);
    }

    public void update(BasicStatsModel model){
//        if (model.getArrayDouble().length == 0) {
//            jtfCount.setText("");
//        }else {
//            // Compute and set the count
//            int count = model.getArrayDouble().length;
//            jtfCount.setText("" + count);
//        }
        int count = (int) new SimpleStatistics.ComputeCount().computeStatistic(model.getArrayDouble());

        if (count == 0) {
            jtfCount.setText("");
        }else {
            //set the count
            jtfCount.setText("" + count);
        }

    }

    public JTextField getJtfField() {
        return jtfCount;
    }

    public void setJtfCount(JTextField jtfCount) {
        this.jtfCount = jtfCount;
    }
}