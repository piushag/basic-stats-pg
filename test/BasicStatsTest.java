import gui.view.ViewUtils;
import org.junit.Test;
import static org.junit.Assert.*;

public class BasicStatsTest {
    private static double EPS = 1e-9;

    @Test
    public void testCentralTendency() {
        double[] numbers = {2, 2, 3, 3, 3, 4, 4};
        double mean   = ViewUtils.mean(numbers);
        assertEquals (3, mean, EPS);
        double median = ViewUtils.median(numbers);
        assertEquals (3, median, EPS);
        double mode   = ViewUtils.mode(numbers);
        assertEquals (3, mode, EPS);
    }

    @Test
    public void testMedian() {
      //Median should be 8.0 since size is even
      /* double[] numbers = {1, 4, 7, 9, 11, 21}; */
      double[] numbers = {9, 11, 1, 4, 7, 21};

      double median = ViewUtils.median(numbers);
      assertEquals(8.0, median, EPS);

      //Median should be 7 since size is odd
      double[] numbers2 = {9, 1, 4, 7, 21};
      median = ViewUtils.median(numbers2);
      assertEquals(7, median, EPS);

      //Median should be 3 since size is 1
      double[] numbers3 = {3};
      median = ViewUtils.median(numbers3);
      assertEquals(3, median, EPS);

      //Median should be 0 since size is 0
      double[] numbers4 = {};
      median = ViewUtils.median(numbers4);
      assertEquals(0, median, EPS);
    }

    @Test
    public void testMode() {
      //Mode should be 1 since we are taking the first mode
      double[] numbers = {1, 4, 7, 9, 11, 21};
      double mode   = ViewUtils.mode(numbers);
      assertEquals (1, mode, EPS);

      //Mode should be 4
      double[] numbers2 = {1, 4, 4, 7, 9, 11, 21};
      mode   = ViewUtils.mode(numbers2);
      assertEquals (4, mode, EPS);

      //Mode should be 7
      double[] numbers3 = {4, 4, 7, 7, 7, 11, 11};
      mode   = ViewUtils.mode(numbers3);
      assertEquals (7, mode, EPS);

      //Mode should be 7
      double[] numbers4 = {7};
      mode   = ViewUtils.mode(numbers4);
      assertEquals (7, mode, EPS);

      //Mode should be 0
      double[] numbers5 = {};
      mode   = ViewUtils.mode(numbers5);
      assertEquals (0, mode, EPS);
    }

    @Test
    public void testMax() {
        double[] numbers = {9, 11, 1, 4, 7, 21};

        double max = ViewUtils.max(numbers);
        assertEquals(21, max, EPS);

        double[] numbers2 = {9, 1, 4, 7, 2};
        max = ViewUtils.max(numbers2);
        assertEquals(9, max, EPS);

        double[] numbers3 = {3};
        max = ViewUtils.max(numbers3);
        assertEquals(3, max, EPS);
    }
}
