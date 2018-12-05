package Booking;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class Ex3MyTest {
	private Date may20;
	private RoomBooking booking;
	private String[] rooms;

	@Before
	public void setUp() {
		may20 = new Date(20, "May", 2018);
		rooms = new String[] { "101", "102", "103" };
		booking = new RoomBooking(2018, rooms);
	}

	// Test for valid booking
	@Test
	public void test1() {
		assertTrue(booking.book("101", may20, 10, "Coding"));
		assertTrue(booking.book("102", may20, 12, "Seminar"));
		assertTrue(booking.book("103", may20, 17, "Dissertation"));
		assertTrue(booking.book("102", may20, 9, "Java Tutorial"));
	}

	// Test for some invalid booking
	@Test
	public void test2() {
		// Invalid room
		assertFalse(booking.book("105", may20, 10, "Coding"));
		// Invalid date (different year with booking)
		assertFalse(booking.book("103", new Date(2, "May", 2017), 12, "Seminar"));
		// Invalid hour
		assertFalse(booking.book("101", may20, 8, "Dissertation"));
		// Previous booked slot
		booking.book("103", may20, 10, "Java Class Test");
		assertFalse(booking.book("103", may20, 10, "Java Tutorial"));
	}

	// Test for cancelling booking
	@Test
	public void test3() {
		booking.book("103", may20, 10, "Java Class Test");
		String expected1 = "Java Class Test";
		String actual1 = booking.getBookingRecords().get(may20)[1][Arrays.asList(rooms).indexOf("103")];

		assertEquals(expected1, actual1);

		booking.cancel("103", may20, 10);
		String expected2 = null;
		String actual2 = booking.getBookingRecords().get(may20)[1][Arrays.asList(rooms).indexOf("103")];

		assertEquals(expected2, actual2);
	}

	// Test for cancelling a booking does not exist
	@Test
	public void test4() {
		booking.book("103", may20, 10, "Java Class Test");
		// Test whether room103 on may20 at 12 had been booked before
		String expected1 = null;
		String actual1 = booking.getBookingRecords().get(may20)[3][Arrays.asList(rooms).indexOf("103")];

		assertEquals(expected1, actual1);

		// Try to cancel booking on may20 at 12 of room103
		booking.cancel("103", may20, 12);

		String expected2 = null;
		String actual2 = booking.getBookingRecords().get(may20)[3][Arrays.asList(rooms).indexOf("103")];

		assertEquals(expected2, actual2);
	}

	// Test for displayDate
	@Test
	public void test5() {
		booking.book("101", may20, 10, "Coding");
		booking.book("102", may20, 12, "Seminar");
		booking.book("103", may20, 17, "Dissertation");
		booking.book("102", may20, 9, "Java Tutorial");
		
		String expected = "                           20 May 2018                            \n" + 
						"\n" + 
						"     |        101        |        102        |        103        |\n" + 
						"-----+-------------------+-------------------+-------------------+\n" + 
						" 9:00|                   |   Java Tutorial   |                   |\n" + 
						"-----+-------------------+-------------------+-------------------+\n" + 
						"10:00|      Coding       |                   |                   |\n" + 
						"-----+-------------------+-------------------+-------------------+\n" + 
						"11:00|                   |                   |                   |\n" + 
						"-----+-------------------+-------------------+-------------------+\n" + 
						"12:00|                   |      Seminar      |                   |\n" + 
						"-----+-------------------+-------------------+-------------------+\n" + 
						"13:00|                   |                   |                   |\n" + 
						"-----+-------------------+-------------------+-------------------+\n" + 
						"14:00|                   |                   |                   |\n" + 
						"-----+-------------------+-------------------+-------------------+\n" + 
						"15:00|                   |                   |                   |\n" + 
						"-----+-------------------+-------------------+-------------------+\n" + 
						"16:00|                   |                   |                   |\n" + 
						"-----+-------------------+-------------------+-------------------+\n" + 
						"17:00|                   |                   |   Dissertation    |\n" + 
						"-----+-------------------+-------------------+-------------------+\n";
		
		String actual = booking.displayDay(may20);
		
		assertEquals(expected,actual);
	}
	
	//Test for displayDate without previous booking
	@Test
	public void test6() {
		Date may21 = new Date(21,"May",2018);
		String expected = "                           21 May 2018                            \n" + 
						"\n" + 
						"     |        101        |        102        |        103        |\n" + 
						"-----+-------------------+-------------------+-------------------+\n" + 
						" 9:00|                   |                   |                   |\n" + 
						"-----+-------------------+-------------------+-------------------+\n" + 
						"10:00|                   |                   |                   |\n" + 
						"-----+-------------------+-------------------+-------------------+\n" + 
						"11:00|                   |                   |                   |\n" + 
						"-----+-------------------+-------------------+-------------------+\n" + 
						"12:00|                   |                   |                   |\n" + 
						"-----+-------------------+-------------------+-------------------+\n" + 
						"13:00|                   |                   |                   |\n" + 
						"-----+-------------------+-------------------+-------------------+\n" + 
						"14:00|                   |                   |                   |\n" + 
						"-----+-------------------+-------------------+-------------------+\n" + 
						"15:00|                   |                   |                   |\n" + 
						"-----+-------------------+-------------------+-------------------+\n" + 
						"16:00|                   |                   |                   |\n" + 
						"-----+-------------------+-------------------+-------------------+\n" + 
						"17:00|                   |                   |                   |\n" + 
						"-----+-------------------+-------------------+-------------------+\n";
		String actual = booking.displayDay(may21);
		
		assertEquals(expected,actual);
	}
}
