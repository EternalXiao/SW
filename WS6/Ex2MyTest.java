import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class Ex2MyTest {

	private Invoice inv1,inv2,inv3;
	private Patient pa1,pa2,pa3;
	public static final double TOLERANCE = 0.00001;
	
	@Before
	public void setUp() {
		inv1 = new Invoice("01","11-12-13",300.5);
		inv2 = new Invoice("02","12-13-14",660.5);
		inv3 = new Invoice("03","13-14-15",106.5);
		pa1 = new Patient("A",30,70.7);
		pa2 = new Patient("B",25,99.9);
		pa3 = new Patient("c",60,66.7);
	}
	
	//Test max for a list of invoice
	@Test
	public void test1() {
		ArrayList<Measurable> invoiceList = new ArrayList<>();
		invoiceList.add(inv1);
		invoiceList.add(inv2);
		invoiceList.add(inv3);

		double expectedMax = 660.5;
		double actualMax = Statistics.maximum(invoiceList);

		assertEquals(expectedMax, actualMax, TOLERANCE);

	}

	//Test max for a list of patient
	@Test
	public void test2() {
		ArrayList<Measurable> patientList = new ArrayList<>();
		patientList.add(pa1);
		patientList.add(pa2);
		patientList.add(pa3);

		double expectedMax = 99.9;
		double actualMax = Statistics.maximum(patientList);

		assertEquals(expectedMax, actualMax, TOLERANCE);
	}
	
	//Test average for a list of invoice
	@Test
	public void test3() {
		ArrayList<Measurable> invoiceList = new ArrayList<>();
		invoiceList.add(inv1);
		invoiceList.add(inv2);
		invoiceList.add(inv3);
		
		double expectedAvg = 355.83333;
		double actualAvg = Statistics.average(invoiceList);

		assertEquals(expectedAvg, actualAvg, TOLERANCE);
	}
	
	//Test average for a list of patient
	@Test
	public void test4() {
		ArrayList<Measurable> patientList = new ArrayList<>();
		patientList.add(pa1);
		patientList.add(pa2);
		patientList.add(pa3);

		double expectedAvg = 79.1;
		double actualAvg = Statistics.average(patientList);

		assertEquals(expectedAvg, actualAvg, TOLERANCE);
	}
	
	//Test standard deviation for a list of invoice
	@Test
	public void test5() {
		ArrayList<Measurable> invoiceList = new ArrayList<>();
		invoiceList.add(inv1);
		invoiceList.add(inv2);
		invoiceList.add(inv3);

		double expectedStd = 281.11444;
		double actualStd = Statistics.standardDeviation(invoiceList);

		assertEquals(expectedStd, actualStd, TOLERANCE);
	}
	
	//Test standard deviation for a list of patient
	@Test
	public void test6() {
		ArrayList<Measurable> patientList = new ArrayList<>();
		patientList.add(pa1);
		patientList.add(pa2);
		patientList.add(pa3);

		double expectedStd = 18.12401;
		double actualStd = Statistics.standardDeviation(patientList);

		assertEquals(expectedStd, actualStd, TOLERANCE);
	}
	
	//Test statistics for one invoice and patient
	@Test
	public void test7() {
		ArrayList<Measurable> invoiceList = new ArrayList<>();
		invoiceList.add(inv1);
		double expectedMaxInv = 300.5;
		double actualMaxInv = Statistics.maximum(invoiceList);
		
		assertEquals(expectedMaxInv, actualMaxInv, TOLERANCE);
		
		double expectedAvgInv = 300.5;
		double actualAvgInv = Statistics.average(invoiceList);
		assertEquals(expectedAvgInv, actualAvgInv, TOLERANCE);

		double expectedStdInv = Double.NaN;
		double actualStdInv = Statistics.standardDeviation(invoiceList);
		assertEquals(expectedStdInv, actualStdInv, TOLERANCE);
		
		ArrayList<Measurable> patientList = new ArrayList<>();
		patientList.add(pa1);

		double expectedMaxPa = 70.7;
		double actualMaxPa = Statistics.maximum(patientList);

		assertEquals(expectedMaxPa, actualMaxPa, TOLERANCE);
		
		double expectedAvgPa = 70.7;
		double actualAvgPa = Statistics.average(patientList);
		assertEquals(expectedAvgPa, actualAvgPa, TOLERANCE);

		double expectedStdPa = Double.NaN;
		double actualStdPa = Statistics.standardDeviation(patientList);
		assertEquals(expectedStdPa, actualStdPa, TOLERANCE);
	}
	
	//Test statistics with identical values
	@Test
	public void test8() {
		inv1.setAmount(3000.5);
		inv2.setAmount(3000.5);
		inv3.setAmount(3000.5);
		ArrayList<Measurable> invoiceList = new ArrayList<>();
		invoiceList.add(inv1);
		invoiceList.add(inv2);
		invoiceList.add(inv3);
		
		double expectedMax = 3000.5;
		double actualMax = Statistics.maximum(invoiceList);
		
		assertEquals(expectedMax, actualMax, TOLERANCE);
		
		double expectedAvg = 3000.5;
		double actualAvg = Statistics.average(invoiceList);
		assertEquals(expectedAvg, actualAvg, TOLERANCE);

		double expectedStd = 0;
		double actualStd = Statistics.standardDeviation(invoiceList);
		assertEquals(expectedStd, actualStd, TOLERANCE);
	}
	
}
