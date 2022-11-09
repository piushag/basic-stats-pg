package gui.view;

import model.BasicStatsModel;

import javax.swing.*;


/**
Implements all the logic for adding the count
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
        if (model.getArrayDouble().length == 0) {
            jtfCount.setText("");
        }else {
            // Compute and set the count
            int count = model.getArrayDouble().length;
            jtfCount.setText("" + count);
        }

    }
}