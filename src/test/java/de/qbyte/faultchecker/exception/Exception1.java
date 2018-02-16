package de.qbyte.faultchecker.exception;

public class Exception1 extends RuntimeException {

	private static final long serialVersionUID = 7145166224343523462L;

	public Exception1() {
		super();
	}

	public Exception1(String message, Throwable cause) {
		super(message, cause);
	}

	public Exception1(String message) {
		super(message);
	}

	public Exception1(Throwable cause) {
		super(cause);
	}

}
