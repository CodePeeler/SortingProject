package com.simon.algorithms;

@SuppressWarnings("rawtypes")
@FunctionalInterface
public interface Compare<T extends Comparable> {
  public int compare(T t, T r);  
}