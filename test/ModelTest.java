import model.BasicStatsModel;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.assertTrue;

public class ModelTest {

    private BasicStatsModel model;



    @Before
    public void setUp() {
        model = new BasicStatsModel();

    }


    @Test
    public void testModelAddNumber(){
        model.addNumber(1.0);
        assertTrue(model.getArrayDouble().length != 0);
    }

    @Test
    public void testModelReset(){
        model.addNumber(1.0);
        model.reset();
        assertTrue(model.getArrayDouble().length ==0);
    }
}
