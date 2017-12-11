package com.simon.dom;

import org.meanbean.test.BeanTester;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class DomTestConfig {
	
	/**
	 * Only tests properties that have both a public 
	 * getter and setter method.
	 */
	@Bean
	@Profile("test") 
	public BeanTester meanBean() {
		return new BeanTester();
	}

}
