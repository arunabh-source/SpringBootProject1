package exceptions;

public class UserServiceException extends RuntimeException {

	private static final long serialVersionUID = 23425343243243435L;
	
	public UserServiceException(String message) {
		super(message);
	}
	
	
}
