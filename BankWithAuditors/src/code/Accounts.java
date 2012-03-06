/**
 * 
 */
package code;

import java.util.HashMap;
import java.util.Map;

/**
 * @author oded
 *
 */
public class Accounts extends AbstractSubject {

	Map<Integer,Integer> numberToBalance;
	
	public Accounts() {
		super();
		this.numberToBalance = new HashMap<Integer,Integer>();
	}

	public Boolean doesAccountExist(Integer accountNo){
		if(numberToBalance.containsKey(accountNo)){
			return true;
		}
		return false;	
	}
	
	public Integer openNewAccount() {
		super.notifyObservers();
		Integer accountNumber = numberToBalance.size()+1;
		numberToBalance.put(accountNumber, 0);
		return accountNumber;	
	}

	public Boolean deposit(Integer accountNo, Integer sumDeposited) {
		super.notifyObservers();
		if(doesAccountExist(accountNo)){
			numberToBalance.put(accountNo, sumDeposited);
			return true;
		}
		return false;
	}

	public Integer getBalance(Integer accountNo) {
		if(doesAccountExist(accountNo)){
			return numberToBalance.get(accountNo);
		}
		return 0;
	}

	public Boolean withdraw(Integer accountNo, Integer sumWithdrawn) {
		super.notifyObservers();
		if(doesAccountExist(accountNo)){
			numberToBalance.put(accountNo, numberToBalance.get(accountNo)-sumWithdrawn);
			return true;
		}
		return false;
	}

}
