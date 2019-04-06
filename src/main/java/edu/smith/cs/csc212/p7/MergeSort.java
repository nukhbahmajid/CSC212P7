package edu.smith.cs.csc212.p7;

import edu.smith.cs.csc212.adtr.ListADT;
import edu.smith.cs.csc212.adtr.real.JavaList;

public class MergeSort {
	
	public static ListADT<Integer> mergeTwoSortedLists(ListADT<Integer> list1, ListADT<Integer> list2) {
		ListADT<Integer> newMergedList = new JavaList<>();
		
		while (!list1.isEmpty() || !list2.isEmpty()) {
			if(list2.isEmpty() && !list1.isEmpty()) {
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
		} else {
			ListADT<Integer> front = input.slice(0, input.size()/2);
			ListADT<Integer> back = input.slice(input.size()/2, input.size());
			
			ListADT<Integer> frontSorted = mergeSortRecursive(front);
			ListADT<Integer> backSorted = mergeSortRecursive(back);
			
			ListADT<Integer> merged = (mergeTwoSortedLists(frontSorted, backSorted));

			return merged;
		}
	}
	
	
	public static ListADT<Integer> mergeSortIterative(ListADT<Integer> input) {
		// make a bigger list with smaller lists. 
		ListADT<ListADT<Integer>> outerList = new JavaList<>();
		
		// separate each number in the input into separate lists. Add them to the sorted outer list. 
		for (int i : input) {
			ListADT<Integer> innerList = new JavaList<>();
			innerList.addBack(i);
			outerList.addBack(innerList);
		}
		
		/* take the first two 1-item merge them using mergeTwoSortedLists, add resulting 
		 * list to the outer list and remove the first two 1-item list
		 */
		while (outerList.size() >= 2) {
			ListADT<Integer> combinedFirstTwo = mergeTwoSortedLists(outerList.getIndex(0), outerList.getIndex(1));
			outerList.addBack(combinedFirstTwo);
			outerList.removeIndex(0);
			outerList.removeIndex(0);
		}
		return outerList.getIndex(0);	
	}

}//endClass
