package com.free.freeassignment.rate.exception;

public class FetchRateException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;

	public FetchRateException(String message) {
		super();
		this.setMessage(message);
	}

	@Override
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
