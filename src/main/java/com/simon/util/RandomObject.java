package com.simon.util;

@SuppressWarnings("rawtypes")
public interface RandomObject<R extends Comparable> {
	  public R getRandomObject();
	  public void generate(int upperBound);

}