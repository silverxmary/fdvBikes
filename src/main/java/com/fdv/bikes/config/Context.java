package com.fdv.bikes.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.fdv.bikes.service.PackagePeriodStrategyService;;
@Component
@Scope("prototype")
public class Context {
	
	   @Autowired
	   private PackagePeriodStrategyService strategy;

	   public Context(PackagePeriodStrategyService strategy){
	      this.strategy = strategy;
	   }

	   public Double executeStrategy(int num1){
	      return  strategy.calculatePrice(num1);
	   }
	

}