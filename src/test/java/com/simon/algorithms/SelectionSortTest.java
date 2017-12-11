package com.simon.algorithms;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.context.ActiveProfiles;

import com.simon.algorithms.SelectionSort;
import com.simon.util.RandomFactory;

@ActiveProfiles("test")
public class SelectionSortTest extends SortAbstractTest {
	
	private List<Integer> intArray;
	private List<Double> doubleArray;
	
	@Before
    public void setUp() throws Exception{
		intArray = RandomFactory.getRandomObjectList("Integer", 10);
		doubleArray = RandomFactory.getRandomObjectList("Double", 10);
    }
	
	@Test
    public void testSelectionSortIntegerAscending() {
		/*Remove*///	    long startTime = System.currentTimeMillis();
	 
		
/*Remove start*/
		System.out.println("--- Before ---");
		intArray.stream().map(x -> x+" ").forEach(System.out::print);
		System.out.println("\n\t---");
/*Remove fin*/	
		
		SelectionSort<Integer> selectionSort = new SelectionSort<Integer>();
		selectionSort.sort(intArray, Integer::compareTo);
		
/*Remove start*/		
		System.out.println("--- After ---");
		intArray.stream().map(x -> x+" ").forEach(System.out::print);
		System.out.println("\n\t---");
/*Remove fin*/
	
		/*Remove*///	    long stopTime = System.currentTimeMillis();
		/*Remove*///	    long elapsedTime = stopTime - startTime;
		/*Remove*///	    System.out.println("SelectionSort " + elapsedTime+"\n");
	
	    for (int i = 0; i < intArray.size() - 1; i++) {
	        if (intArray.get(i) > intArray.get(i + 1)) {
	            fail("Fail, should be in ascending order");
	        }
	    }
	    assertTrue(true);
    }
	
	@Test
    public void testSelectionSortIntegerDescending() {	
	    SelectionSort<Integer> selectionSort = new SelectionSort<Integer>();
		selectionSort.sort(intArray, (a, b) -> (a > b) ? 0:1);
		
	    for (int i = 0; i < intArray.size() - 1; i++) {
	        if (intArray.get(i) < intArray.get(i + 1)) {
	            fail("Fail, should be in descending order");
	        }
	    }
	    assertTrue(true);
    }
	
	@Test
    public void testSelectionSortDoubleAscending() {
		SelectionSort<Double> selectionSort = new SelectionSort<Double>();
		selectionSort.sort(doubleArray, Double::compareTo);		
	
	    for (int i = 0; i < doubleArray.size() - 1; i++) {
	        if (doubleArray.get(i) > doubleArray.get(i + 1)) {
	            fail("Fail, should be in ascending order");
	        }
	    }
	    assertTrue(true);
    }
	
	@Test
    public void testSelectionSortDoubleDescending() {	
	    SelectionSort<Double> selectionSort = new SelectionSort<Double>();		
	    selectionSort.sort(doubleArray, (a, b) -> (a > b) ? 0:1);	
	
	    for (int i = 0; i < doubleArray.size() - 1; i++) {
	        if (doubleArray.get(i) < doubleArray.get(i + 1)) {
	            fail("Fail, should be in descending order");
	        }
	    }
	    assertTrue(true);
    }	

}
