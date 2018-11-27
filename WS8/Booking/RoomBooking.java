package Booking;
import java.util.*;
public class RoomBooking {
	private int year;
	private String[] rooms;
	private Map<Date,String[][]> bookingRecords;
	private static final String[] TIMESLOT = {"9:00","10:00","11:00","12:00","13:00","14:00","15:00","16:00","17:00"};

	public RoomBooking(int year, String[] rooms) {
		this.year = year;
		this.rooms = rooms;
		this.bookingRecords = new HashMap<Date, String[][]>();
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String[] getRooms() {
		return rooms;
	}
	public void setRooms(String[] rooms) {
		this.rooms = rooms;
	}
	
	public Map<Date, String[][]> getBookingRecords() {
		return bookingRecords;
	}
	public void setBookingRecords(Map<Date, String[][]> bookingRecords) {
		this.bookingRecords = bookingRecords;
	}
	public boolean book(String room, Date date, int hour, String purpose) {
		String[][] s = new String[9][this.getRooms().length];
		if(!Arrays.asList(rooms).contains(room) || hour<9 || hour>17) return false;
		if(!this.bookingRecords.containsKey(date)) {
			this.bookingRecords.put(date, s);
			this.bookingRecords.get(date)[hour-9][Arrays.asList(this.getRooms()).indexOf(room)] = purpose;
			return true;
		}
		else if(this.bookingRecords.get(date)[hour-9][Arrays.asList(this.getRooms()).indexOf(room)] == null) {
			this.bookingRecords.get(date)[hour-9][Arrays.asList(this.getRooms()).indexOf(room)] = purpose;
			return true;
		}
		else return false;
	}
	
	public void cancel(String room, Date date, int hour) {
		this.bookingRecords.get(date)[hour-9][Arrays.asList(this.getRooms()).indexOf(room)]=null;
	}
	
	public String displayDay(Date date) {
		if(!this.bookingRecords.containsKey(date)) {
			String[][] str = new String[9][this.getRooms().length];
			this.bookingRecords.put(date, str);
		}
		String empty = "                   |";
		StringBuilder s = new StringBuilder("");
		s.append("                                      "+date.toString()+"\n\n");
		s.append("     |");
		for(String room : this.getRooms()) {
			s.append("       "+room+"        |");
		}
		s.append("\n");
		s.append(splitterGenerator());
		for(int i=0;i<this.bookingRecords.get(date).length;i++) {
			for(int j=0;j<this.bookingRecords.get(date)[i].length;j++) {
				if(j==0) s.append(String.format("%5s|", TIMESLOT[i]));
				if(this.bookingRecords.get(date)[i][j]==null) s.append(empty);
				else s.append(String.format("%19s|", this.bookingRecords.get(date)[i][j]));
			}
			s.append("\n");
			s.append(splitterGenerator());
		}
		return s.toString();
	}
	
	public String splitterGenerator() {
		String splitter1 ="-----+";
		String splitter2 ="-------------------+";
		StringBuilder s = new StringBuilder("");
		s.append(splitter1);
		for(int i=0;i<this.getRooms().length;i++) {
			s.append(splitter2);
		}
		s.append("\n");
		return s.toString();
	}
}
