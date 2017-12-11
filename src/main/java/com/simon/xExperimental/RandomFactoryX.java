package com.simon.xExperimental;

import java.util.ArrayList;
import java.util.List;

import com.simon.util.RandomDouble;
import com.simon.util.RandomInt;
import com.simon.util.RandomObject;

/**************************************************************
 * 
 * 	Experimental class    
 * 
 *************************************************************
 */
public class RandomFactoryX {
	
	@SuppressWarnings("unchecked")
	public static <T extends Comparable<T>> RandomObject<T> getRandomObject(T object) {
		RandomObject<?> result = null;
		
		if(object instanceof Integer){
			result = new RandomInt(100);
		} else if(object instanceof Double){
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