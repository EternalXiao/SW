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
		A = new BankAccountAdministrator("A", "A1234");
		customerB = new Customer("B", "m", "B1", "1234");
		customerC = new Customer("c", "f", "B2", "2345");
		bankAccountB = new BankAccount(customerB, "B123");
		bankAccountC = new BankAccount(customerC, "C123");
		B = new BankAccountStandardUser("B", "B1234", bankAccountB);
		C = new BankAccountStandardUser("C", "C1234", bankAccountC);
	}

	// B logs in successfully with no failed login
	// and transfer some money to C (with and without login)
	@Test
	public void test1() {
		B.login("B1234");
		int expectedLoginAttempts = 0;
		int actualLoginAttempts = B.getLoginAttempts();

		assertEquals(expectedLoginAttempts, actualLoginAttempts);
		assertTrue(B.getLoggedIn());
		B.transferMoney(bankAccountC, 15, "B123");
		double expectedBalanceB1 = 85;
		double actualBalanceB1 = B.getBankAccount().getBalance();
		assertEquals(expectedBalanceB1, actualBalanceB1, 0.00001);
		double expectedBalanceC1 = 115;
		double actualBalanceC1 = C.getBankAccount().getBalance();
		assertEquals(expectedBalanceC1, actualBalanceC1, 0.00001);

		B.logout();
		assertFalse(B.getLoggedIn());
		B.transferMoney(bankAccountC, 30, "B123");
		double expectedBalanceB2 = 85;
		double actualBalanceB2 = B.getBankAccount().getBalance();
		assertEquals(expectedBalanceB2, actualBalanceB2, 0.00001);
		double expectedBalanceC2 = 115;
		double actualBalanceC2 = C.getBankAccount().getBalance();
		assertEquals(expectedBalanceC2, actualBalanceC2, 0.00001);
	}

	// B made 1,2,3,4 failed login an
	// called administrator C to reset
	// his account and B finally login
	// successfully
	@Test
	public void test2() {
		B.login("B1");
		int expectedLoginAttempts1 = 1;
		int actualLoginAttempts1 = B.getLoginAttempts();

		assertEquals(expectedLoginAttempts1, actualLoginAttempts1);
		assertFalse(B.getLoggedIn());

		B.login("B2");
		int expectedLoginAttempts2 = 2;
		int actualLoginAttempts2 = B.getLoginAttempts();

		assertEquals(expectedLoginAttempts2, actualLoginAttempts2);
		assertFalse(B.getLoggedIn());

		B.login("B3");
		int expectedLoginAttempts3 = 3;
		int actualLoginAttempts3 = B.getLoginAttempts();

		assertEquals(expectedLoginAttempts3, actualLoginAttempts3);
		assertFalse(B.getLoggedIn());

		B.login("B4");
		int expectedLoginAttempts4 = 3;
		int actualLoginAttempts4 = B.getLoginAttempts();

		assertEquals(expectedLoginAttempts4, actualLoginAttempts4);
		assertFalse(B.getLoggedIn());

		A.login("A1234");
		A.addUser(B);
		A.resetAccount(B, "B12");

		int expectedLoginAttempts5 = 0;
		int actualLoginAttempts5 = B.getLoginAttempts();
		assertEquals(expectedLoginAttempts5, actualLoginAttempts5);

		B.login("B12");
		assertTrue(B.getLoggedIn());
	}

	// B made 3 failed login and called
	// A to reset his account but A forgot
	// to login.
	@Test
	public void test3() {
		B.login("B");
		B.login("B1");
		B.login("B2");
		int expectedLoginAttempts1 = 3;
		int actualLoginAttempts1 = B.getLoginAttempts();

		assertEquals(expectedLoginAttempts1, actualLoginAttempts1);
		assertFalse(B.getLoggedIn());

		A.addUser(B);
		A.resetAccount(B, "B2");
		B.login("B2");
		int expectedLoginAttempts2 = 3;
		int actualLoginAttempts2 = B.getLoginAttempts();

		assertEquals(expectedLoginAttempts2, actualLoginAttempts2);
		assertFalse(B.getLoggedIn());
	}

	// B made 3 failed login and called
	// A to reset his account but A forgot
	// to add B to user list.
	@Test
	public void test4() {
		B.login("B");
		B.login("B1");
		B.login("B2");
		int expectedLoginAttempts1 = 3;
		int actualLoginAttempts1 = B.getLoginAttempts();

		assertEquals(expectedLoginAttempts1, actualLoginAttempts1);
		assertFalse(B.getLoggedIn());

		A.login("A1234");
		A.resetAccount(B, "B2");
		B.login("B2");
		int expectedLoginAttempts2 = 3;
		int actualLoginAttempts2 = B.getLoginAttempts();

		assertEquals(expectedLoginAttempts2, actualLoginAttempts2);
		assertFalse(B.getLoggedIn());
	}
}
