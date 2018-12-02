package com.fdv.bikes.service;

public interface PackagePeriodStrategyService {

	/**
	 * Calculates the price depending on the rental period 
	 * */
	public Double calculatePrice(int rentalPeriod);
}
