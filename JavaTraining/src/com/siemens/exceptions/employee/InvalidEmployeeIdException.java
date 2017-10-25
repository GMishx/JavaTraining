package com.siemens.exceptions.employee;

public class InvalidEmployeeIdException extends Exception {

	private static final long serialVersionUID = -4418988347958514906L;

	public InvalidEmployeeIdException() {
		super();
	}

	public InvalidEmployeeIdException(String message) {
		super(message);
	}

	public InvalidEmployeeIdException(Throwable cause) {
		super(cause);
	}

	public InvalidEmployeeIdException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidEmployeeIdException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
