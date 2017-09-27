/**
 * 
 */
package org.escoladeltreball.firstassignment;

/**
 * @author Pep Méndez
 *
 */
public final class ReviewImpl implements Review {

	private int frequency(int[] values, int n) {
		int counter = 0;
		for (int value : values) {
			if (n == value) {
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
		return values.length == 0 ? 0 : ((double) frequency(values, n)) / values.length * 100;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.escoladeltreball.firstassignment.Utils#merge(int[], int)
	 */
	@Override
	public int[] merge(int[] values, int n) {
		int[] newValues = new int[values.length + 1];
		int i = 0;
		while (i < values.length && n > values[i]) {
			newValues[i] = values[i];
			i++;
		}
		newValues[i] = n;
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
		int evens = 0;
		int odds = 0;
		int dimension = 0;
		int evenCounter = 0;
		int oddCounter = 0;
		for (int i = 0; i < values.length; i++) {
			if (values[i] % 2 == 0) {
				evens++;
			} else {
				odds++;
			}
		}
		int[][] newValues = new int[2][];
		newValues[0] = new int[evens];
		newValues[1] = new int[odds];
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
