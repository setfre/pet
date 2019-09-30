package petshop.ssm.execption;


public class InLoginExecption extends Exception{

	private String message;
	
	public InLoginExecption(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
