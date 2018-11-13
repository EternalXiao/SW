
public class Bus extends Vehicle{
	private double fuelConsumption;
	
	public Bus(int passengerNumber, int maxSpeed, double fuelConsumption) {
		super(passengerNumber, maxSpeed);
		this.fuelConsumption = fuelConsumption;
	}
	
	public double getFuelConsumption() {
		return this.fuelConsumption;
	}
	
	public void setFuelConsumption(double fuelConsumption) {
		this.fuelConsumption = fuelConsumption;
	}
	
	public String toString() {
		return super.toString() + "Fuel Consumption: " + this.fuelConsumption + "\n";
	}
	
	public static void main(String[] args) {
		Vehicle a = new Bus(50,100,20.0);
	}
}
