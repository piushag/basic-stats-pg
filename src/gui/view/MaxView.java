package gui.view;

import gui.BasicStats;
import model.BasicStatsModel;
import java.util.*;
import javax.swing.*;

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
            double max = BasicStats.max(model.getArrayDouble());
            jtfMax.setText("" + max);
        }

    }
}
