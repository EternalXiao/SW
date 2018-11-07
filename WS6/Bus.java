
public class Bus extends Vehicle{
	private int passengerNumber;
	private int maxSpeed;
	private double fuelConsumption;
	
	public Bus(int passengerNumber, int maxSpeed, double fuelConsumption) {
		super(passengerNumber, maxSpeed);
		this.fuelConsumption = fuelConsumption;
	}
	
	public double getFuelConsumption() {
		return this.fuelConsumption;
	}
	
	public String shout() {
		return "BUS";
	}
	
	public void setFuelConsumption(double fuelConsumption) {
		this.fuelConsumption = fuelConsumption;
	}
	
	public String toString() {
		return super.toString() + "Fuel Consumption: " + this.fuelConsumption + "\n";
	}
	
	public static void main(String[] args) {
		Vehicle a = new Bus(50,100,20.0);
		Bus a1 = (Bus)a;
		System.out.println(a1.shout());
	}
}
