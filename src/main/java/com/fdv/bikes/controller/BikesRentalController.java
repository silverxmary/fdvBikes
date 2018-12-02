package com.fdv.bikes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fdv.bikes.exception.BikesRentalException;
import com.fdv.bikes.model.BikePackage;
import com.fdv.bikes.service.BikePackageService;

@RestController
@RequestMapping("/")
@ComponentScan("com.fdv.bikes.service.impl")
public class BikesRentalController {

	@Autowired
	@Qualifier("bikePackage")
	private BikePackageService bikePackageService;
	
	@PostMapping(value="/rentBikes")
	public ResponseEntity<Double> rentBikes(List<BikePackage> bikePackages) throws BikesRentalException{
		Double finalP =bikePackageService.calculteFinalPackage(bikePackages);
		return new ResponseEntity<>(Double.valueOf(finalP), HttpStatus.OK);
	}
	
}
