/**
 * A vehicle is characterised by the field passengerNumber
 * and maxSpeed.
 */
public class Vehicle {
	private int passengerNumber;
	private int maxSpeed;
	
	/**
	 * Construction for class Vehicle
	 * @param passengerNumber the maximum number of passengers the vehicle can hold
	 * @param maxSpeed the maximum speed of the vehicle
	 */
	public Vehicle(int passengerNumber, int maxSpeed) {
		this.passengerNumber = passengerNumber;
		this.maxSpeed = maxSpeed;
	}
	
	/**
	 * Getter method for passengerNumber
	 * @return the maximum passenger number of the vehicle
	 */
	public int getPassengerNumber() {
		return this.passengerNumber;
	}
	
	/**
	 * Getter method for maxSpeed
	 * @return the maximum speed of the vehicle
	 */
	public int getMaxSpeed() {
		return this.maxSpeed;
	}
	
	/**
	 * Setter method for passengerNumber
	 * @param passengerNumber the passenger number to be set
	 */
	public void setPassengerNumber(int passengerNumber) {
		this.passengerNumber = passengerNumber;
	}
	
	/**
	 * Setter method for maxSpeed
	 * @param maxSpeed the maximum speed of vehicle to be set
	 */
	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	
	/**
	 * toString method for printing
	 * @return the vehicle to be represented as a string
	 */
	public String toString() {
		return "Passenger Number: " + passengerNumber +"\n" +
				"Max Speed: " + maxSpeed + "\n";
	}
	
	
}
