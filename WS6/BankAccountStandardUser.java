
public class BankAccountStandardUser extends BankAccountUser implements BankAccountStandardUserInterface{
	private String username;
	private String password;
	private boolean loggedIn;
	private BankAccount bankAccount;
	private int loginAttempts;
	private static final int MAXIMAL_LOGIN_ATTEMPTS = 3;
	
	public BankAccountStandardUser(String username, String password)
	{
		this.username = username;
		this.password = password;
	}
	
	public BankAccount getBankAccount() {
		return this.bankAccount;
	}
	
	public void login(String password) {
		if (this.getBankAccount().checkPassword(password) && (this.loginAttempts < this.MAXIMAL_LOGIN_ATTEMPTS)) {
			this.resetLoginAttempts();
			
		}
	}
	
	public int getLoginAttempts() {
		return this.loginAttempts;
	}
	
	public void setLoginAttempts(int loginAttempts) {
		this.loginAttempts = loginAttempts;
	}
	
	public void resetLoginAttempts() {
		this.loginAttempts = 0;
	}
	
	public void transferMoney(BankAccount toAccount, long amount, String password) {
		this.getBankAccount().transferMoney(toAccount, amount, password);
	}
	
	public void printBalance() {
		this.getBankAccount().printBalance();
	}
	
	public void printStatement() {
		this.getBankAccount().printStatement();
	}
}
