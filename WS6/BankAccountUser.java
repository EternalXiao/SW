public abstract class BankAccountUser implements BankAccountUserInterface{
	private String username;
	private String password;
	private boolean loggedIn;
	
	public BankAccountUser(String username, String password) {
		this.username = username;
		this.password = password;
		this.loggedIn = loggedIn;
	}
	
	public void login(String password) {
		this.loggedIn = passwordCorrect(password);
	}
	
	public void logout() {
		this.loggedIn = false;
	}
	
	public abstract boolean passwordCorrect(String password) ;
	
	public abstract void setPassword(String password);

	
	public boolean getLoggedIn() {
		return this.loggedIn;
	}
	
	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	

}

