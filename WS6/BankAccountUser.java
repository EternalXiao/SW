public abstract class BankAccountUser implements BankAccountUserInterface{
	private String username;
	private String password;
	private boolean loggedIn;
	
	public BankAccountUser(String username, String password) {
		this.username = username;
		this.password = password;
		this.loggedIn = false;
	}
	
	public abstract void login(String password) ;

	
	public void logout() {
		this.setLoggedIn(false);
	}
	
	private String getPassword() {
		return this.password;
	}
	
	public boolean passwordCorrect(String password) {
		return this.password.equals(password);
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	
	public boolean getLoggedIn() {
		return this.loggedIn;
	}
	
	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	

}

