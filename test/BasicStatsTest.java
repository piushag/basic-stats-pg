import controller.Controller;
import model.BasicStatsModel;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import view.*;

import javax.swing.*;

import java.awt.event.WindowEvent;
import java.util.List;

import static org.junit.Assert.*;

public class BasicStatsTest {

    private BasicStatsModel model;
    private BasicStatsView view;

    private JFrame jfMain;

    private JPanel jpStats;

    private AddNumberView addNumberView;

    private ResetView resetView;

    private UndoView undoView;
    
    private NumbersView numsView;

    private List<View> allViews;

    @Before
    public void setUp() {
        BasicStats.main();
        jfMain = BasicStats.getJfMain();

        jfMain.setVisible(false);

        model = BasicStats.getModel();
        view = BasicStats.getBsView();
        jpStats = BasicStats.getJpStats();

        allViews = view.getChildViews();

        for (View vw : allViews) {
            if (vw instanceof AddNumberView) {
                addNumberView = (AddNumberView) vw;
            } else if (vw instanceof ResetView) {
                resetView = (ResetView) vw;
            }else if(vw instanceof UndoView){
                undoView = (UndoView) vw;
            } else if (vw instanceof NumbersView) {
                numsView = (NumbersView) vw;
                
            }
        }
    }

    @After
    public void tearDown() {
        jfMain.dispatchEvent(new WindowEvent(jfMain, WindowEvent.WINDOW_CLOSING));
    }

    //Tests if the app is running okay by checking if all the fields are initialized as expected.
    @Test
    public void testStartApp() {
        for (View vw : allViews) {
            if (vw instanceof CountView || vw instanceof MaxView || vw instanceof MeanView || vw instanceof MedianView) {
                assertTrue(vw.getJtfField().getText().isBlank());
                assertTrue(vw.getJtfField().isEnabled());
                assertFalse(vw.getJtfField().isEditable());
            } else if (vw instanceof AddNumberView) {
                assertTrue(vw.getJtfField().getText().isBlank());
                assertTrue(vw.getJtfField().isEnabled());
                assertTrue(vw.getJtfField().isEditable());
            } else if (vw instanceof ResetView) {
                assertTrue(((ResetView) vw).getJbReset().isEnabled());
            }else if (vw instanceof NumbersView){
                assertTrue(((NumbersView)vw).getJtaNumbers().getText().isBlank());
            }
        }
    }

    //Tests if max is being computed when a number is added
    //This test case would fail if we did not fix the bug in the initial version of the app.
    @Test
    public void testMaxSuccess() {
        MaxView maxView = null;
        for (View vw : allViews) {
            if (vw instanceof MaxView) {
                maxView = (MaxView) vw;
            }
        }
        addNumberView.getJtfField().setText("1");
        addNumberView.getButton().doClick();
        addNumberView.getJtfField().setText("5");
        addNumberView.getButton().doClick();

        assertEquals(maxView.getJtfField().getText(), "5.0");
    }

    //Tests if max fails when we add an invalid number
    @Test(expected = RuntimeException.class)
    public void testMaxFails() {
        MaxView maxView = null;
        for (View vw : allViews) {
            if (vw instanceof MaxView) {
                maxView = (MaxView) vw;
            }
        }
        addNumberView.getJtfField().setText("abc");
        addNumberView.getButton().doClick();

        assertTrue(maxView.getJtfField().getText().isBlank());
    }

    //Tests if reset is working as expected by resetting to original state.
    @Test
    public void testResetSuccess() {
        addNumberView.getJtfField().setText("1");
        addNumberView.getButton().doClick();

        for (View vw : allViews) {
            if (vw instanceof CountView || vw instanceof MaxView || vw instanceof MeanView || vw instanceof MedianView) {
                assertFalse(vw.getJtfField().getText().isBlank());
            }
        }

        resetView.getButton().doClick();

        for (View vw : allViews) {
            if (vw instanceof CountView || vw instanceof MaxView || vw instanceof MeanView || vw instanceof MedianView || vw instanceof AddNumberView) {
                assertTrue(vw.getJtfField().getText().isBlank());
            }
        }
    }

    @Test
    public void testUndoDisabled(){
        assertFalse(undoView.getButton().isEnabled());

        addNumberView.getJtfField().setText("1");
        addNumberView.getButton().doClick();

        assertTrue(undoView.getButton().isEnabled());
    }

    @Test
    public void testUndoSuccess() {
        addNumberView.getJtfField().setText("1");
        addNumberView.getButton().doClick();

        undoView.getButton().doClick();


        for (View vw : allViews) {
            if (vw instanceof CountView || vw instanceof MaxView || vw instanceof MeanView || vw instanceof MedianView || vw instanceof AddNumberView) {
                assertTrue(vw.getJtfField().getText().isBlank());
            }
        }

        addNumberView.getJtfField().setText("2");
        addNumberView.getButton().doClick();

        addNumberView.getJtfField().setText("3");
        addNumberView.getButton().doClick();

        assertFalse(numsView.getJtaNumbers().getText().isBlank());
        String nums = "2.0,3.0,";
        assertEquals(numsView.getJtaNumbers().getText(), nums);


        undoView.getButton().doClick();


        assertFalse(numsView.getJtaNumbers().getText().isBlank());
        String nums_2 = "2.0,";
        assertEquals(numsView.getJtaNumbers().getText(), nums_2);


    }

    

}
