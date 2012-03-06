/**
 * 
 */
package code;

/**
 * @author oded
 *
 */
public class OpenAccountHandler extends Handler{

	private Display display;
	private BackgroundCheck backGroundCheck;
	private Accounts accounts;

	public OpenAccountHandler(Accounts accounts,
			BackgroundCheck backGroundCheck, Display display) {
		this.accounts = accounts;
		this.backGroundCheck = backGroundCheck;
		this.display = display;
	}

	public Boolean openAccount(String string) {
		if(!backGroundCheck.result(string)){
			display.displayString("Sorry request refused");
			return false;
		}
		Integer accountNumber = accounts.openNewAccount();
		display.displayString("Request accepted. New account number is: " + accountNumber);		
		return true;
	}

	public Boolean handleRequest(MyRequest myRequest) {
		if(myRequest.getRequestType().equals("OpenAccount")){
			return openAccount(myRequest.getName());
		} else if(super.handler == null){
			return false;
		}
		return super.handler.handleRequest(myRequest);
	}

}
