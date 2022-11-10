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
            }
        }
    }

    @After
    public void tearDown() {
        jfMain.dispatchEvent(new WindowEvent(jfMain, WindowEvent.WINDOW_CLOSING));
    }

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
            }else{
                assertTrue(((NumbersView)vw).getJtaNumbers().getText().isBlank());
            }
        }
    }

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

    @Test
    public void testResetSuccess() {
        addNumberView.getJtfField().setText("1");
        addNumberView.getButton().doClick();
        resetView.getButton().doClick();

        for (View vw : allViews) {
            if (vw instanceof CountView || vw instanceof MaxView || vw instanceof MeanView || vw instanceof MedianView || vw instanceof AddNumberView) {
                assertTrue(vw.getJtfField().getText().isBlank());
            }
        }
    }

}
