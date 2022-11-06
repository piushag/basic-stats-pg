package gui.view;

import model.BasicStatsModel;

import java.awt.*;
import java.util.*;
import javax.swing.*;


//import java.awt.*;
//import java.awt.event.*;

/**
 Implements all the logic for adding the numbers
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
}