package com.example.fdv.bikes;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fdv.bikes.enums.RentalPeriod;
import com.fdv.bikes.exception.BikesRentalException;
import com.fdv.bikes.model.Bike;
import com.fdv.bikes.model.BikePackage;
import com.fdv.bikes.service.PackagePeriodStrategyService;
import com.fdv.bikes.service.impl.BikePackageServiceImpl;
import com.fdv.bikes.service.impl.DaysPackageImpl;

@RunWith(SpringJUnit4ClassRunner.class)
public class BikePackageServiceTest {
	
	@Mock
	private BeanFactory bf;
	@InjectMocks
	private BikePackageServiceImpl bikePackage;
	@Before
	  public void setUp() throws Exception {
		this.bikePackage  = new BikePackageServiceImpl ();
		MockitoAnnotations.initMocks(this);

	}
	
	@Test
	public void calculteFinalPackageTest() throws BikesRentalException{
		List<BikePackage> bikePackages = new ArrayList<BikePackage>();
		Bike bike = new Bike();
		BikePackage bikePackageobj = new BikePackage();
		bike.setSize(10);
		bike.setType("bikeType");
		bikePackageobj.setBike(bike);
		bikePackageobj.setPeriod(2);
		bikePackageobj.setRentalPeriod(RentalPeriod.DAY);
		bikePackages.add(bikePackageobj);
		when(bf.getBean("daysPackage", PackagePeriodStrategyService.class)).thenReturn(new DaysPackageImpl());
		assertEquals(Double.valueOf(40.0),bikePackage.calculteFinalPackage(bikePackages));
		
	} 
}
