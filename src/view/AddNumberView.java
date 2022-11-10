package view;

import controller.Controller;
import model.BasicStatsModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * The AddNumberView class implements the code to add the text field, and the button to add the number
 * Calls the AddNumber controller when the button is clicked.
 */
public class AddNumberView implements View{
    private JTextField jtfNumber;

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
                cont.updateModels(model, jtfNumber.getText());
            }
        });

    }

    public void update(BasicStatsModel model) {
        //Fixes the bug that does not reset the number field.
        jtfNumber.setText("");
    }

    @Override
    public JTextField getJtfField() {
        return jtfNumber;
    }


    public JTextField show() {
        return jtfNumber;
    }

    public JButton getButton() {
        return jbAdd;
    }

    /**
     * Adds a controller to execute the underlying functions
     */
    public void addController(Controller ctrl) {
        cont = ctrl;
    }


    public Controller getCont() {
        return cont;
    }


}
