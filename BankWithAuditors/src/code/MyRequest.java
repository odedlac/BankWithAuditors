package code;

public class MyRequest {

	private String requestType;


	private String name;
	private Integer accountNumber;
	private Integer sum;

	public MyRequest(String requestType, String name, Integer accountNumber,
			Integer sum) {
		this.requestType = requestType;
		this.name = name;
		this.accountNumber = accountNumber;
		this.sum = sum;
	}

	/**
	 * @return the requestType
	 */
	public String getRequestType() {
		return requestType;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the accounNumber
	 */
	public Integer getAccountNumber() {
		return accountNumber;
	}

	/**
	 * @return the sum
	 */
	public Integer getSum() {
		return sum;
	}

	
	
}
