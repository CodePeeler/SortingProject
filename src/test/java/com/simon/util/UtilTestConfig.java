package com.simon.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class UtilTestConfig {
		
	@Bean	 
	public RandomDouble randomDouble() {
		return new RandomDouble();
	}
	
	@Bean	 
	public RandomInt randomInt() {
		return new RandomInt(100);
	}

}