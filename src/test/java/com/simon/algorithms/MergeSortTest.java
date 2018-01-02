package com.simon.algorithms;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.context.ActiveProfiles;

import com.simon.util.RandomFactory;

@ActiveProfiles("test")
public class MergeSortTest extends SortAbstractTest {
	
	private List<Integer> intArray;
	private List<Double> doubleArray;
	
	@Before
    public void setUp() throws Exception{
		intArray = RandomFactory.getRandomObjectList("Integer", 10);
		doubleArray = RandomFactory.getRandomObjectList("Double", 10);
    }
	
	@Test
    public void testMergeSortIntegerAscending() {		
		SortAlgorithm<Integer> mergeSort = new MergeSort<Integer>();
		mergeSort.sort(intArray, Integer::compareTo);		
		
		for (int i = 0; i < intArray.size() - 1; i++) {
	        if (intArray.get(i) > intArray.get(i + 1)) {
	            fail("Fail, should be in ascending order");
	        }
	    }
	    assertTrue(true);
	}

}
