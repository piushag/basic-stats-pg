package view;

import model.BasicStatsModel;

import javax.swing.*;


/**
 * The MaxView class implements the logic to add and display the max field, and compute the max value.
 */
public class MaxView implements View {

    private JTextField jtfMax;

    public MaxView(JPanel jpStats) {
        jtfMax = new JTextField(5);
        jtfMax.setEditable(false);
        jpStats.add(new JLabel("Maximum:"));
        jpStats.add(jtfMax);
    }

    public void update(BasicStatsModel model){
        if (model.getArrayDouble().length == 0) {
            jtfMax.setText("");
        }else {
            // Compute and set the maximum
            double max = ViewUtils.max(model.getArrayDouble());
            jtfMax.setText("" + max);
        }

    }

    public JTextField getJtfField() {
        return jtfMax;
    }

    public void setJtfMax(JTextField jtfMax) {
        this.jtfMax = jtfMax;
    }
}
