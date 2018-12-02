package com.fdv.bikes.model;

import com.fdv.bikes.enums.RentalPeriod;

public class BikePackage {

	private Bike bike;
	private RentalPeriod rentalPeriod;
	private int period;
	
	public Bike getBike() {
		return bike;
	}
	public void setBike(Bike bike) {
		this.bike = bike;
	}
	public RentalPeriod getRentalPeriod() {
		return rentalPeriod;
	}
	public void setRentalPeriod(RentalPeriod rentalPeriod) {
		this.rentalPeriod = rentalPeriod;
	}
	public int getPeriod() {
		return period;
	}
	public void setPeriod(int period) {
		this.period = period;
	}
	

}
