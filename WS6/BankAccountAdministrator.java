import java.util.ArrayList;

public class BankAccountAdministrator extends BankAccountUser implements BankAccountAdministratorInterface{
	private ArrayList<BankAccountUser> bankAccountUsers;
	
	public BankAccountAdministrator(String username, String password, boolean loggedIn, ArrayList<BankAccountUser> bankAccountUsers) {
		super(username, password, loggedIn);
		this.bankAccountUsers = bankAccountUsers;
	}
	
	public void login(String password) {
		if ()
	}
	
	public void addUser(BankAccountUser user) {

	}
	
	public void resetAccount(BankAccountUser bankAccount, String password) {
		
	}
}
