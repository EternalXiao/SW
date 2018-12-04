package Booking;

public class Main {
	public static void main(String[] args) {
		String[] rooms = {"R217", "R222", "R225", "R245"};
		Date nov22 = new Date(22,"November",2018);
		RoomBooking bookings2018 = new RoomBooking(2018, rooms);
		bookings2018.book("R222", nov22, 12, "Tutor meeting");
		bookings2018.book("R222", nov22, 12, "Java meeting");
		bookings2018.book("R222", nov22, 13, "Interviews");
		bookings2018.book("R245", nov22, 16, "Project meeting");
		bookings2018.book("R225", nov22, 14, "Top-up tutorial");
		//bookings2018.cancel("R222", nov22, 12);
		System.out.println(bookings2018.displayDay(nov22));
		//System.out.println(bookings2018.displayDay(new Date(22,"January",2018)));
	}
}
