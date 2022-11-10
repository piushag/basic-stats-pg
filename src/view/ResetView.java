package view;

import controller.Controller;
import model.BasicStatsModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * The ResetView class implements the code to add the reset button, and call the reset controller when the button is clicked.
 */
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

    @Override
    public JTextField getJtfField() {
        return null;
    }


    public JButton getButton() {
        return jbReset;
    }

    public void addController(Controller ctrl) {
        controller = ctrl;
    }

    /**
     * Adds a controller to execute the underlying functions
     */
    public Controller getController() {
        return controller;
    }
}
