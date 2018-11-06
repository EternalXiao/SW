/** 
 * The mistake in this class occurs in the method measurementSeries. In the 
 * original code, once the random integer is 0, the measurement will throw 
 * an exception but there is no catch statement in measurementSeries. Thus,
 * the program will stop. In addition, the measurement will only throw an
 * exception or return 1 or 2. In this case, the if statement in the 
 * measurement will never execute. Also, the exception should not throw in 
 * the measurementSeries. Furthermore, the measurement was called for twice
 * in the measurementSeries, the value for these two would be different.
 * So, in the modified code, we need to catch the exception once the random
 * integer is 0 and assign the result with -1. Otherwise, we can directly
 * assign the return value.
 * 
 */
public class Measurement {

    /**
     *  The method is used to simulate an instrument that randomly
     *  return either 1 or 2, or malfunctions.
     *  @return The method returns randomly either 1 or 2.
     *  @exception IllegalArgumentException if the instrument
     *  malfunctions. This is simulated only and done when a random
     *  number of 0 is created (out of numbers 0, 1, or 2).
     */ 
    public static int measurement() {
        //Create a random integer of either 0, 1, or 2.
        int res = (int) (Math.random() * 3);
        if (res == 0) {
            throw new IllegalArgumentException();
        } else {
            return res;
        }
    }

    /**
     *  The method stores the result of n measurements in an array and
     *  return this.
     *  @param n The number of measurements.
     *  @return An array with the result of n measurements being
     *  either 1 or 2. If the measurement failed, a -1 is stored in
     *  the array.
     *  @exception IllegalArgumentException if the result of the
     *  measurement is -1. */ 
    public static int[] measurementSeries(int n) {
        int[] result = new int[n];
        //Loop to do exactly n measurments
        for (int i = 0; i < n; i++) {
            try {
            	result[i] = measurement();
            }
            catch (IllegalArgumentException e) {
            	result[i] = -1;
            }
        }
        return result;
    }

    /**
     *  Print out the elements of a one-dimensional integer array,
     *  separated by empty spaces.
     *  @param a A one-dimensional int array.
     */
    public static void printArray(int[] a) {
        for (int el : a) {
            System.out.print(el + " ");
        }
        System.out.println();
    }

    /* 
     * Main method to test the program with 10 measurements.
     */
    public static void main(String[] args) {
        printArray(measurementSeries(10));
    }
}
