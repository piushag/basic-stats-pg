import controller.AddNumberController;
import model.BasicStatsModel;
import org.junit.Before;
import org.junit.Test;
import view.AddNumberView;
import view.BasicStatsView;

import static org.junit.Assert.assertEquals;

public class ViewTest {

    private BasicStatsModel model;
    private AddNumberView addNumberView;

    private BasicStatsView bsView;

    @Before
    public void setUp(){
        bsView = new BasicStatsView();
        model = new BasicStatsModel();
        addNumberView = new AddNumberView(model);
        addNumberView.addController(new AddNumberController(bsView));
    }

    //Tests if the number is being added to the list of numbers
    @Test
    public void testAddNumberViewSuccess() {
        addNumberView.getJtfField().setText("1");
        addNumberView.getButton().doClick();
        assertEquals(model.getArrayDouble()[0], 1.0, 0);
    }

    //fail scenario for adding the numbers
    @Test(expected = RuntimeException.class)
    public void testAddNumberViewFails() {
        addNumberView.getJtfField().setText("abc");
        addNumberView.getButton().doClick();
    }

}
