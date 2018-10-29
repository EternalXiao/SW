
public class InsertionSort {
	public static int[] insertionSort(int[] numbers) {
		int[] sortedNumbers = numbers;
		int temp;
		for(int i = 1; i < sortedNumbers.length; i++) {
			for (int j = i; j > 0; j--) {
				if (sortedNumbers[j] < sortedNumbers[j-1]) {
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
