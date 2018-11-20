/**
 * BankAccountStandardUser is a sub-class of BankAccountUser and 
 * it also implements the interface BankAccountStandardUserInterface.
 * This class has two additional field variables bankAccount and
 * loginAttempts which have a maximum value of 3.
 */
public class BankAccountStandardUser extends BankAccountUser implements BankAccountStandardUserInterface {
	private BankAccount bankAccount;
	private int loginAttempts;
	private static final int MAXIMAL_LOGIN_ATTEMPTS = 3;

	/**
	 * Constructor for class BankAccountStandardUser
	 * @param username username of the user
	 * @param password password of the user
	 * @param bankAccount user's bank account
	 */
	public BankAccountStandardUser(String username, String password, BankAccount bankAccount) {
		super(username, password);
		this.bankAccount = bankAccount;
	}
	
	/**
	 * Getter for bankAccount
	 * @return the bank account of the user
	 */
	public BankAccount getBankAccount() {
		return this.bankAccount;
	}

	/**
	 * Method for users to log in.
	 * Users have three chance before the account to be frozen.
	 * @param password the user entered password
	 */
	public void login(String password) {
		if (this.passwordCorrect(password) && (this.getLoginAttempts() < this.MAXIMAL_LOGIN_ATTEMPTS)) {
			this.resetLoginAttempts();
			this.setLoggedIn(true);
		} else if (this.getLoginAttempts() < this.MAXIMAL_LOGIN_ATTEMPTS) {
			this.setLoggedIn(false);
			this.loginAttempts++;
		}
	}

	/**
	 * Getter for loginAttempts
	 * @return the failed loginAttempts
	 */
	public int getLoginAttempts() {
		return this.loginAttempts;
	}

	/**
	 * Setter for loginAttempts
	 * @param loginAttempts loginAttempts to be set
	 */
	public void setLoginAttempts(int loginAttempts) {
		this.loginAttempts = loginAttempts;
	}

	/**
	 * Method to reset the loginAttempts to 0
	 */
	public void resetLoginAttempts() {
		this.loginAttempts = 0;
	}

	/**
	 * Method to transfer money to a specific bank account
	 * @param toAccount the account to be transferred
	 * @param amount the money to be transferred
	 * @param password the password of this account
	 */
	public void transferMoney(BankAccount toAccount, long amount, String password) {
		if (this.getLoggedIn()) {
			this.getBankAccount().transferMoney(toAccount, amount, password);
		}
	}

	/**
	 * Method for balance printing
	 */
	public void printBalance() {
		this.getBankAccount().printBalance();
	}

	/**
	 * Method for statement printing
	 */
	public void printStatement() {
		this.getBankAccount().printStatement();
	}
}
