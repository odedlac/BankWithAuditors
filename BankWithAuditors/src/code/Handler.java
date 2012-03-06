/**
 * 
 */
package code;

/**
 * @author Oded
 *
 */
public abstract class Handler {
	
	protected Handler handler;
		
	public Handler() {
		this.handler = null;
	}

	public void setHandler(Handler handler){
		this.handler = handler;
	}

	public abstract Boolean handleRequest(MyRequest myRequest);

}
