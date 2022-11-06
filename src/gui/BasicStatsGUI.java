package gui;

import java.util.*;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.List;

import model.BasicStatsModel;
//import gui.view.View;
import gui.view.*;


/**
 * Create a simple GUI that includes:
 * - a text field and a button that allows the user to enter numbers.
 * - a button that allows the user to clear all entered numbers.
 * - a panel with labels and text fields for count, median, and mean.
 * - a text area that shows all numbers.
 * <p>
 * For the MVC architecture pattern, these are the views and controllers.
 */
public class BasicStatsGUI implements View {
    public static final String APP_TITLE = "Simple stats";

    private static BasicStatsModel model = new BasicStatsModel();

    private JFrame jfMain = new JFrame(APP_TITLE);

    private List<View> childViews;

    public BasicStatsGUI() {
        // Create the main frame of the application, and set size and position
        jfMain.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        jfMain.setSize(600, 400);
        jfMain.setLocationRelativeTo(null);

        // Panel that shows stats about the numbers

        JPanel jpStats = new JPanel(new FlowLayout(FlowLayout.CENTER));

        this.childViews = new ArrayList<>();

        //new stuff
        childViews.add(new CountView(jpStats));
        childViews.add(new MedianView(jpStats));
        childViews.add(new MeanView(jpStats));
        childViews.add(new NumbersView(jfMain));
        childViews.add(new MaxView(jpStats));


        jfMain.getContentPane().add(jpStats, BorderLayout.CENTER);


        // Panel with a text field/button to enter numbers and a button to reset the application
        JButton jbReset = new JButton("Reset");
        jbReset.addActionListener(new ActionListener() {
            // The interface ActionListener defines a call-back method actionPerformed,
            // which is invoked if the user interacts with the GUI component -- in this
            // case, if the user clicks the button.
            public void actionPerformed(ActionEvent e) {
                // Clear the ArrayList and all text fields
                model.reset();

                update(model);
            }
        });
        JTextField jtfNumber = new JTextField(5);
        JButton jbAdd = new JButton("Add number");
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

                update(model);
            }
        });
        JPanel jpInput = new JPanel(new FlowLayout(FlowLayout.CENTER));
        jpInput.add(jtfNumber);
        jpInput.add(jbAdd);
        jpInput.add(jbReset);

        jfMain.getContentPane().add(jpInput, BorderLayout.NORTH);
    }

    public void update(BasicStatsModel model) {
        for (View view : childViews) {
            view.update(model);
        }
    }

    public void show() {
        // Show the frame
        jfMain.setVisible(true);
    }

}
