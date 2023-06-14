package com.cabmanagement.exception;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DuplicateRecordException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String msg;	
		
}
