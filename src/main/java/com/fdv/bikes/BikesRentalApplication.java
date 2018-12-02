package com.fdv.bikes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages= {"com.fdv.bikes.controller"})
public class BikesRentalApplication {

	public static void main(String[] args) {
		SpringApplication.run(BikesRentalApplication.class, args);
				
		
	}
}
