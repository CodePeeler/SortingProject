package com.simon.util;

import java.util.ArrayList;
import java.util.List;

public class RandomFactory {
	
	@SuppressWarnings("unchecked")
	public static <T extends Comparable<T>> RandomObject<T> getRandomObject(String object) {
		RandomObject<?> result = null;
		
		if(object.equalsIgnoreCase("Integer")){
			result = new RandomInt(100);
		} else if(object.equalsIgnoreCase("Double")){
			result = new RandomDouble();
		}		
		return (RandomObject<T>) result;		
	}
	
	@SuppressWarnings({ "unchecked" })
	public static <T extends Comparable<T>> List<T> getRandomObjectList(String object, int numOfObjects){		
		RandomObject<?> randObj = null;
		List<?> arrayObj = null;
		
		if(object.equalsIgnoreCase("Integer")){			
			List<Integer> array = new ArrayList<>();			
			randObj = new RandomInt(100);
			for(int i=0; i<numOfObjects; i++) {				
				array.add((Integer) randObj.getRandomObject());
				randObj.generate(100);
			}
			arrayObj = array;
			
		} else if(object.equalsIgnoreCase("Double")){
			List<Double> array = new ArrayList<>();
			randObj = new RandomDouble();
			for(int i=0; i<numOfObjects; i++) {				
				array.add((Double) randObj.getRandomObject());
				randObj.generate(100);
			}
			arrayObj = array;
		}		
		return (List<T>) arrayObj;
	}

}