package Booking;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		//String[] rooms = {"R217", "R222", "R225", "R245"};
		String[] rooms = new String[] { "101", "102", "103" };
		Date nov22 = new Date(22,"November",2018);
		Date may20 = new Date(20,"May",2018);
		RoomBooking bookings2018 = new RoomBooking(2018, rooms);
//		bookings2018.book("R222", nov22, 12, "Tutor meeting");
//		bookings2018.book("R222", nov22, 12, "Java meeting");
//		bookings2018.book("R222", nov22, 13, "Interviews");
//		bookings2018.book("R245", nov22, 16, "Project meeting");
//		bookings2018.book("R225", nov22, 14, "Top-up tutorial");
//		bookings2018.cancel("R222", nov22, 12);
		bookings2018.book("101", may20, 10, "Coding");
		bookings2018.book("102", may20, 12, "Seminar");
		bookings2018.book("103", may20, 17, "Dissertation");
		bookings2018.book("102", may20, 9, "Java Tutorial");
		System.out.println(bookings2018.displayDay(new Date(21,"May",2018)));
		//System.out.println(Arrays.asList(rooms));
		//System.out.println(bookings2018.displayDay(new Date(22,"January",2018)));
	}
}
