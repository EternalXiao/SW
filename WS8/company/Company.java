package company;

import java.util.ArrayList;

public class Company {
	private ArrayList<Employee> employees;


	public ArrayList<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(ArrayList<Employee> employees) {
		this.employees = employees;
	}
	
	public void increaseSalaries(double rate) {
		for(Employee e:employees) {
			e.increaseSalary(rate);
		}
	}
}
