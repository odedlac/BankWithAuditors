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
import code.MyRequest;
import code.OpenAccountHandler;

/**
 * @author oded
 *
 */
public class OpenAccountHandlerTest {

	private  OpenAccountHandler classUnderTest;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		Accounts accounts = new Accounts();
		BackgroundCheck backGroundCheck  = new BackgroundCheck();
		Display display = new Display();
		
		classUnderTest = new OpenAccountHandler(accounts,backGroundCheck,display);
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
		MyRequest myRequest = new MyRequest("OpenAccount","Edo",0,0);
		assertTrue("Opened account when shouldn't", classUnderTest.handleRequest(myRequest));
	}


}
