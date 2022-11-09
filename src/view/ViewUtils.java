package view;

import java.text.DecimalFormat;
import java.util.Arrays;

public class ViewUtils {

    /**
     * Compute the mean of an array of numbers.
     */
    public static double mean(double ... numbers) {
        double sum = 0;
        for (double num : numbers) {
            sum += num;
        }
        return trimDecimal(sum / numbers.length);
    }

    /**
     * Compute the median of an array of numbers.
     */
    public static double median(double ... numbers) {
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

        return trimDecimal(median);
    }

    /**
     * Compute the mode of an array of numbers.
     */
    public static double mode(double ... numbers) {
        double mode = 0.0;
        int modeCount = 0;

        for (double num: numbers) {

            int count = 0;

            for (double otherNum: numbers) {
                if (num == otherNum) {
                    count++;
                }
            }

            if (count > modeCount) {
                modeCount = count;
                mode = num;
            }

        }

        return mode;
    }

    /**
     * Compute the maximum of an array of numbers.
     */
    public static double max(double ... numbers) {
        Arrays.sort(numbers);
        int size = numbers.length;
        return numbers[size-1];
    }

    private static double trimDecimal(double num){
        int temp = (int)(num*100.0);
        return ((double)temp)/100.0;
    }
}
