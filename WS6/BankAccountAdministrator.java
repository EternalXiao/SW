/**
 * BankAccountAdministrator is a sub-class of BankAccountUser and
 * it also implements the interface BankAccountAdministratorInterface.
 * It has an additional field variable bankAccountUsers.
 */

import java.util.ArrayList;

public class BankAccountAdministrator extends BankAccountUser implements BankAccountAdministratorInterface {
	private ArrayList<BankAccountUser> bankAccountUsers;

	/**
	 * Constructor for BankAccountAdministrator
	 * @param username the username of administrator
	 * @param password the password of administrator
	 */
	public BankAccountAdministrator(String username, String password) {
		super(username, password);
		this.bankAccountUsers = new ArrayList<>();
	}

	/**
	 * Method for administrator to log in
	 * @param password the password entered by the administrator
	 */
	public void login(String password) {
		if (this.passwordCorrect(password)) {
			this.setLoggedIn(true);
		} else {
			this.setLoggedIn(false);
		}
	}

	/**
	 * Method to add user to a user list
	 * @param user a user object
	 */
	public void addUser(BankAccountUser user) {
		if (this.getLoggedIn()) {
			this.bankAccountUsers.add(user);
		}
	}

	/**
	 * Method for administrator to reset a user account
	 * @param bankAccount the user account
	 * @param password the new password for the user
	 */
	public void resetAccount(BankAccountUser bankAccount, String password) {
		if (this.getLoggedIn()&& this.bankAccountUsers.contains(bankAccount)) {
			bankAccount.setPassword(password);
			((BankAccountStandardUser) bankAccount).resetLoginAttempts();
		}
	}
}
