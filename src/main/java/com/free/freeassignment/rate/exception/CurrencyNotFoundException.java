package com.free.freeassignment.rate.exception;

public class CurrencyNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4031095197220946174L;
	private String message;
	
	public CurrencyNotFoundException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
