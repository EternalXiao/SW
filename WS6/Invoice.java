
public class Invoice implements Measurable{
	private String accountNumber;
	private String sortCode;
	private double amount;
	
	public double getValue() {
		return amount;
	}
}
