package code;

/**
 * 
 */

/**
 * @author Oded
 *
 */
public class Auditor extends AbstractObserver {

	private Accounts accounts;
	private Integer number;
	
	public Auditor(Accounts accounts,Integer number) {
		this.accounts = accounts;
		this.number = number;
	}
	/* (non-Javadoc)
	 * @see code.AbstractObserver#update()
	 */
	@Override
	void update() {
		System.out.println(number + " - Someone is messing with the accounts  " + accounts.doesAccountExist(1));
	}

}
