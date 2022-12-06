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

    //Tests if the model is adding the number
    @Test
    public void testModelAddNumber(){
        model.addNumber(1.0);
        assertTrue(model.getArrayDouble().length != 0);
    }

    //Tests if the reset method is clearing the fields
    @Test
    public void testModelReset(){
        model.addNumber(1.0);
        model.reset();
        assertTrue(model.getArrayDouble().length ==0);
    }

    //Tests if the undo method is removing the last number
    @Test
    public void testModelUndo(){
        model.addNumber(1.0);
        model.undo();
        assertTrue(model.getArrayDouble().length ==0);
    }
}
