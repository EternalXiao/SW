import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class InsertionSortTest {
	
	//Test for small arrays
	@Test
	public void test1() {
		int[] num1 = {2, 5, 3, 6, 1};
		int[] num2 = {8, 5, 7, 3, 9};
		int[] expected1 = {1, 2, 3, 5, 6};
		int[] expected2 = {3, 5, 7, 8, 9};
		assertTrue(Arrays.equals(InsertionSort.insertionSort(num1), expected1));
		assertTrue(Arrays.equals(InsertionSort.insertionSort(num2), expected2));
	}
	
	//Test for large arrays
	@Test
	public void test2() {
		int[] num1 = {2, 5, 3, 6, 99, 56, 83, 10, 27, 1};
		int[] num2 = {8, 5, 35, 26, 88, 14, 55, 60, 7, 3, 9};
		int[] expected1 = {1, 2, 3, 5, 6, 10, 27, 56, 83, 99};
		int[] expected2 = {3, 5, 7, 8, 9, 14, 26, 35, 55, 60, 88};
		assertTrue(Arrays.equals(InsertionSort.insertionSort(num1), expected1));
		assertTrue(Arrays.equals(InsertionSort.insertionSort(num2), expected2));
	}
	
	//Test for arrays with duplicates
	@Test
	public void test3() {
		int[] num1 = {2, 2, 3, 6, 3};
		int[] num2 = {8, 8, 7, 7, 9};
		int[] expected1 = {2, 2, 3, 3, 6};
		int[] expected2 = {7, 7, 8, 8, 9};
		assertTrue(Arrays.equals(InsertionSort.insertionSort(num1), expected1));
		assertTrue(Arrays.equals(InsertionSort.insertionSort(num2), expected2));
	}
	
	//Test for empty arrays
	@Test
	public void test4() {
		int[] num1 = {};
		int[] num2 = {};
		int[] expected1 = {};
		int[] expected2 = {};
		assertTrue(Arrays.equals(InsertionSort.insertionSort(num1), expected1));
		assertTrue(Arrays.equals(InsertionSort.insertionSort(num2), expected2));
	}
	
	//Test for arrays with negative number and zero
	@Test
	public void test5() {
		int[] num1 = {2, 0, -3, 6, 1};
		int[] num2 = {8, -5, 0, 3, 9};
		int[] expected1 = {-3, 0, 1, 2, 6};
		int[] expected2 = {-5, 0, 3, 8, 9};
		assertTrue(Arrays.equals(InsertionSort.insertionSort(num1), expected1));
		assertTrue(Arrays.equals(InsertionSort.insertionSort(num2), expected2));
	}
	
	//Test for sorted arrays
	@Test
	public void test6() {
		int[] num1 = {1, 2, 3, 5, 6};
		int[] num2 = {3, 5, 7, 8, 9};
		int[] expected1 = {1, 2, 3, 5, 6};
		int[] expected2 = {3, 5, 7, 8, 9};
		assertTrue(Arrays.equals(InsertionSort.insertionSort(num1), expected1));
		assertTrue(Arrays.equals(InsertionSort.insertionSort(num2), expected2));
	}
}
