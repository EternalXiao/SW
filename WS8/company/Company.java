/**
 * Company is a class characterised by a field variable
 * employees which is an arraylist of type Employee.
 */

package company;

import java.util.ArrayList;

public class Company {
	private ArrayList<Employee> employees;

	/**
	 * Constructor for class Company
	 * @param employees a list of employees
	 */
	public Company(ArrayList<Employee> employees) {
		this.employees = employees;
	}
	
	/**
	 * Getter method for employees
	 * @return the list of employees
	 */
	public ArrayList<Employee> getEmployees() {
		return this.employees;
	}

	/**
	 * Setter method for employees
	 * @param employees the new list of employees to be set
	 */
	public void setEmployees(ArrayList<Employee> employees) {
		this.employees = employees;
	}
	
	/**
	 * Method to increase the salaries of employees in the list
	 * by the given rate
	 * @param rate the increase rate for salary
	 */
	public void increaseSalaries(double rate) {
		for(Employee e:employees) {
			e.increaseSalary(rate);
		}
	}
}
