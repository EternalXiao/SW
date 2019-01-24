import static org.junit.Assert.*;
import org.junit.Test;
/** @author Xiaolong Meng
 * This class contains the test cases for Worksheet1 solutions.
 */

public class Worksheet1Test {
	
	// Test for power and fastPower
	@Test
	public void test1() {
		//Test for both m and n are positive
		long startTime = System.currentTimeMillis(),endTime;
		assertEquals(Worksheet1.power(2,3),8);
		assertEquals(Worksheet1.power(2,30),1073741824);
		endTime = System.currentTimeMillis();
		System.out.println("power consumed " + (endTime-startTime) + " ns");
		startTime = System.currentTimeMillis();
		assertEquals(Worksheet1.fastPower(2,3),8);
		assertEquals(Worksheet1.fastPower(2,30),1073741824);
		endTime = System.currentTimeMillis();
		System.out.println("fastPower consumed " + (endTime-startTime) + " ns");
		//Test for n equals 0
		assertEquals(Worksheet1.power(2,0),1);
		assertEquals(Worksheet1.fastPower(2,0),1);
		assertEquals(Worksheet1.power(3,0),1);
		assertEquals(Worksheet1.fastPower(3,0),1);
		//Test for m equals 0
		assertEquals(Worksheet1.power(0,3),0);
		assertEquals(Worksheet1.fastPower(0,3),0);
		assertEquals(Worksheet1.power(0,8),0);
		assertEquals(Worksheet1.fastPower(0,8),0);
		//Test for both m and n are 0
		assertEquals(Worksheet1.power(0,0),1);
		assertEquals(Worksheet1.fastPower(0,0),1);
	}
	
	// Test for negateAll
	@Test
	public void test2() {
		//Test for all positive numbers
		List<Integer> list1 = new List<>(7,new List<>(5,new List<>(2,new List<>(8,new List<>()))));
		List<Integer> list2 = new List<>(-7,new List<>(-5,new List<>(-2,new List<>(-8,new List<>()))));
		assertEquals(Worksheet1.negateAll(list1),list2);
		//Test for all negative numbers
		List<Integer> list3 = new List<>(-1,new List<>(-5,new List<>(-6,new List<>(-7,new List<>()))));
		List<Integer> list4 = new List<>(1,new List<>(5,new List<>(6,new List<>(7,new List<>()))));
		assertEquals(Worksheet1.negateAll(list3),list4);
		//Test for negative, positive and 0
		List<Integer> list5 = new List<>(3,new List<>(5,new List<>(0,new List<>(-8,new List<>()))));
		List<Integer> list6 = new List<>(-3,new List<>(-5,new List<>(0,new List<>(8,new List<>()))));
		assertEquals(Worksheet1.negateAll(list5),list6);
	}
	
	// Test for find
	@Test(expected = IllegalArgumentException.class)
	public void test3() {
		//Test for element found
		List<Integer> list1 = new List<>(7,new List<>(5,new List<>(2,new List<>(8,new List<>()))));
		assertEquals(Worksheet1.find(2, list1),2);
		assertEquals(Worksheet1.find(5, list1),1);
		//Test for not found
		Worksheet1.find(1, list1);
	}
	
	// Test for allPositive
	@Test
	public void test4() {
		List<Integer> list1 = new List<>(7,new List<>(5,new List<>(2,new List<>(8,new List<>()))));
		List<Integer> list2 = new List<>(-7,new List<>(-5,new List<>(-2,new List<>(-8,new List<>()))));
		List<Integer> list3 = new List<>(3,new List<>(5,new List<>(0,new List<>(-8,new List<>()))));
		assertTrue(Worksheet1.allPositive(list1));
		assertFalse(Worksheet1.allPositive(list2));
		assertFalse(Worksheet1.allPositive(list3));
	}
	
