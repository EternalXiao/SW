
public class Patient implements Measurable{
	private String name;
	private int age;
	private double weight;
	
	public Patient(String name, int age, double weight) {
		this.name = name;
		this.age = age;
		this.weight = weight;
	}

	public double getValue() {
		return weight;
	}
}
