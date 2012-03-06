/**
 * 
 */
package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import code.Accounts;
import code.Display;
import code.Money;
import code.MyRequest;
import code.WithdrawMoneyHandler;

/**
 * @author oded
 *
 */
public class WithdrawMoneyHandlerTest {

	private WithdrawMoneyHandler classUnderTest;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		Accounts accounts = new Accounts();
		accounts.deposit(accounts.openNewAccount(), 100);
		accounts.deposit(accounts.openNewAccount(), 200);
		
		Money money = new Money();
		Display display = new Display();
		
		classUnderTest = new WithdrawMoneyHandler(accounts,money,display);
	}

	@Test
	public void test1() {
		MyRequest myRequest = new MyRequest("WithdrawMoney","Oded",1,400);
		
		assertFalse("Gave money when shouldn't have",classUnderTest.handleRequest(myRequest));
	}
	
	@Test
	public void test2() {
		MyRequest myRequest = new MyRequest("WithdrawMoney","Oded",2,100);
		
		assertTrue("Did not give money when should have",classUnderTest.handleRequest(myRequest));
	}

}
