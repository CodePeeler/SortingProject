package com.simon.services;

import java.util.ArrayList;
import java.util.List;

import com.simon.algorithms.Compare;
import com.simon.algorithms.SortAlgorithm;
import com.simon.dom.Trial;
import com.simon.util.RandomFactory;

public class AlgorithmService {
	
	public <T extends Comparable<T>> List<Trial<T>> runTrial(int arraySize, String type, int numOfTrials, SortAlgorithm<T> sortAlgorithm) {
		
		List<Trial<T>> resultSet = new ArrayList<>();
		Trial<T> trial = new Trial<>();
		
		trial.setData( RandomFactory.getRandomObjectList(type, arraySize));
		/* Note, since the type T extends Comparable it must
		 * implement the compareTo method thus we can pass 
		 * it as a method references to sort.
		 */
		sortAlgorithm.sort(trial.getData(), T::compareTo);		
		resultSet.add(trial);
		return resultSet;
	}
	
	public <T extends Comparable<T>> List<Trial<T>> runTrial(int arraySize, int numOfTrials, SortAlgorithm<T> sortAlgorithm, Compare<T> compareUsing) {
		return null;
	}

}
