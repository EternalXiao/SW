package company;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class Ex1MyTest {
	public static final double TOLERANCE = 0.00001;
	private Employee HE,ME;
	private Company company;
	
	@Before
	public void setUp() {
		HE = new HourlyEmployee("A","H","1",200.2);
		ME = new MonthlyEmployee("A","M","3",15000.3);
		ArrayList<Employee> employees = new ArrayList<>();
		employees.add(HE);
		employees.add(ME);
		company = new Company(employees);
	}
	
	//Test the increase salary for company with positive rate
	@Test
	public void test1() {
		company.increaseSalaries(3);
		double expectedSalaryH = 206.206;
		double expectedSalaryM = 15450.309;
		double actualSalaryH = ((HourlyEmployee)HE).getHourlySalary();
		double actualSalaryM = ((MonthlyEmployee)ME).getMonthlySalary();
		
		assertEquals(expectedSalaryH,actualSalaryH,TOLERANCE);
		assertEquals(expectedSalaryM,actualSalaryM,TOLERANCE);
	}
	
	//Test the increase salary for company with zero rate
	@Test
	public void test2() {
		company.increaseSalaries(0);
		double expectedSalaryH = 200.2;
		double expectedSalaryM = 15000.3;
		double actualSalaryH = ((HourlyEmployee)HE).getHourlySalary();
		double actualSalaryM = ((MonthlyEmployee)ME).getMonthlySalary();
		
		assertEquals(expectedSalaryH,actualSalaryH,TOLERANCE);
		assertEquals(expectedSalaryM,actualSalaryM,TOLERANCE);
	}
	
	//Test the increase salary for company with negative rate
	@Test
	public void test3() {
		company.increaseSalaries(-2.5);
		double expectedSalaryH = 195.195;
		double expectedSalaryM = 14625.2925;
		double actualSalaryH = ((HourlyEmployee)HE).getHourlySalary();
		double actualSalaryM = ((MonthlyEmployee)ME).getMonthlySalary();
		
		assertEquals(expectedSalaryH,actualSalaryH,TOLERANCE);
		assertEquals(expectedSalaryM,actualSalaryM,TOLERANCE);
		
	}
}
