package com.simon.util;

import java.util.Random;

public class RandomDouble implements RandomObject<Double> {

	private Random random = new Random();;
	private Double number;	
	
	public RandomDouble() {
		generate(1);
	}	
	@Override
    public void generate(int upperBound){
    	this.number = new Double(random.nextDouble()*upperBound);
    }	
    @Override
	public Double getRandomObject() {
		return number;
	}
	   
}