package com.fdv.bikes.service.impl;

import org.springframework.stereotype.Component;

import com.fdv.bikes.service.PackagePeriodStrategyService;
@Component("weekPackage")
public class WeekPackageImpl implements PackagePeriodStrategyService{
/**
 * 3. Rental by week, changing $60 a week
 */
	@Override
	public Double calculatePrice(int rentalPeriod) {
 
		return Double.valueOf((int)rentalPeriod*60);
	}

}



