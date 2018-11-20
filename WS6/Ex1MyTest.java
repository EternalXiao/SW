import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Ex1MyTest {
	private Vehicle vehicle;
	private Bus bus;
	private static final double TOLERANCE = 0.00001;
			
	@Before
	public void setUp() {
		vehicle = new Vehicle(5,200);
		bus = new Bus(150,100,33.3);
	}

	//Test getters for vehicle
	@Test
	public void test1() {
		int expectedNumOfPassengers = 5;
		int actualNumOfPassengers = vehicle.getPassengerNumber();
		assertEquals(expectedNumOfPassengers,actualNumOfPassengers);
	
		int expectedMaxSpeed = 200;
		int actualMaxSpeed = vehicle.getMaxSpeed();
		assertEquals(expectedMaxSpeed,actualMaxSpeed);
	}
	
	//Test setters for vehicle
	@Test
	public void test2() {
		
		vehicle.setPassengerNumber(7);
		int expectedNumOfPassengers = 7;
		int actualNumOfPassengers = vehicle.getPassengerNumber();
		assertEquals(expectedNumOfPassengers,actualNumOfPassengers);
	
		vehicle.setMaxSpeed(160);
		int expectedMaxSpeed = 160;
		int actualMaxSpeed = vehicle.getMaxSpeed();
		assertEquals(expectedMaxSpeed,actualMaxSpeed);
	}
	
	//Test getters for bus
	@Test
	public void test3() {
		
		int expectedNumOfPassengers = 150;
		int actualNumOfPassengers = bus.getPassengerNumber();
		assertEquals(expectedNumOfPassengers,actualNumOfPassengers);
	
		int expectedMaxSpeed = 100;
		int actualMaxSpeed = bus.getMaxSpeed();
		assertEquals(expectedMaxSpeed,actualMaxSpeed);
		
		double expectedFuelCons = 33.3;
		double actualFuelCons = bus.getFuelConsumption();
		assertEquals(expectedFuelCons,actualFuelCons,TOLERANCE);
	}
	
	//Test setters for bus
	@Test
	public void test4() {
		
		bus.setPassengerNumber(50);
		int expectedNumOfPassengers = 50;
		int actualNumOfPassengers = bus.getPassengerNumber();
		assertEquals(expectedNumOfPassengers,actualNumOfPassengers);
	
		bus.setMaxSpeed(120);
		int expectedMaxSpeed = 120;
		int actualMaxSpeed = bus.getMaxSpeed();
		assertEquals(expectedMaxSpeed,actualMaxSpeed);
		
		
		bus.setFuelConsumption(55.2);
		double expectedFuelCons = 55.2;
		double actualFuelCons = bus.getFuelConsumption();
		assertEquals(expectedFuelCons,actualFuelCons,TOLERANCE);
	}

}
