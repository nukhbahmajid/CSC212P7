package edu.smith.cs.csc212.p7;
import edu.smith.cs.csc212.adtr.ListADT;
import edu.smith.cs.csc212.adtr.real.JavaList;

public class SelectionSort {

	/*
	 * The first loop is for subsetting the list into sorted and unsorted parts
	 * Don't want to loop over sorted part after it has been successfully sorted.
	 * 
	 * Get the lowest value inside the second for loop and break the loop afterwards. 
	 * This will give the minimum.
	 * Swap value at new minimum index with the old minimum index value (??)
	 * 
	 * Then increase bounds of sorted list by one index, and repeat till list is 
	 * entirely sorted. 
	 */
	public static void selectionSort(ListADT<Integer> input) {
		int sizeList = input.size();
		for(int i=0; i < sizeList-1; i++) {
			// does minIndex gets reset after each iteration of for loop??? yes
			int minIndex = i; 
			for(int j = i+1; j < sizeList; j++) {
				if(input.getIndex(j) < input.getIndex(minIndex)) {
					minIndex = j; 
				}
			}
			input.swap(i, minIndex);
		}
	}
	
	/*
	 * This is the other method of implementing the selection sort: scan for minimum,
	 * add to the back of a new "sorted" list - repeat for all existing elements till
	 * the sorted list is complete and of the same size as the original unsorted list.
	 */
	public static ListADT<Integer> selectionSortList(ListADT<Integer> input) {
		ListADT<Integer> sorted = new JavaList<>();
		for(int j =input.size() - 1; j >= 0; j--) {
			int minIndex = input.size() - 1;
			for(int i=0; i < input.size() -1; i++) {
				if(input.getIndex(i) < input.getIndex(minIndex)) {
					minIndex = i; 
				} 
			}
			sorted.addBack(input.getIndex(minIndex));
			input.removeIndex(minIndex);
			minIndex = input.size() - 1;
		}
		
		System.out.println("Sorted list: " + sorted);
		
		input = sorted;
		
		
		/*
		 * Since lists are mutable objects, checking if the input equals to sorted assigngment
		 * is going to point at the same place in memory later (i.e. now point at a sorted list)
		 */
		System.out.println("Original list: " + input);
		
		return input;
	}

	
}
