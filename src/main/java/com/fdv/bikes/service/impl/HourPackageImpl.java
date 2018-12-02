package com.fdv.bikes.service.impl;

import org.springframework.stereotype.Component;

import com.fdv.bikes.service.PackagePeriodStrategyService;

@Component("hourPackage")
public class HourPackageImpl implements PackagePeriodStrategyService{
/**
 * 1. Rental by hour, charging $5 per hour
 * 
 */
	@Override
	public Double calculatePrice(int rentalPeriod) {
		
		return Double.valueOf((int)rentalPeriod*5);
		
	}

}

