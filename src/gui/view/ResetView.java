package gui.view;

import controller.Controller;
import controller.ResetController;
import gui.BasicStatsGUI;
import model.BasicStatsModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResetView implements View{

    public JButton getJbReset() {
        return jbReset;
    }

    public void setJbReset(JButton jbReset) {
        this.jbReset = jbReset;
    }

    private JButton jbReset;
    private Controller controller;

    public ResetView(BasicStatsModel model){
        // Panel with a text field/button to enter numbers and a button to reset the application
        jbReset = new JButton("Reset");
        jbReset.addActionListener(new ActionListener() {
            // The interface ActionListener defines a call-back method actionPerformed,
            // which is invoked if the user interacts with the GUI component -- in this
            // case, if the user clicks the button.
            public void actionPerformed(ActionEvent e) {
                controller.updateModels(model);
            }
        });
    }
    @Override
    public void update(BasicStatsModel model) {
    }

    public JButton getButton() {
        return jbReset;
    }

    public void addController(Controller ctrl) {
        controller = ctrl;
    }
}
