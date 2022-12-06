import model.SimpleStatistics;
import org.junit.Test;
import view.ViewUtils;

import static org.junit.Assert.assertEquals;

public class TestSimpleStatistics {

    private static double EPS = 1e-9;

    @Test
    public void testCentralTendency() {
        double[] numbers = {2, 2, 3, 3, 3, 4, 4};
        double mean   = new SimpleStatistics.ComputeMean().computeStatistic(numbers);
        assertEquals (3, mean, EPS);
        double median =  new SimpleStatistics.ComputeMedian().computeStatistic(numbers);
        assertEquals (3, median, EPS);
    }

    @Test
    public void testMedian() {
        //Median should be 8.0 since size is even
        /* double[] numbers = {1, 4, 7, 9, 11, 21}; */
        double[] numbers = {9, 11, 1, 4, 7, 21};

        double median =  new SimpleStatistics.ComputeMedian().computeStatistic(numbers);
        assertEquals(8.0, median, EPS);

        //Median should be 7 since size is odd
        double[] numbers2 = {9, 1, 4, 7, 21};
        median =  new SimpleStatistics.ComputeMedian().computeStatistic(numbers2);
        assertEquals(7, median, EPS);

        //Median should be 3 since size is 1
        double[] numbers3 = {3};
        median =  new SimpleStatistics.ComputeMedian().computeStatistic(numbers3);
        assertEquals(3, median, EPS);

        //Median should be 0 since size is 0
        double[] numbers4 = {};
        median =  new SimpleStatistics.ComputeMedian().computeStatistic(numbers4);
        assertEquals(0, median, EPS);
    }


    @Test
    public void testMax() {
        double[] numbers = {9, 11, 1, 4, 7, 21};
        //max should be 21
        double max =  new SimpleStatistics.ComputeMax().computeStatistic(numbers);
        assertEquals(21, max, EPS);
        //max should be 9
        double[] numbers2 = {9, 1, 4, 7, 2};
        max = new SimpleStatistics.ComputeMax().computeStatistic(numbers2);
        assertEquals(9, max, EPS);
        //max should be 3
        double[] numbers3 = {3};
        max = new SimpleStatistics.ComputeMax().computeStatistic(numbers3);
        assertEquals(3, max, EPS);
    }
}
