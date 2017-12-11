package com.simon.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


import com.simon.dom.Contact;

@Configuration //Indicates to Spring that it’s an ApplicationContext configuration class.
public class ControllerTestConfig {
	
	@Bean
	@Profile("test") 
	public Contact contact() {
		return new Contact();
	}

}