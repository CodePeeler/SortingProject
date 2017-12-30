package com.simon.dom;

import java.util.ArrayList;
import java.util.List;

public class Trial<T> {
	
	private List<T> data;
	private double executionTime;
	
	public Trial() {
		this.data = new ArrayList<T>();
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

}
