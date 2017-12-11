package com.simon.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class UtilTestConfig {
		
	@Bean
	@Profile("test") 
	public RandomDouble randomDouble() {
		return new RandomDouble();
	}
	
	@Bean
	@Profile("test") 
	public RandomInt randomInt() {
		return new RandomInt(100);
	}

}