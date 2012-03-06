package tests;
import static org.junit.Assert.*;

import org.junit.Test;

import code.MyRequest;

/**
 * 
 */

/**
 * @author Oded
 *
 */
public class RequestTest {

	/**
	 * @throws java.lang.Exception
	 */

	@Test
	public void test() {
		String returnedRequestType,requestType = "WithdrawMoney";
		String returnedName, name = "Oded";
		Integer returnedAccountNumber, accountNumber = 1;
		Integer returnedSum, sum= 100;
		
		MyRequest classUnderTest = new MyRequest(requestType,name,accountNumber,sum);
		
		returnedRequestType = classUnderTest.getRequestType();
		returnedName = classUnderTest.getName();
		returnedAccountNumber = classUnderTest.getAccountNumber();
		returnedSum = classUnderTest.getSum();
		
		assertEquals("Wronge answer",requestType,returnedRequestType);
		assertEquals("Wronge answer",name,returnedName);
		assertEquals("Wronge answer",accountNumber,returnedAccountNumber);
		assertEquals("Wronge answer",sum,returnedSum);
	}

}
