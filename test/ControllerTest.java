import controller.Controller;
import model.BasicStatsModel;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import view.*;

import java.awt.event.WindowEvent;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ControllerTest {

    private BasicStatsModel model;
    private AddNumberView addNumberView;

    private ResetView resetView;

    private List<View> allViews;

    @Before
    public void setUp(){
        BasicStats.main();

        model = BasicStats.getModel();


        allViews = BasicStats.getBsView().getChildViews();

        for (View vw : allViews) {
            if (vw instanceof AddNumberView) {
                addNumberView = (AddNumberView) vw;
            } else if (vw instanceof ResetView) {
                resetView = (ResetView) vw;
            }
        }
    }

    @After
    public void tearDown(){
        BasicStats.getJfMain().dispatchEvent(new WindowEvent(BasicStats.getJfMain(), WindowEvent.WINDOW_CLOSING));
    }

    @Test
    public void testAdNumberController() {
        Controller cont_add = addNumberView.getCont();
        cont_add.updateModels(model, "1");

        for (View vw : allViews) {
            if (vw instanceof NumbersView) {
                assertFalse(((NumbersView)vw).getJtaNumbers().getText().isBlank());
            }
        }
    }

    @Test
    public void testResetController(){
        Controller cont_reset = resetView.getController();
        cont_reset.updateModels(model);

        for (View vw : allViews) {
            if (vw instanceof CountView || vw instanceof MaxView || vw instanceof MeanView || vw instanceof MedianView || vw instanceof AddNumberView) {
                assertTrue(vw.getJtfField().getText().isBlank());
            }
        }

    }



}
