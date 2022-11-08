package gui.view;

import gui.BasicStatsGUI;
import model.BasicStatsModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddNumberView implements View{
    private JTextField jtfNumber;
    private JButton jbAdd;

    private BasicStatsGUI controller;

    public AddNumberView(BasicStatsModel model){
        jtfNumber = new JTextField(5);
        jbAdd = new JButton("Add number");

        jbAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Parse input and add number to the ArrayList
                Double num = null;
                try {
                    num = Double.parseDouble(jtfNumber.getText());
                    model.addNumber(num);
                } catch (NumberFormatException ex) {
                    String message = "Not a valid number";
                    JOptionPane.showMessageDialog(new JFrame(), message, "Error",
                            JOptionPane.ERROR_MESSAGE);
                    throw new RuntimeException(ex);
                }
                controller.update(model);
            }
        });

    }

    public void update(BasicStatsModel model) {
        jtfNumber.setText("");
    }

    public JTextField show() {
        return jtfNumber;
    }

    public JButton getButton() {
        return jbAdd;
    }

    public void addController(BasicStatsGUI ctrl) {
        controller = ctrl;
    }



}
