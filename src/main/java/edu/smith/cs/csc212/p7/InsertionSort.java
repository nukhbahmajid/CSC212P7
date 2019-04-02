package edu.smith.cs.csc212.p7;
import edu.smith.cs.csc212.adtr.ListADT;



public class InsertionSort {
	/*
	 * This is a linear search sort - maybe?
	 */
	public static void insertionSort(ListADT<Integer> input) {
		int sizeList = input.size();
		
		for(int i=0; i<sizeList; i++) {
			int toPlace = input.getIndex(i);
			int prevIndex = i - 1; 
			
			/*
			 * Check if the immediate preceding number is greater than the current
			 * index number (let's call it x), if it is: then iterate over all the 
			 * previous indices check their values and place x such that, in the 
			 * previous "sorted" part of list, the number BEFORE it is less than or
			 * equal to it and the number AFTER it is greater than or equal to it.
			 * 
			 *  First condition: to make sure not to get a BadIndexError - and the
			 *  first one always stays in its place.
			 *  
			 *  Second condition: try to insert current value orderly if and only if
			 *  the IMMEDIATE preceding value is greater than the current value. 
			 */
			while(prevIndex >= 0 && input.getIndex(prevIndex) > toPlace) {
				input.setIndex(prevIndex + 1, input.getIndex(prevIndex));
				prevIndex--;
				
			}//endWhileLoop
			
			input.setIndex(prevIndex + 1, toPlace);
			
		}//endForLoop
		
	}//endMethod
	

}//endClass
