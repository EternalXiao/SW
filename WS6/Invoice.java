/**
 * Invoice implements interface measurable.
 * It is characterised by field variables accountNumber,
 * sortCode and amount.
 */
public class Invoice implements Measurable{
	private String accountNumber;
	private String sortCode;
	private double amount;
	
	/**
	 * Constructor for class Invoice
	 * @param accountNumber the account number of the payment
	 * @param sortCode the sort code of the account
	 * @param amount payment amount
	 */
	public Invoice(String accountNumber, String sortCode, double amount) {
		this.accountNumber = accountNumber;
		this.sortCode = sortCode;
		this.amount = amount;
	}
	
	/**
	 * Getter method for accountNumber
	 * @return the account number
	 */
	public String getAccountNumber() {
		return accountNumber;
	}
	
	/**
	 * Setter method for accountNumber
	 * @param accountNumber the account number to be set
	 */
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	/**
	 * Getter method for sortCode
	 * @return the sort code of the account
	 */
	public String getSortCode() {
		return sortCode;
	}

	/**
	 * Setter method for sortCode
	 * @param sortCode the sort code to be set
	 */
	public void setSortCode(String sortCode) {
		this.sortCode = sortCode;
	}

	/**
	 * Getter method for amount
	 * @return the amount of payment
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * Setter method for amount
	 * @param amount the amount to be set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}

	/**
	 * Implementation of getValue method
	 * @return the amount of payment
	 */
	public double getValue() {
		return this.getAmount();
	}
}
