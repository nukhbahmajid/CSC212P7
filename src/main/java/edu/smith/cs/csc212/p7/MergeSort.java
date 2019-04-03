package edu.smith.cs.csc212.p7;

import edu.smith.cs.csc212.adtr.ListADT;
import edu.smith.cs.csc212.adtr.real.JavaList;

public class MergeSort {
	
	public static ListADT<Integer> mergeTwoSortedLists(ListADT<Integer> list1, ListADT<Integer> list2) {
		ListADT<Integer> newMergedList = new JavaList<>();
		
		while (!list1.isEmpty() || !list2.isEmpty()) {
			if(list2.isEmpty() && !list1.isEmpty()) {
				// this would probably give me concurrent modification error??
				int num = list1.size();
				for(int j=0; j < num; j++) {
					newMergedList.addBack(list1.getFront());
					list1.removeFront();
				}
			}
			
			else if(list1.isEmpty() && !list2.isEmpty()) {
				int num = list2.size();
				for(int j=0; j < num; j++) {
					newMergedList.addBack(list2.getFront());
					list2.removeFront();
				}
			} else {
				if(list1.getFront() <= list2.getFront()) {
					newMergedList.addBack(list1.removeFront());
				} else {
					newMergedList.addBack(list2.removeFront());
				}
			}

		}
		
		return newMergedList;
	} 
	
	
	public static ListADT<Integer> mergeSortRecursive(ListADT<Integer> input) {
		if(input.size() <= 1) {
			return input;
		}
		
		ListADT<Integer> front = input.slice(0, 2);
		ListADT<Integer> back = input.slice(3, input.size() -1);
		
		ListADT<Integer> frontSorted = mergeSortRecursive(front);
		ListADT<Integer> backSorted = mergeSortRecursive(back);
		
		System.out.println("Not sorted: "+ front);
		System.out.println("Sorted: " + frontSorted);
		
		return(mergeTwoSortedLists(frontSorted, backSorted));
	}
	
	
	public static void mergeSortIterative(ListADT<Integer> input) {
		//
	}

}//endClass
