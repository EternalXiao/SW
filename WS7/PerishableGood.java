import java.util.Calendar;

public class PerishableGood extends Good{
	private int bestBeforeDay;

	public PerishableGood(String orderCode, int price, boolean availability, int bestBeforeDay) {
		super(orderCode, price, availability);
		this.bestBeforeDay = bestBeforeDay;
	}

	public int getBestBeforeDay() {
		return bestBeforeDay;
	}

	public void setBestBeforeDay(int bestBeforeDay) {
		this.bestBeforeDay = bestBeforeDay;
	}
	
	public boolean sellable() {
		return (this.getBestBeforeDay() - today()) > 14;
	}
	
	public static int today() {
		Calendar calendar = Calendar.getInstance();
		return calendar.get(Calendar.DAY_OF_YEAR);
	}
	
	public static void main(String[] args) {
		PerishableGood a = new PerishableGood("123",20,true,360);
		System.out.println(PerishableGood.today());
	}
}
 