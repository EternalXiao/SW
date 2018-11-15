import java.util.ArrayList;

public class Statistics {
	public static double maximum(ArrayList<Measurable> elements) {
		double max = elements.get(0).getValue();
		for (Measurable element:elements) {
			if (element.getValue()>max) {
				max = element.getValue();
			}
		}
		return max;
	}
	
	public static double average(ArrayList<Measurable> elements) {
		double total = 0;
		for (Measurable element:elements) {
			total += element.getValue();
		}
		return total/elements.size();
	}
	
	public static double standardDeviation(ArrayList<Measurable> elements) {
		double averageValue = average(elements);
		double squareDifference = 0;
		for (Measurable element:elements) {
			squareDifference += Math.pow(averageValue - element.getValue(), 2);
		}
		return Math.sqrt(squareDifference/(elements.size()-1));
	}
}
