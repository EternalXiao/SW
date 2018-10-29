import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
/**
 *  This file contains 2 JUnit tests for testing the toString method
 *  in the class BankAccount.java
 *  @author Manfred Kerber
 *  @version 2018-10-11
 */
public class BankAccountJUnit {
    private BankAccount manfred;
    @Before
    public void initObjects() {
        manfred = new BankAccount("Manfred");
        manfred.payIn(28.23);
    }
    @Test
    public void assertEqualsTest1() {
        assertEquals("failure in method toString: " +
                     " expected string not equal computed string",
                     "Account name: Manfred Balance: 28.23",
                     manfred.toString());
    }
    @Test
    public void assertEqualsTest2() {
        manfred.withdraw(0.99);
        assertEquals("failure in method toString: " +
                     " expected string not equal computed string",
                     "Account name: Manfred Balance: 27.24",
                     manfred.toString());
    }
}