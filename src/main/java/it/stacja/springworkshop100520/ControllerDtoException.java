package it.stacja.springworkshop100520;

public class ControllerDtoException extends RuntimeException {

	public ControllerDtoException(String message) {
		super(message);
	}

	public ControllerDtoException(String message, Throwable cause) {
		super(message, cause);
	}
}
