package com.simon.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class UtilTestConfig {
	
	@Profile("test")	
	@Bean	 
	public RandomDouble randomDouble() {
		return new RandomDouble();
	}
	
	@Profile("test")	
	@Bean	 
	public RandomInt randomInt() {
		return new RandomInt(100);
	}

}