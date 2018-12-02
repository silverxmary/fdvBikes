package com.fdv.bikes.exception;

public class BikesRentalException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8031818384254771445L;
	
	
	public BikesRentalException() {
		super();
	}
	
	
	public BikesRentalException(String message) {
		super(message);
	}
	
	public BikesRentalException(String message, Throwable cause) {
		super(message,cause);
	}

	
}
