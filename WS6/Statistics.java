/**
 * Statistics is a class defines three statistical method: maximum,
 * average and standardDeviation for a list of values.
 */
import java.util.ArrayList;

public class Statistics {
	/**
	 * maximum computes the maximum value in the list
	 * @param elements a list of measurable objects
	 * @return the maximum value in the list
	 */
	public static double maximum(ArrayList<Measurable> elements) {
		double max = elements.get(0).getValue();
		for (Measurable element:elements) {
			if (element.getValue()>max) {
				max = element.getValue();
			}
		}
		return max;
	}
	
	/**
	 * average computes the average value among the list
	 * @param elements a list of measurable objects
	 * @return the average value of the list
	 */
	public static double average(ArrayList<Measurable> elements) {
		double total = 0;
		for (Measurable element:elements) {
			total += element.getValue();
		}
		return total/elements.size();
	}
	
	/**
	 * standardDeviation computes the standard deviation for the list elements
	 * @param elements a list of measurable objects
	 * @return the standard deviation of the list
	 */
	public static double standardDeviation(ArrayList<Measurable> elements) {
		double averageValue = average(elements);
		double squareDifference = 0;
		for (Measurable element:elements) {
			squareDifference += Math.pow(averageValue - element.getValue(), 2);
		}
		return Math.sqrt(squareDifference/(elements.size()-1));
	}
}
