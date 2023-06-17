package com.cabmanagement.exception;

public class DuplicateRecordException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String msg;

	public DuplicateRecordException(String msg) {
		super(msg);
	}

}
