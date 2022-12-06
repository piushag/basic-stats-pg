package model;

import java.util.ArrayList;


/**
 * The BasicStatsModel class stores a list of numbers. This class provides
 * the data representation for the MVC architecture pattern.
 */
public class BasicStatsModel implements Model
{
    // Store all collected numbers
    private ArrayList<Double> data = new ArrayList<Double>();
    
    
    public BasicStatsModel() {
	super();
    }

    /**
     * Adds the given number to the list of numbers.
     *
     * Post-condition: If the given number is non-null, the list of numbers
     *                 contains that number.
     *
     * @param number The given number to be added to the list of numbers
     * @exception IllegalArgumentException if the given number is null
     */
    public void addNumber(Double number) {
	// Input validation
	if (number == null) {
	    throw new IllegalArgumentException("The number must be non-null.");
	}

	this.data.add(number);
    }

    /**
     * Resets the list of numbers.
     *
     * Post-condition: The list of numbers is empty.
     */
    public void reset() {
	this.data.clear();
    }

    /**
     * Converts from a list of doubles to an array of doubles.
     *
     * @return An array of doubles that contains all of numbers
     *         in the list of doubles in the same order
     */
    public double[] getArrayDouble() {
	double[] result = new double[this.data.size()];
	
	for (int i = 0 ; i < this.data.size(); i++) {
	    result[i] = this.data.get(i);
	}
	
	return result;
    }


    /**
     * Removes the last added number.
     *
     * Post-condition: The list of numbers does not have the last added number,
     * or empty if only 1 number was preset.
     */
    public void undo(){
        //when size of data is 0, do nothing
        if(this.data.size()==0){
            return;
        }else{
            //Remove last element when 1 or more elements exist
            this.data.remove(this.data.size()-1);
        }
    }
}
