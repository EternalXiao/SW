
public class BankAccountStandardUser extends BankAccountUser implements BankAccountStandardUserInterface{
	private BankAccount bankAccount;
	private int loginAttempts;
	private static final int MAXIMAL_LOGIN_ATTEMPTS = 3;
	
	public BankAccountStandardUser(String username, String password, BankAccount bankAccount)
	{
		super(username, password);
		this.bankAccount = bankAccount;
	}
	
	public BankAccount getBankAccount() {
		return this.bankAccount;
	}
	
	public void login(String password) {
		if (this.passwordCorrect(password) && (this.getLoginAttempts() < this.MAXIMAL_LOGIN_ATTEMPTS)) {
			this.resetLoginAttempts();
			this.setLoggedIn(true);
		}
		else if (this.getLoginAttempts() < this.MAXIMAL_LOGIN_ATTEMPTS){
			this.setLoggedIn(false);
			this.loginAttempts++;
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
