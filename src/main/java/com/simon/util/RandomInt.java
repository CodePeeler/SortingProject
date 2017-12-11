package com.simon.util;

import java.util.Random;

public class RandomInt implements RandomObject<Integer> {
	
	private Random random = new Random();
	private Integer number;
	
	public RandomInt(int upperBound){
		generate(upperBound);
	}
	@Override
    public void generate(int upperBound){
    	this.number = new Integer(random.nextInt(upperBound));
    }
	@Override
    public Integer getRandomObject(){
    	return number;
    }

}