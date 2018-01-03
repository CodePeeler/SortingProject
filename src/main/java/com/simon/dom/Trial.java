package com.simon.dom;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("rawtypes")
public class Trial<T extends Comparable> {
	
	private List<T> data;
	private double executionTime;
	
	private String elementType;
	private int numOfElements;
	private String sortAlgorithm;
	
	public Trial() {
		this.data = new ArrayList<T>();
	}
	
	public Trial(String elementType, int numOfElements, String sortAlgorithm) {
		this.data = new ArrayList<T>();
		this.elementType = elementType;
		this.numOfElements = numOfElements;
		this.sortAlgorithm = sortAlgorithm;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public double getExecutionTime() {
		return executionTime;
	}
			
	public String getElementType() {
		return elementType;
	}

	public void setElementType(String elementType) {
		this.elementType = elementType;
	}

	public int getnumOfElements() {
		return numOfElements;
	}

	public void setnumOfElements(int numOfElements) {
		this.numOfElements = numOfElements;
	}

	public String getSortAlgorithm() {
		return sortAlgorithm;
	}

	public void setSortAlgorithm(String sortAlgorithm) {
		this.sortAlgorithm = sortAlgorithm;
	}
	
	

}
