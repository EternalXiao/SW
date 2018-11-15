import java.util.ArrayList;

public class BankAccountAdministrator extends BankAccountUser implements BankAccountAdministratorInterface {
	private ArrayList<BankAccountUser> bankAccountUsers;

	public BankAccountAdministrator(String username, String password) {
		super(username, password);
		this.bankAccountUsers = new ArrayList<>();
	}

	public void login(String password) {
		if (this.passwordCorrect(password)) {
			this.setLoggedIn(true);
		} else {
			this.setLoggedIn(false);
		}
	}

	public void addUser(BankAccountUser user) {
		if (this.getLoggedIn()) {
			this.bankAccountUsers.add(user);
		}
	}

	public void resetAccount(BankAccountUser bankAccount, String password) {
		if (this.getLoggedIn()) {
			bankAccount.setPassword(password);
			((BankAccountStandardUser) bankAccount).resetLoginAttempts();
		}
	}
}
