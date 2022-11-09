package view;

import controller.Controller;
import model.BasicStatsModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddNumberView implements View{
    private JTextField jtfNumber;

    public JTextField getJtfNumber() {
        return jtfNumber;
    }

    public void setJtfNumber(JTextField jtfNumber) {
        this.jtfNumber = jtfNumber;
    }

    public JButton getJbAdd() {
        return jbAdd;
    }

    public void setJbAdd(JButton jbAdd) {
        this.jbAdd = jbAdd;
    }

    private JButton jbAdd;

    private Controller cont;

    public AddNumberView(BasicStatsModel model){
        jtfNumber = new JTextField(5);
        jbAdd = new JButton("Add number");

        jbAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cont.updateModelsWithNums(model, jtfNumber.getText());
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

    public void addController(Controller ctrl) {
        cont = ctrl;
    }



}
