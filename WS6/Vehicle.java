
public class Vehicle {
	private int passengerNumber;
	private int maxSpeed;
	
	public Vehicle(int passengerNumber, int maxSpeed) {
		this.passengerNumber = passengerNumber;
		this.maxSpeed = maxSpeed;
	}
	
	public int getPassengerNumber() {
		return this.passengerNumber;
	}
	
	public int getMaxSpeed() {
		return this.maxSpeed;
	}
	
	public void setPassengerNumber(int passengerNumber) {
		this.passengerNumber = passengerNumber;
	}
	
	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	
	public String toString() {
		return "Passenger Number: " + passengerNumber +"\n" +
				"Max Speed: " + maxSpeed + "\n";
	}
	
	
}
