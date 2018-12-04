package Booking;
/**
 *   The Date class here is used to pick up on the simpler Date class
 *   from week 2 in order to show how we can restrict the creation of
 *   dates to admissible dates. To this end we write a method
 *   admissible which checks whether inputs of the constructor form a
 *   valid date. If not on constuction an IllegalArgumentException is
 *   thrown. Note that we have not dealt with the setters here, they
 *   would need corresponding checks.
 *   
 *   @version 2018-10-21
 *   @author Manfred Kerber
 */
public class Date {

    /**
     * Three field variables for day, month, and year of types int,
     * String and int, respectively.
     */
    private int day;
    private String month;
    private int year;
    
    public int getYear() {
		return year;
	}

	/**
     *  @param day The input of a day such as 21 as an int.
     *  @param month The input of a month such as "October" as a String.
     *  @param year The input of a year such as 2016 as an int.
     *  @return true if the day, the month, and the year are all admissible
     *  THIS IS A METHOD STUB. THE METHOD NEEDS STILL TO BE WRITTEN!
     */
    public static boolean admissible(int day, String month, int year) {
    	int monNum, daysNum = 0;
    	switch (month) {
    	case "January":
    		monNum = 1;
    		daysNum = 31;
    		break;
    	case "February":
    		monNum = 2;
    		if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
    			daysNum = 29;
    		}
    		else {
    			daysNum = 28;
    		}
    		break;
    	case "March":
    		monNum = 3;
    		daysNum = 31;
    		break;
    	case "April":
    		monNum = 4;
    		daysNum = 30;
    		break;
    	case "May":
    		monNum = 5;
    		daysNum = 31;
    		break;
    	case "June":
    		monNum = 6;
    		daysNum = 30;
    		break;
    	case "July":
    		monNum = 7;
    		daysNum = 31;
    		break;
    	case "August":
    		monNum = 8;
    		daysNum = 31;
    		break;
    	case "September":
    		monNum = 9;
    		daysNum = 30;
    		break;
    	case "October":
    		monNum = 10;
    		daysNum = 31;
    		break;
    	case "November":
    		monNum = 11;
    		daysNum = 30;
    		break;
    	case "December":
    		monNum = 12;
    		daysNum = 31;
    		break;
    	default:
    		monNum = -1;
    		break;
    	}
        if (year > 0 && monNum != -1 && day <= daysNum) {
        	return true;
        }
        else {
        	return false;
        }
    }

    public String toString() {
        return this.day + " " + this.month + " " + this.year;
    }

    /**
     *  @param day The input of a day such as 21 as an int.
     *  @param month The input of a month such as "October" as a String.
     *  @param year The input of a year such as 2018 as an int.
     *  Note that the constructor throws an IllegalArgumentException if
     *  the date to be constructed would be not admissible.
     */
    public Date(int day, String month, int year) {
    	if (admissible(day,month,year)) {
            this.day = day;
            this.month = month;
            this.year = year;
    	}
    	else {
    		throw new IllegalArgumentException("Invalid date in class Date.");
    	}
    }
    
    @Override
    public boolean equals(Object object) {
    	if(object==null || !(object instanceof Date)) return false;
    	if(this ==object) return true;
    	Date date = (Date) object;
    	return date.day==this.day && date.month.equals(this.month);
    }
    
    @Override
    public int hashCode() {
    	return this.month.hashCode();
    }
	
    public static void main(String[] args) {
        Date d1 = new Date(26, "October", 2018);
        System.out.println(d1);
        Date d2 = new Date(32, "October", 2018);
        System.out.println(d2);
        Date d3 = new Date(20, "Friday", 2018);
        System.out.println(d3);
    }
}
