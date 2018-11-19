public abstract class BankAccountUser implements BankAccountUserInterface{
	private String username;
	private String password;
	private boolean loggedIn;
	
	public BankAccountUser(String username, String password) {
		this.username = username;
		this.password = password;
		this.loggedIn = false;
	}
	
	public void login(String password) {
		if (this.passwordCorrect(password)) this.setLoggedIn(true);
		else this.setLoggedIn(false);
	}

	
	public void logout() {
		this.setLoggedIn(false);
	}
	
	private String getPassword() {
		return this.password;
	}
	
	public boolean passwordCorrect(String password) {
		return this.getPassword().equals(password);
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

