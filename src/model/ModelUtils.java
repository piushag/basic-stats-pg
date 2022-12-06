package model;

public class ModelUtils {
    /**
     * Trims the numbers to 2 decimal points.
     */
    public static double trimDecimal(double num){
        int temp = (int)(num*100.0);
        return ((double)temp)/100.0;
    }
}
