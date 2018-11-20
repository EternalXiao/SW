/**
 * Patient implements measurable interface.
 * It is characterised by field variables name,
 * age and weight.
 */
public class Patient implements Measurable{
	private String name;
	private int age;
	private double weight;
	
	/**
	 * Constructor for class Patient
	 * @param name the name of patient
	 * @param age the age of patient
	 * @param weight the weight of patient
	 */
	public Patient(String name, int age, double weight) {
		this.name = name;
		this.age = age;
		this.weight = weight;
	}

	/**
	 * Getter method for name
	 * @return the patient name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter method for name
	 * @param name the patient name to be set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Getter method for age
	 * @return the patient age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Setter method for age
	 * @param age the patient age to be set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
	/**
	 * Getter method for weight
	 * @return the patient weight
	 */
	public double getWeight() {
		return weight;
	}

	/**
	 * Setter method for weight
	 * @param weight the patient weight to be set
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	/**
	 * implementation for getValue method
	 * @return the weight of patient
	 */
	public double getValue() {
		return weight;
	}
}
