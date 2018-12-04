/**
 * RoomBooking is a class characterised by four field variables:
 * <pre>
 *  year, the year for booking
 *  rooms, an string array of rooms that can be booked
 *  bookingRecords, a hashmap stores the timetable for corresponding date
 *  TIMESOLT, an constant string array to stores the valid timeslot for booking
 * </pre>
 */

package Booking;

import java.util.*;

public class RoomBooking {
	private int year;
	private String[] rooms;
	private Map<Date, String[][]> bookingRecords;
	private static final String[] TIMESLOT = { "9:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00",
			"17:00" };

	/**
	 * Constructor for class RoomBooking
	 * 
	 * @param year  the year for booking
	 * @param rooms a list of rooms can be booked
	 */
	public RoomBooking(int year, String[] rooms) {
		this.year = year;
		this.rooms = rooms;
		this.bookingRecords = new HashMap<Date, String[][]>();
	}

	/**
	 * Getter method for year
	 * 
	 * @return the booking year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * Setter method for year
	 * 
	 * @param year new booking year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * Getter method for the list of rooms
	 * 
	 * @return the array of room can be booked
	 */
	public String[] getRooms() {
		return rooms;
	}

	/**
	 * Setter method for list of rooms
	 * 
	 * @param rooms new list of rooms can be booked
	 */
	public void setRooms(String[] rooms) {
		this.rooms = rooms;
	}

	/**
	 * Getter method for bookingRecords
	 * 
	 * @return the bookingRecords
	 */
	public Map<Date, String[][]> getBookingRecords() {
		return bookingRecords;
	}

	/**
	 * Setter method for bookingRecords
	 * 
	 * @param bookingRecords new bookingRecords to be set
	 */
	public void setBookingRecords(Map<Date, String[][]> bookingRecords) {
		this.bookingRecords = bookingRecords;
	}

	/**
	 * Method to book a room at a specific time, if booking succeeds, return true,
	 * otherwise false
	 * 
	 * @param room    the room want to book
	 * @param date    the booking date
	 * @param hour    the booking hour
	 * @param purpose the purpose for booking
	 * @return true if successful, else false
	 */
	public boolean book(String room, Date date, int hour, String purpose) {
		if (!Arrays.asList(rooms).contains(room) || hour < 9 || hour > 17 || date.getYear() != this.year)
			return false;
		if (!this.bookingRecords.containsKey(date)) {
			this.bookingRecords.put(date, new String[9][this.getRooms().length]);
			this.bookingRecords.get(date)[hour - 9][Arrays.asList(this.getRooms()).indexOf(room)] = purpose;
			return true;
		} else if (this.bookingRecords.get(date)[hour - 9][Arrays.asList(this.getRooms()).indexOf(room)] == null) {
			this.bookingRecords.get(date)[hour - 9][Arrays.asList(this.getRooms()).indexOf(room)] = purpose;
			return true;
		} else
			return false;
	}

	/**
	 * Method to cancel previous booking
	 * 
	 * @param room the previous booking room
	 * @param date the previous booking date
	 * @param hour the previous booking hour
	 */
	public void cancel(String room, Date date, int hour) {
		if (this.getBookingRecords().containsKey(date)) {
			this.bookingRecords.get(date)[hour - 9][Arrays.asList(this.getRooms()).indexOf(room)] = null;
		}
	}

	/**
	 * Method to display the timetable for a given date
	 * 
	 * @param date the date for printing timetable
	 * @return a string representing the timetable
	 */
	public String displayDay(Date date) {
		if (!this.bookingRecords.containsKey(date)) {
			this.bookingRecords.put(date, new String[9][this.getRooms().length]);
		}
		String empty = "                   |";
		StringBuilder s = new StringBuilder("");
		s.append(stringCentre(date.toString(), 6 + 20 * this.getRooms().length) + "\n\n     |");
		for (String room : this.getRooms()) {
			s.append(stringCentre(room, 19) + "|");
		}
		s.append("\n" + splitterGenerator());
		for (int i = 0; i < this.bookingRecords.get(date).length; i++) {
			for (int j = 0; j < this.bookingRecords.get(date)[i].length; j++) {
				if (j == 0)
					s.append(String.format("%5s|", TIMESLOT[i]));
				if (this.bookingRecords.get(date)[i][j] == null)
					s.append(empty);
				else
					s.append(stringCentre(this.bookingRecords.get(date)[i][j], 19) + "|");
			}
			s.append("\n" + splitterGenerator());
		}
		return s.toString();
	}

	/**
	 * Method to generate a line splitter
	 * 
	 * @return a string of splitter
	 */
	public String splitterGenerator() {
		String splitter1 = "-----+";
		String splitter2 = "-------------------+";
		StringBuilder s = new StringBuilder("");
		s.append(splitter1);
		for (int i = 0; i < this.getRooms().length; i++) {
			s.append(splitter2);
		}
		s.append("\n");
		return s.toString();
	}

	/**
	 * Method to centre a string with given length
	 * 
	 * @param s   the string to be centred
	 * @param len the total length
	 * @return the centred string
	 */
	public String stringCentre(String s, int len) {
		int left, right;
		left = (len - s.length()) / 2;
		right = len - s.length() - left;
		char[] spaceLeft = new char[left];
		char[] spaceRight = new char[right];
		Arrays.fill(spaceLeft, ' ');
		Arrays.fill(spaceRight, ' ');
		return (new String(spaceLeft)) + s + (new String(spaceRight));
	}
}
