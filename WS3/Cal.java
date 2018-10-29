import java.util.ArrayList;

public class Cal {
	public static void cal(int year, int firstDay, boolean leapYear) {
		String yearString = "                                 "+year+"                                 ";
		if (leapYear) {
			int[] totalDaysInOneMonth = {31,29,31,30,31,30,31,31,30,31,30,31};
		}
		else {
			int[] totalDaysInOneMonth = {31,28,31,30,31,30,31,31,30,31,30,31};
		}
		int[] firstDayInMonth = new int[12];
		int[][][] calendar = new int[12][6][7];
		
	}
	
	public void calFirstDayInMonth(int[] firstDayInMonth,int[] totalDays,int firstDay) {
		firstDayInMonth[0] = firstDay;
		int i;
		for (i = 1; i < firstDayInMonth.length; i++) {
			firstDayInMonth[i] = (firstDayInMonth[i-1] + totalDays[i-1]%7)%7;
		}
	}
	
	public void fillCalendar(int[][][] calendar, int[] firstDay, int[] totalDays) {
		int i,j,k,count = 0;
		for (i=0; i < 12; i++) {
			for (j= 0; j< 6; j++) {
				for (k = 0; k < 7; k++) {
					if (j==0 && )
				}
			}
		}
	}
}
