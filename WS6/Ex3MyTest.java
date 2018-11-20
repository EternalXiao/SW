import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Ex3MyTest {
	private BankAccountAdministrator A;
	private Customer customerB, customerC;
	private BankAccount bankAccountB, bankAccountC;
	private BankAccountStandardUser B, C;
	
	@Before
	public void setUp() {
		A = new BankAccountAdministrator("A","AUser");
		customerB = new Customer("B","m","B1","1234");
		customerC = new Customer("c","f","B2","2345");
		bankAccountB = new BankAccount(customerB,"B123");
		bankAccountC = new BankAccount(customerC,"C123");
		B = new BankAccountStandardUser("B","B1234",bankAccountB);
		C = new BankAccountStandardUser("C","C1234",bankAccountC);
	}
	
	//B logs in successfully with no failed login
	//and transfer some money to C (with and without login)
	@Test
	public void test() {
		B.login("B1234");
		int expectedLoginAttempts = 0;
		int actualLoginAttempts = B.getLoginAttempts();

		assertEquals(expectedLoginAttempts, actualLoginAttempts);
		assertTrue(B.getLoggedIn());
		john.transferMoney(bankAccountMary, 10, "wheat");
		double expectedBalanceJohn = 90;
		double actualBalanceJohn = john.getBankAccount().getBalance();
		assertEquals(expectedBalanceJohn, actualBalanceJohn, 0.00001);
		double expectedBalanceMary = 110;
		double actualBalanceMary = mary.getBankAccount().getBalance();
		assertEquals(expectedBalanceMary, actualBalanceMary, 0.00001);
	}

}
