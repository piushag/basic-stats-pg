package view;

import model.BasicStatsModel;

import java.awt.*;

import javax.swing.*;



/**
 * The NumbersView class implements the logic to update and display the list of numbers.
 */
public class NumbersView implements View
{

    private JTextArea jtaNumbers;

    public NumbersView(JFrame jfMain) {
        // TextArea that shows all the numbers
        jtaNumbers = new JTextArea(10,50);
        jtaNumbers.setEditable(false);
        jfMain.getContentPane().add(jtaNumbers, BorderLayout.SOUTH);
    }

    public void update(BasicStatsModel model){
        if (model.getArrayDouble().length == 0) {
            jtaNumbers.setText("");
        }else {
            // Update the displayed list of numbers
            double num = model.getArrayDouble()[model.getArrayDouble().length - 1];
            jtaNumbers.append(num + ",");
        }

    }

    @Override
    public JTextField getJtfField() {
        return null;
    }

    public JTextArea getJtaNumbers() {
        return jtaNumbers;
    }

    public void setJtaNumbers(JTextArea jtaNumbers) {
        this.jtaNumbers = jtaNumbers;
    }


}