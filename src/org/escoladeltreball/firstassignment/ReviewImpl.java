/**
 * 
 */
package org.escoladeltreball.firstassignment;

/**
 * @author Pep Méndez
 *
 */
public final class ReviewImpl implements Review {

	/**
	 * This method returns the number of times an integer number appears in an integer array
	 * @param values as an integer array
	 * @param n as an integer number 
	 * @return the number of times n appears in values
	 */
	private int frequency(int[] values, int n) {
		int counter = 0;
		//We're going over the array to check if the number entered is the same than the current value of the array
		for (int value : values) {
			if (n == value) {
				//If it is, the counter increases by 1
				counter++;
			}
		}
		return counter;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.escoladeltreball.firstassignment.Utils#frequencyPercentage(int[],
	 * int)
	 */	
	@Override
	public double frequencyPercentage(int[] values, int n) {
		//We're checking if the array entered is empty, if it is, returns zero, if not, returns the percentage of times that number appears in the array
		return values.length == 0 ? 0 : ((double) frequency(values, n)) / values.length * 100;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.escoladeltreball.firstassignment.Utils#merge(int[], int)
	 */
	@Override
	public int[] merge(int[] values, int n) {
		//First of all, we're creating a new array with just one more position
		int[] newValues = new int[values.length + 1];
		int i = 0;
		//We're putting all the values that are in the first array to the new array until the next value of the first array is bigger than the number we want to add
		while (i < values.length && n > values[i]) {
			newValues[i] = values[i];
			i++;
		}
		//Now it's time to locate our desired number
		newValues[i] = n;
		//Now, and until the end, we're putting all the rest of the numbers just next to the number we wanted to put in
		while (i < values.length) {
			newValues[i + 1] = values[i];
			i++;
		}
		return newValues;
	}

	/*
	 * This method returns an integer matrix with row 0 holding even numbers and
	 * row 1 holding odd numbers.
	 * 
	 * NOTE: Don't waste space!!!
	 */
	@Override
	public int[][] split(int[] values) {
		int evens = 0, odds = 0, evenCounter = 0, oddCounter = 0;
		//First of all, we're counting how much even and odds numbers there are
		for (int i = 0; i < values.length; i++) {
			if (values[i] % 2 == 0) {
				evens++;
			} else {
				odds++;
			}
		}
		//Now, we're creating the new 2-dimensions array with 2 rows
		int[][] newValues = new int[2][];
		//Let's add the necessary columns to save the numbers without having any empty cell
		newValues[0] = new int[evens];
		newValues[1] = new int[odds];
		//Now it's time to put each number in its row. (Evens in the first one, and odds in the second one)
		for (int i = 0; i < values.length; i++) {
			if (values[i] % 2 == 0) {
				newValues[0][evenCounter] = values[i];
				evenCounter++;
			} else {
				newValues[1][oddCounter] = values[i];
				oddCounter++;
			}
		}
		return newValues;
	}

}
