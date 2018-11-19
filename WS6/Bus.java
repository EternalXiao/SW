/**
 * Bus is a subclass of vehicle.
 * It has an addition field variable fuelConsumption.
 */
public class Bus extends Vehicle{
	private double fuelConsumption;
	
	/**
	 * Construction for class Bus
	 * @param passengerNumber maximum number of passengers for bus
	 * @param maxSpeed maximum speed for bus
	 * @param fuelConsumption the fuel consumption for bus
	 */
	public Bus(int passengerNumber, int maxSpeed, double fuelConsumption) {
		super(passengerNumber, maxSpeed);
		this.fuelConsumption = fuelConsumption;
	}
	
	/**
	 * Getter method for fuelConsumption
	 * @return the fuel consumption for bus
	 */
	public double getFuelConsumption() {
		return this.fuelConsumption;
	}
	
	/**
	 * Setter method for fuelConsumption
	 * @param fuelConsumption the fuel consumption to be set
	 */
	public void setFuelConsumption(double fuelConsumption) {
		this.fuelConsumption = fuelConsumption;
	}
	
	/**
	 * toString method for printing
	 * @return the bus to be represented as a string
	 */
	public String toString() {
		return super.toString() + "Fuel Consumption: " + this.fuelConsumption + "\n";
	}
}
