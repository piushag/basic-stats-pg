package view;

import controller.Controller;
import model.BasicStatsModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UndoView implements View{
    private JButton jbUndo;

    private Controller controller;

    public UndoView(BasicStatsModel model){
        jbUndo = new JButton("Undo");
        jbUndo.setEnabled(false);
        jbUndo.addActionListener(new ActionListener() {
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
        if(model.getArrayDouble().length == 0){
            jbUndo.setEnabled(false);
        }else{
            jbUndo.setEnabled(true);
        }
    }

    @Override
    public JTextField getJtfField() {
        return null;
    }


    public JButton getButton() {
        return jbUndo;
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
