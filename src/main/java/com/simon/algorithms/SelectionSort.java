package com.simon.algorithms;

import java.util.List;

public class SelectionSort<T extends Comparable<T>> implements SortAlgorithm<T> {

	public void sort(List<T> array, Compare<T> c) {
		for(int i=0; i<array.size()-1; i++) {
			int min = i;
			for(int j=i+1; j<array.size(); j++) {
				if( c.compare( array.get(min), array.get(j) ) > 0 ) {
					min = j;
				}
			}
			//swap
			T temp = array.get(i);
			array.set(i, array.get(min));
			array.set(min, temp);
		}
	}

}
