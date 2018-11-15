
public class Invoice implements Measurable{
	private String accountNumber;
	private String sortCode;
	private double amount;
	
	public Invoice(String accountNumber, String sortCode, double amount) {
		this.accountNumber = accountNumber;
		this.sortCode = sortCode;
		this.amount = amount;
	}

	public double getValue() {
		return amount;
	}
}
