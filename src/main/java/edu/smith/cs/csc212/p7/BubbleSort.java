package edu.smith.cs.csc212.p7;

import edu.smith.cs.csc212.adtr.ListADT;

/**
 * BubbleSort is a simple sort that is O(n^2).
 * @author jfoley
 *
 */
public class BubbleSort {

	/**
	 * Bubble Sort is done! And it is easy to do in-place.
	 * @param input - the list to be sorted.
	 */
	public static void bubbleSort(ListADT<Integer> input) {
		int N = input.size();
		
		while(true) {
			boolean sorted = true;
			for (int i=0; i<N-1; i++) {
				if (input.getIndex(i) > input.getIndex(i+1)) {
					input.swap(i, i+1);
					sorted = false;
				}
			}
			if (sorted) {
				break;
			}
			N = N - 1;
		}
	}
}
