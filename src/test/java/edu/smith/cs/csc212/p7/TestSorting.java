package edu.smith.cs.csc212.p7;

import java.util.Arrays;
import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

import edu.smith.cs.csc212.adtr.ListADT;
import edu.smith.cs.csc212.adtr.real.JavaList;

public class TestSorting {
	/**
	 * This is useful for testing whether sort algorithms work!
	 * @param items - the list of integers.
	 * @return true if it is sorted, false if not.
	 */
	private static boolean checkSorted(ListADT<Integer> items) {
		for (int i=0; i<items.size()-1; i++) {
			if (items.getIndex(i) > items.getIndex(i+1)) {
				System.err.println("items out of order: "+items.getIndex(i)+", "+items.getIndex(i+1) + " at index="+i);
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Here's some data!
	 */
	private static int[] data = {9,8,7,6,5,4,3,2,1};
	
	@Test
	public void testBubbleSort() {
		// See if the data can be reversed:
		ListADT<Integer> sortMe = new JavaList<>();
		for (int y : data) {
			sortMe.addBack(y);
		}
		BubbleSort.bubbleSort(sortMe);
		Assert.assertTrue(checkSorted(sortMe));
		
		Random rand = new Random(13);
		// For good measure, let's shuffle it and sort it again to see if that works, too.
		sortMe.shuffle(rand);
		//System.out.println(sortMe.toJava());
		BubbleSort.bubbleSort(sortMe);
		Assert.assertTrue(checkSorted(sortMe));
		//System.out.println(sortMe.toJava());
	}
	
	@Test
	public void testClassBubbleSort() {
		// See if the data can be reversed:
		ListADT<Integer> sortMe = new JavaList<>(Arrays.asList(35, 88, 11, 47, 14, 24, 41, 62, 27));
		
		BubbleSort.bubbleSort(sortMe);
		Assert.assertTrue(checkSorted(sortMe));
	}
	
	@Test
	public void testInsertionSort(){
		ListADT<Integer> sortMe = new JavaList<>(Arrays.asList(35, 88, 11, 47, 14, 24, 41, 62, 27));
		
		InsertionSort.insertionSort(sortMe);
		Assert.assertTrue(checkSorted(sortMe));
		Assert.assertEquals(9, sortMe.toJava().size());
	}
	/**
	 * First test for selection sort where in the same list we are sorting
	 */
	@Test 
	public void testSelectionSort() {
        ListADT<Integer> sortMe = new JavaList<>(Arrays.asList(35, 88, 11, 47, 14, 24, 41, 62, 27));
		
		SelectionSort.selectionSort(sortMe);
		//System.out.println(sortMe.toJava());
		Assert.assertTrue(checkSorted(sortMe));
		System.out.println(sortMe.toJava());
	}
	
	/**
	 * First test for Selection Sort where we have to have two different
	 * lists, one sorted and another unsorted.  
	 */
	@Test
	public void testSelectionSortList() {
		ListADT<Integer> sortMe = new JavaList<>(Arrays.asList(1, 3, 2, 0));
		ListADT<Integer> sorted = SelectionSort.selectionSortList(sortMe);
		Assert.assertTrue(checkSorted(sortMe));
		Assert.assertEquals(4, sorted.size());
		
		System.out.println("The returned list is: " + sorted);
	}
	
	/**
	 * Testing if my helper method to combine two sorted lists works
	 */
	@Test
	public void testMergingTwoSortedLists() {
		ListADT<Integer> list1 = new JavaList<>(Arrays.asList(11, 14, 27, 47));
		ListADT<Integer> list2 = new JavaList<>(Arrays.asList(24, 35, 41, 62, 88));
		
		ListADT<Integer> mergedList = MergeSort.mergeTwoSortedLists(list1, list2);
		
		System.out.println("The merged list: " + mergedList);
		
		Assert.assertTrue(checkSorted(mergedList));
	}
	
	/**
	 * Testing if my helper method to combine two sorted lists works
	 */
	@Test
	public void testMergingTwoSortedLists2() {
		ListADT<Integer> list1 = new JavaList<>(Arrays.asList(100,200,303,456));
		ListADT<Integer> list2 = new JavaList<>(Arrays.asList(162,354, 441,567,588));
		
		ListADT<Integer> mergedList = MergeSort.mergeTwoSortedLists(list1, list2);
		
		System.out.println("The merged list: " + mergedList);
		
		Assert.assertTrue(checkSorted(mergedList));
	}
	
	/**
	 * Testing the recursive merge sort method
	 */
	@Test
	public void testMergeSortRecursive() {
		ListADT<Integer> sortMe1 = new JavaList<>(Arrays.asList(35, 88, 11, 47, 14, 24, 41, 62, 27,100,99));
		
		MergeSort.mergeSortRecursive(sortMe1);
		System.out.println("rMerge: " + sortMe1);
		Assert.assertTrue(checkSorted(sortMe1));
		System.out.println("rMerge: " + sortMe1);
	}


}
