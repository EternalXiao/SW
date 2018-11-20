/**
 * BankAccountUser is an abstract class characterised by field variables
 * username, password and loggedIn.
 */

public abstract class BankAccountUser implements BankAccountUserInterface {
	private String username;
	private String password;
	private boolean loggedIn;
	
	/**
	 * Constructor for class BankAccountUser
	 * @param username the username of the user
	 * @param password the password for the user
	 */
	public BankAccountUser(String username, String password) {
		this.username = username;
		this.password = password;
		this.loggedIn = false;
	}
	
	/**
	 * The login method will check whether
	 * the entered password is identical to 
	 * the password stored in the system and
	 * subsequently determine the login status.
	 */
	public void login(String password) {
		if (this.passwordCorrect(password))
			this.setLoggedIn(true);
		else
			this.setLoggedIn(false);
	}

	/**
	 * This method enables user to logout.
	 */
	public void logout() {
		this.setLoggedIn(false);
	}

	/**
	 * Getter for password, for security reason
	 * this method should be private.
	 * @return the stored password
	 */
	private String getPassword() {
		return this.password;
	}

	/**
	 * This method check whether the input password
	 * is the same as the password stored in the system.
	 * @return true if it is identical, otherwise false
	 */
	public boolean passwordCorrect(String password) {
		return this.getPassword().equals(password);
	}

	/**
	 * Setter for password
	 * @param password the password to be set
	 */
	public void setPassword(String password) {
		if (this.getLoggedIn()) {
			this.password = password;
		}
	}
	
	/**
	 * Getter for login status
	 * @return the login status
	 */
	public boolean getLoggedIn() {
		return this.loggedIn;
	}
	
	/**
	 * Setter for login status
	 * @param loggedIn new login status to be set
	 */
	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

}
