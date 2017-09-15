package user;

public class Message {
	public static final Message FATAL_ERROR = new Message("Fatal error!", false);
	
	private String message;
	private Boolean success;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	
	public Message(String message, Boolean success) {
		super();
		this.message = message;
		this.success = success;
	}

	public Message()
	{	
	}
}
