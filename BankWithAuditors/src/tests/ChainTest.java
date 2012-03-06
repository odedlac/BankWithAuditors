/**
 * 
 */
package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import code.Accounts;
import code.BackgroundCheck;
import code.Display;
import code.Handler;
import code.Money;
import code.MyRequest;
import code.OpenAccountHandler;
import code.WithdrawMoneyHandler;

/**
 * @author oded
 *
 */
public class ChainTest {

	private Handler classUnderTest;
	
	@Before
	public void setUp() throws Exception {
		Accounts accounts = new Accounts();
		accounts.deposit(accounts.openNewAccount(), 100);
		accounts.deposit(accounts.openNewAccount(), 200);
		
		Money money = new Money();
		Display display = new Display();
		BackgroundCheck backGroundCheck  = new BackgroundCheck();

		Handler withdrawMoneyRequest = new WithdrawMoneyHandler(accounts,money,display);
		classUnderTest = new OpenAccountHandler(accounts,backGroundCheck,display);		
		classUnderTest.setHandler(withdrawMoneyRequest);	
	}
	

	@Test
	public void test1() {
		MyRequest myRequest = new MyRequest("OpenAccount","Oded",0,0);
		assertFalse("Opened account when shouldn't", classUnderTest.handleRequest(myRequest));
	}
	@Test
	public void test2() {
		MyRequest myRequest = new MyRequest("OpenAccount","Ode",0,0);
		assertTrue("Opened account when shouldn't", classUnderTest.handleRequest(myRequest));
	}

	
	@Test
	public void test3() {
		MyRequest myRequest = new MyRequest("WithdrawMoney","Oded",1,100);
		
		assertFalse("Gave money when shouldn't have",classUnderTest.handleRequest(myRequest));
	}
	
	@Test
	public void test4() {
		MyRequest myRequest = new MyRequest("WithdrawMoney","Oded",2,100);
		
		assertTrue("Did not give money when should have",classUnderTest.handleRequest(myRequest));
	}

	
	
}
