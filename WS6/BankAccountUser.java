public abstract class BankAccountUser implements BankAccountUserInterface{
	private String username;
	private String password;
	private boolean loggedIn;
	
	public void login(String password) {
		this.loggedIn = passwordCorrect(password);
	}
	
	public void logout() {
		this.loggedIn = false;
	}
	
	public boolean passwordCorrect(String password) {
		if (password.equals(this.password)) {
			return true;
		}
		else {
			return false;
		}
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

