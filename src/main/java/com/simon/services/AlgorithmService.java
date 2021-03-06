package com.simon.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.simon.algorithms.Compare;
import com.simon.algorithms.SelectionSort;
import com.simon.algorithms.SortAlgorithm;
import com.simon.dom.Trial;
import com.simon.util.AlgorithmFactory;
import com.simon.util.RandomFactory;

@Component
public class AlgorithmService {

	public <T extends Comparable<T>> List<Trial<T>> runTrial(Trial<T> trial, int numOfTrials) {
		
		List<Trial<T>> resultSet = new ArrayList<>();
		
		/* Setting the data, using a factory to generate a list n elements 
		 * of base type x (where x and n were specified in the trial).
		 */
		trial.setData( RandomFactory.getRandomObjectList(trial.getElementType(), trial.getnumOfElements()));
		
		/* Using a factory to create the required algorithm as
		 * specified in the trial.
		 */
		SortAlgorithm<T> sortAlgorithm = AlgorithmFactory.getSortingAlgorithm(trial.getSortAlgorithm());
		
		/* Since the type T extends Comparable it must
		 * implement the compareTo method thus we can pass
		 * it as a method references to the sort method.
		 */
		sortAlgorithm.sort(trial.getData(), T::compareTo);
		resultSet.add(trial);
		return resultSet;				
	}
	
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
	/*
	public <T extends Comparable<T>> List<Trial<T>> runTrial(int arraySize, int numOfTrials, SortAlgorithm<T> sortAlgorithm, Compare<T> compareUsing) {
		return null;
	}
	*/
	public List<Trial<Integer>> dumbTrial(int arraySize, String type, int numOfTrials) {
		List<Trial<Integer>> trials = new ArrayList<Trial<Integer>>();

		Trial<Integer> trial = new Trial<Integer>();
		List<Integer> array = new ArrayList<>();

		array.add(new Integer(5));
		array.add(new Integer(8));
		array.add(new Integer(19));

		trial.setData(array);
		trials.add(trial);


		return trials;
	}
}
