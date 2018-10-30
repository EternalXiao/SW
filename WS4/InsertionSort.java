/** InsertionSort is a class that implements insertion sort algorithm
 * There is not any field variable but only a method of algorithm.
 */
public class InsertionSort {
	/**
	 * A method to implement insertion sort
	 * @param numbers the unsorted array
	 * @return the sorted array
	 */
	public static int[] insertionSort(int[] numbers) {
		int[] sortedNumbers = numbers;
		int temp;
		for(int i = 1; i < sortedNumbers.length; i++) {
			for (int j = i; j > 0; j--) {
				if (sortedNumbers[j] < sortedNumbers[j-1]) {
					//if the value at current index is smallar than 
					//the value in previous index, then swap
					temp = sortedNumbers[j];
					sortedNumbers[j] = sortedNumbers[j-1];
					sortedNumbers[j-1] = temp;
				}
				else {
					break;
				}
			}
		}
		return sortedNumbers;
	}
	
	public static void main(String[] args) {
		int[] a = {4,3,6,1,9,2};
		a = insertionSort(a);
		for (int e : a) {
			System.out.print(e+" ");
		}

	}
}
