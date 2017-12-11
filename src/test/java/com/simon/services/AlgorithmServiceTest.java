package com.simon.services;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;

import com.simon.algorithms.SortAlgorithm;
import com.simon.services.AlgorithmService;
import com.simon.dom.Trial;

@ActiveProfiles("test")
public class AlgorithmServiceTest extends ServicesAbstractTest {
	
	@Autowired
	private AlgorithmService algorithmService;
	@Autowired
	private SortAlgorithm<Integer> selectionSort;
	
	private List<Trial<Integer>> resultSet;
	
	private int arraySize = 10;
	private int numOfTrials = 1;
	
	
	@Test
	public void resultSetShouldContainIntegers() {	
		resultSet = algorithmService.runTrial(arraySize, "Integer", numOfTrials, selectionSort);
		Trial<Integer> trial = (Trial<Integer>) resultSet.get(0);
		List<Integer> data = trial.getData();
		assertThat(data.get(0), instanceOf(Integer.class));	
	}
	
	@Test
    public void resultSetShouldBeInAscendingOrder() {
		Trial<Integer> trial;
		List<Integer> data;		
		
		resultSet = algorithmService.runTrial(arraySize, "Integer", numOfTrials, selectionSort);
		trial = (Trial<Integer>) resultSet.get(0);
		data = trial.getData();		
	
	    for (int i = 0; i < data.size() - 1; i++) {
	        if (data.get(i) > data.get(i + 1)) {
	            fail("Fail, should be in ascending order");
	        }
	    }
	    assertTrue(true);
    }

}