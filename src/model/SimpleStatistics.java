package model;

import java.util.Arrays;

/**
 *Strategy Design pattern applied with the different helper classes for respective statistics.
 */
public class SimpleStatistics {

    /**
     *  Interface to compute the appropriate simple statistic.
     */
    public interface ComputeStrategy {

        double computeStatistic(double[] numbers);
    }

    /**
     * Count of numbers added so far.
     */
    public static class CountStatistic implements ComputeStrategy{
        @Override
        public double computeStatistic(double[] numbers) {
            return numbers.length;
        }
    }

    /**
     * Compute the maximum of an array of numbers.
     */
    public static class MaxStatistic implements ComputeStrategy{
        @Override
        public double computeStatistic(double[] numbers) {
            Arrays.sort(numbers);
            int size = numbers.length;
            return numbers[size-1];
        }
    }

    /**
     * Compute the mean of an array of numbers.
     */
    public static class MeanStatistic implements ComputeStrategy{
        @Override
        public double computeStatistic(double[] numbers) {
            double sum = 0;
            for (double num : numbers) {
                sum += num;
            }
            return ModelUtils.trimDecimal(sum / numbers.length);
        }
    }

    /**
     * Compute the median of an array of numbers.
     */
    public static class MedianStatistic implements ComputeStrategy{
        @Override
        public double computeStatistic(double[] numbers) {
            Arrays.sort(numbers);

            int size = numbers.length;
            double median = 0.0;

            if (size > 0) {
                if (size % 2 == 0) {
                    median = (numbers[size >> 1] + numbers[(size >> 1) - 1])/2;
                }
                else {
                    median = numbers[size >> 1];
                }
            }

            return ModelUtils.trimDecimal(median);
        }
    }

}