	//Test for positives
	@Test
	public void test5() {
		List<Integer> list1 = new List<>(7,new List<>(5,new List<>(2,new List<>(8,new List<>()))));
		List<Integer> list2 = new List<>(7,new List<>(5,new List<>(2,new List<>(8,new List<>()))));
		List<Integer> list3 = new List<>(-7,new List<>(-5,new List<>(-2,new List<>(-8,new List<>()))));
		List<Integer> list4 = new List<>();
		List<Integer> list5 = new List<>(3,new List<>(5,new List<>(0,new List<>(-8,new List<>()))));
		List<Integer> list6 = new List<>(3,new List<>(5,new List<>()));
		List<Integer> list7 = new List<>();
		List<Integer> list8 = new List<>();
		assertEquals(Worksheet1.positives(list1),list2);
		assertEquals(Worksheet1.positives(list3),list4);
		assertEquals(Worksheet1.positives(list5),list6);
		assertEquals(Worksheet1.positives(list7),list8);
	}
	
	// Test for sorted
	@Test
	public void test6() {
		List<Integer> list1 = new List<>(7,new List<>(5,new List<>(2,new List<>(8,new List<>()))));
		List<Integer> list2 = new List<>(1,new List<>(5,new List<>(7,new List<>(8,new List<>()))));
		List<Integer> list3 = new List<>(-7,new List<>(5,new List<>(-2,new List<>(8,new List<>()))));
		List<Integer> list4 = new List<>(-7,new List<>(5,new List<>(12,new List<>(18,new List<>()))));
		assertFalse(Worksheet1.sorted(list1));
		assertTrue(Worksheet1.sorted(list2));
		assertFalse(Worksheet1.sorted(list3));
		assertTrue(Worksheet1.sorted(list4));
	}
	
	// Test for merge
	@Test
	public void test7() {
		//Test for non-empty lists
		List<Integer> list1 = new List<>(2,new List<>(5,new List<>(7,new List<>(8,new List<>()))));
		List<Integer> list2 = new List<>(1,new List<>(5,new List<>(7,new List<>(8,new List<>()))));
		List<Integer> list3 = new List<>(1,new List<>(2,new List<>(5,new List<>(5,new List<>(7,new List<>(7,new List<>(8,new List<>(8,new List<>()))))))));
		assertEquals(Worksheet1.merge(list1, list2),list3);
		
		//Test for one empty list
		List<Integer> list4 = new List<>();
		List<Integer> list5 = new List<>(1,new List<>(5,new List<>(7,new List<>(8,new List<>()))));
		List<Integer> list6 = new List<>(1,new List<>(5,new List<>(7,new List<>(8,new List<>()))));
		assertEquals(Worksheet1.merge(list4, list5),list6);
		assertEquals(Worksheet1.merge(list5, list4),list6);
		
		//Test for both empty lists
		List<Integer> list7 = new List<>();
		List<Integer> list8 = new List<>();
		List<Integer> list9 = new List<>();
		assertEquals(Worksheet1.merge(list7,list8),list9);
	}
	
	// Test for removeDuplicates
	@Test
	public void test8() {
		List<Integer> list1 = new List<>(1,new List<>(2,new List<>(3,new List<>(4,new List<>(5,new List<>(6,new List<>(7,new List<>(8,new List<>()))))))));
		List<Integer> list2 = new List<>(1,new List<>(2,new List<>(3,new List<>(4,new List<>(5,new List<>(6,new List<>(7,new List<>(8,new List<>()))))))));
		assertEquals(Worksheet1.removeDuplicates(list1),list2);
		
		List<Integer> list3 = new List<>(1,new List<>(2,new List<>(2,new List<>(2,new List<>(5,new List<>(5,new List<>(8,new List<>(8,new List<>()))))))));
		List<Integer> list4 = new List<>(1,new List<>(2,new List<>(5,new List<>(8,new List<>()))));
		assertEquals(Worksheet1.removeDuplicates(list3),list4);
		
		List<Integer> list5 = new List<>(-10,new List<>(-2,new List<>(-2,new List<>(0,new List<>(0,new List<>(5,new List<>(8,new List<>(8,new List<>()))))))));
		List<Integer> list6 = new List<>(-10,new List<>(-2,new List<>(0,new List<>(5,new List<>(8,new List<>())))));
		assertEquals(Worksheet1.removeDuplicates(list5),list6);
	}
}
