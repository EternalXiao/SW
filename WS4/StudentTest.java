import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class StudentTest {
	
	private Student a;
	private Student b;
	private Student c;
	private Student d;
	private int[] aMarks = {60,60,60,60,60,60,60,60,60,60,-1,60,60,70};
	private int[] bMarks = {80,80,80,80,80,80,80,80,80,80,80,80,80,90};
	private int[] cMarks = {30,80,66,77,58,90,75,-1,63,20,35,99,50,20};
	private int[] dMarks = {60,60,60,60,60,60,60,60,60,60,60,60,60,-1};
	

	private static final double TOLERENCE = 0.00001;
	
	@Before
	public void setup() {
		a = new Student("1",aMarks);
		b = new Student("2",bMarks);
		c = new Student("3",cMarks);
		d = new Student("4",dMarks);
	}
	
	//Test for getters
	@Test
	public void test1() {
		String expectedARegistrationNumber = "1";
		String expectedBRegistrationNumber = "2";
		int[] expectedAMarks = {60,60,60,60,60,60,60,60,60,60,-1,60,60,70};
		int[] expectedBMarks = {80,80,80,80,80,80,80,80,80,80,80,80,80,90};
		
		assertEquals(expectedARegistrationNumber, a.getRegistrationNumber());
		assertEquals(expectedBRegistrationNumber, b.getRegistrationNumber());
		assertTrue(Arrays.equals(expectedAMarks, a.getMarks()));
		assertTrue(Arrays.equals(expectedBMarks, b.getMarks()));
	}
	
	//Test for setters
	@Test
	public void test2() {
		String expectedARegistrationNumber = "10";
		String expectedBRegistrationNumber = "20";
		int[] expectedAMarks = {30,80,66,77,58,90,75,-1,63,20,35,99,50,77};
		int[] expectedBMarks = {60,60,60,60,60,60,60,60,60,60,60,60,60,-1};
		a.setRegistrationNumber("10");
		b.setRegistrationNumber("20");
		a.setMarks(new int[] {30,80,66,77,58,90,75,-1,63,20,35,99,50,77});
		b.setMarks(new int[] {60,60,60,60,60,60,60,60,60,60,60,60,60,-1});
		
		assertEquals(expectedARegistrationNumber, a.getRegistrationNumber());
		assertEquals(expectedBRegistrationNumber, b.getRegistrationNumber());
		assertTrue(Arrays.equals(expectedAMarks, a.getMarks()));
		assertTrue(Arrays.equals(expectedBMarks, b.getMarks()));
	}
	
	//Test for setAssignmentMark
	@Test
	public void test3() {
		int[] expectedAMarks = {60,60,100,60,60,60,60,60,60,60,-1,60,60,70};
		int[] expectedBMarks = {80,80,80,80,80,90,80,80,80,80,80,80,80,90};
		a.setAssignmentMark(3, 100);
		b.setAssignmentMark(6, 90);
		
		assertTrue(Arrays.equals(expectedAMarks, a.getMarks()));
		assertTrue(Arrays.equals(expectedBMarks, b.getMarks()));
	}
	
	//Test for totalMark
	@Test
	public void test4() {
		double expectedATotalMark = 67.1;
		double expectedBTotalMark = 87.0;
		
		assertEquals(expectedATotalMark, a.totalMark(),TOLERENCE);
		assertEquals(expectedBTotalMark, b.totalMark(),TOLERENCE);
	}
	
	//Test for passed
	@Test
	public void test5() {
		assertTrue(a.passed());
		assertTrue(b.passed());
		assertFalse(c.passed());
	}
	
	//Test for totalMark with insufficient mark
	@Test
	public void test6() {
		double expectedTotalMark = -1;
		
		assertEquals(expectedTotalMark, d.totalMark(),TOLERENCE);
	}
	
	//Test for passed with insufficient mark
	@Test(expected = IllegalArgumentException.class)
	public void test7() {
		d.passed();
	}

}
