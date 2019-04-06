package edu.smith.cs.csc212.p7;
import edu.smith.cs.csc212.adtr.ListADT;
import edu.smith.cs.csc212.adtr.real.JavaList;
import edu.smith.cs.csc212.adtr.real.DoublyLinkedList;


public class MergeSortDLL {
	public DoublyLinkedList<ListADT<Integer>> mergedList;
	
	
	public MergeSortDLL() {
		mergedList = new DoublyLinkedList<>();
	}
	
	public ListADT<Integer> mergeDLL(ListADT<Integer> input) {
		int i = 0;
		for(int each : input) {
			ListADT<Integer> newGLL = new JavaList<Integer>();
		    newGLL.addBack(input.getIndex(i));
		    this.mergedList.addBack(newGLL);
		    i++;
		}
		
		while(this.mergedList.size() >= 2) {
			ListADT<Integer> firstSorted = MergeSort.mergeTwoSortedLists(this.mergedList.getFront(), this.mergedList.getIndex(1));
			this.mergedList.addBack(firstSorted);
			this.mergedList.removeFront();
			this.mergedList.removeFront();
			i = 0;
		}
		return this.mergedList.getIndex(0);
	}

}
