package com.example.fdv.bikes;

import org.junit.Before;
import org.junit.Test;
import org.meanbean.test.BeanTester;

import com.fdv.bikes.model.BikePackage;



public class BikePackageTest {

	@Before
	public void setUp() throws Exception {}

	@Test
	public void bikePackageClass() {
		BeanTester beanTester = new BeanTester();
		beanTester.testBean(BikePackage.class);
	}
}
