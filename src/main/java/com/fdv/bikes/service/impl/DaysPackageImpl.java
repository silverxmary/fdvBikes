package com.fdv.bikes.service.impl;

import org.springframework.stereotype.Component;
import com.fdv.bikes.service.PackagePeriodStrategyService;

@Component("daysPackage")
public class DaysPackageImpl implements PackagePeriodStrategyService{
/**
 * 2. Rental by day, charging $20 a day
 */
	@Override
	public Double calculatePrice(int rentalPeriod) {
		
		return Double.valueOf((int)rentalPeriod*20);
	}

}


