package it.stacja.springworkshop100520;

public class CannotCreateTweetException extends RuntimeException {

	public CannotCreateTweetException(String message) {
		super(message);
	}

	public CannotCreateTweetException(String message, Throwable cause) {
		super(message, cause);
	}
}
