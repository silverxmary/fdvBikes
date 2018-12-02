package com.fdv.bikes.service.impl;

import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdv.bikes.enums.RentalPeriod;
import com.fdv.bikes.exception.BikesRentalException;
import com.fdv.bikes.model.BikePackage;
import com.fdv.bikes.service.BikePackageService;
import com.fdv.bikes.service.PackagePeriodStrategyService;

@Service("bikePackage")
public class BikePackageServiceImpl implements BikePackageService {
/**
 * 4. Family Rental, is a promotion that can include from 3 to 5 Rentals (of any type) with a discount of 30% of the total price
 */
	Double packagesTotalPrice;
	
	@Autowired
	BeanFactory bf;
	
	/*another way of dependency Injection strategy impl
	 * @Resource(name="weekPackage")
	private PackagePeriodStrategyService weekPackage;*/
	 
	
	@Override
	public Double calculteFinalPackage(List<BikePackage> bikePackages) throws BikesRentalException {
		this.packagesTotalPrice= 0.0;
		Double finalPrice =0.0;
		if(bikePackages!=null) {
			
			bikePackages.forEach(pack -> {
				Double packagePrice = 0.0;
				if(pack.getRentalPeriod()!=null) {
					if(pack.getRentalPeriod().name().equals(RentalPeriod.DAY.name())){
						packagePrice= bf.getBean("daysPackage", PackagePeriodStrategyService.class).calculatePrice(pack.getPeriod());
				
					}
					if(pack.getRentalPeriod().name().equals(RentalPeriod.WEEK.name())){
						//packagePrice =weekPackage.calculatePrice(pack.getPeriod());
						packagePrice= bf.getBean("weekPackage", PackagePeriodStrategyService.class).calculatePrice(pack.getPeriod());

					}
					if(pack.getRentalPeriod().name().equals(RentalPeriod.HOUR.name())){
						packagePrice = bf.getBean("hourPackage", PackagePeriodStrategyService.class).calculatePrice(pack.getPeriod());

					}
					this.packagesTotalPrice = packagesTotalPrice+packagePrice;
				}
			});
		if(this.packagesTotalPrice==null || this.packagesTotalPrice == 0) {
			throw new BikesRentalException("Error - No rental periods selected");
		}
		finalPrice = addFamilyPromotion(bikePackages,this.packagesTotalPrice);
		return finalPrice;
		}else 
			throw new BikesRentalException("Error - No packages added");
	}
	

	private Double addFamilyPromotion(List<BikePackage> bikePackages, Double packagePrice) {
		Double finalPrice = packagePrice ;
		if(bikePackages.size()>=3 && bikePackages.size()<=5) {
			finalPrice= packagePrice*0.7;
		}
		
		return finalPrice;
	}

}
