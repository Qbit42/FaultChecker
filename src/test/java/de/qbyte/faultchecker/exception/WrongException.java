package de.qbyte.faultchecker.exception;

public class WrongException extends RuntimeException {

	private static final long serialVersionUID = 7145166224343523462L;

	public WrongException() {
		super();
	}

	public WrongException(String message, Throwable cause) {
		super(message, cause);
	}

	public WrongException(String message) {
		super(message);
	}

	public WrongException(Throwable cause) {
		super(cause);
	}

}
