package com.simon.algorithms;

import java.util.*;

@SuppressWarnings("rawtypes")
public interface SortAlgorithm<T extends Comparable> {
	public void sort(List<T> t, Compare<T> c);

}