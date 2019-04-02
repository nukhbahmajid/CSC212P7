package edu.smith.cs.csc212.adtr.real;

import edu.smith.cs.csc212.adtr.ListADT;
import edu.smith.cs.csc212.adtr.errors.BadIndexError;
import edu.smith.cs.csc212.adtr.errors.EmptyListError;

public class SinglyLinkedList<T> extends ListADT<T> {
	/**
	 * The start of this list.
	 * Node is defined at the bottom of this file.
	 */
	public Node<T> start;
	
	@Override
	public T removeFront() {
		checkNotEmpty();
		T temp = this.getIndex(0);
		start = start.next; 
		return temp; 

	}

	@Override
	public T removeBack() {
		if (this.size() == 0) {
			throw new EmptyListError(); 
		} else if(this.size() == 1) {
			T temp = start.value;
			start = null; 
			return temp;
		} else {
			Node<T> pointer = start; 
			Node<T> end = start; 
			
			for(Node<T> current = start; current.next != null; current = current.next) {
				pointer = current;
				end = current.next; 
			}
			
			pointer.next = null;
			return end.value; 
			
		}
		
	}

	@Override
	public T removeIndex(int index) {
		checkNotEmpty();
		int counter = 0;
		Node<T> target = start; 
		Node<T> targetPrevious = start; 
		Node<T> pointer = start; 
		
		if (index < 0 || index > this.size() -1) {
			throw new BadIndexError(index);
		} else if (index == 0){ 
			removeFront();
		} else {
			
			for (int i = 0; i< this.size(); i++) {
				if (counter == index -1) {
					targetPrevious = pointer; 
				}
				
				if (counter == index) {
					target = pointer;
					break;
				}
				pointer = pointer.next;
				counter ++; 
			}
		}
		targetPrevious.next = target.next; 
		return target.value; 
		
	}

	@Override
	public void addFront(T item) {
		this.start = new Node<T>(item, start);
	}

	@Override
	public void addBack(T item) {
		if (this.size() == 0) {
			this.start = new Node<T>(item, null);
			return;
		}
		
		Node<T> end = start;
		while(end.next != null) {
			end = end.next;
		}
		end.next = new Node<T>(item, null); 
	}

	@Override
	public void addIndex(int index, T item) {
		checkNotEmpty();
		
		if (index > this.size() || index < 0) {
			throw new BadIndexError(index);
		}
		
		int counter = 0;
		if (index == 0) {
			addFront(item);
			return;
		}
		
		if (index == this.size()) {
			addBack(item);
			return;
		}
		
		// Node before the index desired
		Node<T> prevNode = start; 
		// Node after the index desired 
		Node<T> nextNode = start; 
		// the current node
		Node<T> pointer = start;
		
		for(Node<T> node = start; node != null; node = node.next) {
			if (counter == index - 1) {
				prevNode = pointer; 
			}
			
			if (counter == index) {
				nextNode = pointer;
			}
			
			pointer = pointer.next;
			counter++;
		}
		
		Node<T> desiredNode = new Node<T>(item, nextNode);
		prevNode.next = desiredNode;	
	}
	
	
	
	@Override
	public T getFront() {
		checkNotEmpty();
		return this.start.value;
	}

	@Override
	public T getBack() {
		checkNotEmpty(); 
		return this.getIndex(this.size() - 1); 
	}

	@Override
	public T getIndex(int index) {
		checkNotEmpty();
		int at = 0;
		for (Node<T> n = this.start; n != null; n = n.next) {
			if (at++ == index) {
				return n.value;
			}
		}
		throw new BadIndexError(index);
	}
	 

	@Override
	public void setIndex(int index, T value) {
		checkNotEmpty();
		
		if (index >= this.size() || index < 0) {
			throw new BadIndexError(index);
		}
		
		int counter = 0;
		Node<T> pointer = start;
		Node<T> targetNode = start;
		
		for (Node<T> node = this.start; node != null; node = node.next) {
			if (counter == index) {
				targetNode = pointer;
			}
			
			pointer = pointer.next;
			counter++;
		}
		targetNode.value = value;
	}

	@Override
	public int size() {
		int count = 0;
		for (Node<T> n = this.start; n != null; n = n.next) {
			count++;
		}
		return count;
	}

	@Override
	public boolean isEmpty() {
		return this.start == null;
	}
	
	/**
	 * The node on any linked list should not be exposed.
	 * Static means we don't need a "this" of SinglyLinkedList to make a node.
	 * @param <T> the type of the values stored.
	 */
	public static class Node<T> {
		/**
		 * What node comes after me?
		 */
		public Node<T> next;
		/**
		 * What value is stored in this node?
		 */
		public T value;
		/**
		 * Create a node with no friends.
		 * @param value - the value to put in it.
		 */
		public Node(T value, Node<T> next) {
			this.value = value;
			this.next = next;
		}
		
	}
	

}
