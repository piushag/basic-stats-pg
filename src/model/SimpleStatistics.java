package model;

import view.ViewUtils;

import java.util.Arrays;

public class SimpleStatistics {

    public interface ComputeStrategy {

        double computeStatistic(double[] numbers);
    }

    public static class ComputeCount implements ComputeStrategy{
        @Override
        public double computeStatistic(double[] numbers) {
            return numbers.length;
        }
    }

    public static class ComputeMax implements ComputeStrategy{
        @Override
        public double computeStatistic(double[] numbers) {
            Arrays.sort(numbers);
            int size = numbers.length;
            return numbers[size-1];
        }
    }


    public static class ComputeMean implements ComputeStrategy{
        @Override
        public double computeStatistic(double[] numbers) {
            double sum = 0;
            for (double num : numbers) {
                sum += num;
            }
            return ModelUtils.trimDecimal(sum / numbers.length);
        }
    }

    public static class ComputeMedian implements ComputeStrategy{
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
