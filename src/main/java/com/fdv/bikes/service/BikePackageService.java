package com.fdv.bikes.service;

import java.util.List;

import com.fdv.bikes.exception.BikesRentalException;
import com.fdv.bikes.model.BikePackage;

public interface BikePackageService {

	public Double calculteFinalPackage(List<BikePackage> bikePackages) throws BikesRentalException;
	
}
