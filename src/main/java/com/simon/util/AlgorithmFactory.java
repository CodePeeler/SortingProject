package com.simon.util;

import com.simon.algorithms.MergeSort;
import com.simon.algorithms.SelectionSort;
import com.simon.algorithms.SortAlgorithm;

public class AlgorithmFactory {
	
	public static <T extends Comparable<T>> SortAlgorithm<T> getSortingAlgorithm(String algorithmName){
		SortAlgorithm<T> sortAlgorithm = null;
		
		if(algorithmName.equalsIgnoreCase("SelectionSort")){
			sortAlgorithm = new SelectionSort<T>();
		} else if(algorithmName.equalsIgnoreCase("MergeSort")){
			sortAlgorithm = new MergeSort<T>();
		}		
		return sortAlgorithm;	
	}

}
