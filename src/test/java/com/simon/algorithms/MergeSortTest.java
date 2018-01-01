package com.simon.algorithms;

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
    public void testSelectionSortIntegerAscending() {
		//fail("No test... write test!");
	}

}
