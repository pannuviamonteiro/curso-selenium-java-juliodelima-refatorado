package framework.exceptions;

public class DatapoolException extends RuntimeException {

	private static final long serialVersionUID = -7470771617131416330L;

	public DatapoolException(String message) {
		super(message);
	}
	
	public DatapoolException(Throwable cause) {
		super(cause);
	}
	
	public DatapoolException(String message, Throwable cause) {
		super(message, cause);
	}
}
