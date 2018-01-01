package com.simon.algorithms;

//FYI, O(n*log( n )). Java's Collection.sort() is an implementation of MergeSort.

public class MergeSort {

	public static void merge(int[] array, int p, int q, int r){	  
	  int[] array_1 = new int[q-p+1];
	  int[] array_2 = new int[r-q];	
	
	  int c = p;
	  for(int i=0; i<array_1.length; i++){
	    array_1[i] = array[c];
	    c++;
	  }
	
	  int t=q+1;
	  for(int j=0; j<array_2.length; j++){
	    array_2[j] = array[t];
	    t++;
	  }
	  
	  int k=p, i=0;
	  for( int j=0; k<r+1 && j< r-q && i < (q-p+1); k++){	    
	    if(array_1[i] <= array_2[j]){
	      array[k] = array_1[i];
	      i++;
	    }else{
	      array[k] =  array_2[j];
	      j++;
	    }
	  }
	  for( ; i < array_1.length; k++ ){
	    array[k] = array_1[i];
	    i++;
	  }
	}

	public static void sort(int[] array, int p, int r){
	  if ( p < r ) { 
	    int q = (p+r)/2; //java truncation = floor.
	    sort(array, p, q);
	    sort(array, q+1, r);
	    merge(array, p, q, r);
	  }
	}

	public static void mergeSort(int[] array){
	  sort(array, 0, array.length-1);
	}

	public static void main(String[] args){
	  int[] array = {5, 2, 4, 7, 1, 3, 2, 6};
	  
	  for(int value: array){
		System.out.print(value+" ");
	  }
	  System.out.println("\n");
	  
	  mergeSort(array);
	
	  for(int value: array){
	    System.out.print(value+" ");
	  }
	}

}