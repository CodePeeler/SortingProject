package com.simon.services;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.simon.algorithms.SelectionSort;
import com.simon.algorithms.SortAlgorithm;

@Configuration
@Profile("test")
public class ServicesTestConfig {
	
	@Bean
	public AlgorithmService algorithmService(){
		return new AlgorithmService();
	}
	
	@Bean
	public SortAlgorithm<Integer> selectionSort() {
		return new SelectionSort<Integer>();
	}
}