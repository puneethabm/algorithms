package org.singly;

import java.util.Hashtable;


public class LinkedList<Type> {
	protected Node<Type> first = null;
	protected int size = 0;

	public int getSize() {
		return size;
	}

	public void add(Type value) {
		addLast(value);
	}

	/* Add - functions (First, last, pos, value) */
	public void addFirst(Type value) {
		Node<Type> temp = new Node<Type>(value, first);
		first = temp;
		size++;
	}

	public void addLast(Type value) {
		Node<Type> temp = new Node<Type>(value);
		if (first == null) {
			first = temp;
		} else {
			Node<Type> cur = first;

			while (cur.getNext() != null) {
				cur = cur.getNext();
			}
			cur.setNext(temp);
		}
		size++;
	}

	public void addAtPos(Type value, int pos) throws IndexOutOfBoundsException {
		Node<Type> temp = new Node<Type>(value);

		// Make sure the index is valid
		if (pos < 0 || pos > getSize()) {
			throw new IndexOutOfBoundsException();
		}

		if (first == null && pos == 1) {
			first = temp;
			size++;
			return;
		}

		if (first == null) {
			System.out.println("Invalid Pointer");
			return;
		}

		if (pos == 1) {
			temp.setNext(first);
			first = temp;
			size++;
			return;
		}

		// Step to the place where the new element is to be placed
		Node<Type> prev = null;
		Node<Type> cur = first;

		int count = 1;
		while (cur != null && count != pos) {
			prev = cur;
			cur = cur.getNext();
			count++;
		}

		if (count == pos) {
			prev.setNext(temp);
			temp.setNext(cur);
			size++;
			return;
		}
		System.out.println("Invalid Pointer");
	}

	public void addAfterValue(Type afterValue, Type valueToBeAdded){
		Node<Type> temp = new Node<Type>(valueToBeAdded);
		
		if(first == null){
			System.out.println("List is empty");
			return;
		}
		
		Node<Type> prev = null;
		Node<Type> cur = first;
		
		while (cur.getNext() != null && afterValue != cur.getValue()) {
			prev = cur;
			cur = cur.getNext();
		}
		
		if(afterValue == cur.getValue()){
			prev.setNext(temp);
			temp.setNext(cur);
			size++;	
			return;
		}
		
		System.out.println("Element not found");
	}
	
	
	/* Get Methods */
	public Type getValueAtPos(int pos) throws IndexOutOfBoundsException {
		Node<Type> cur = first;

		if (pos < 0 || pos >= getSize()) {
			throw new IndexOutOfBoundsException();
		}

		int count = 1;
		// Find the element
		while (cur != null && count != pos) {
			cur = cur.getNext();
			count++;
		}

		if (count == pos) {
			return cur.getValue();
		} else {
			return null;
		}
	}

	/* Remove */
	public void removeFirst() {
		if (first == null) {
			System.out.println("List is Empty");
			return;
		}

		first = first.getNext();
		;
		size--;
	}

	public void removeLast() {
		Node<Type> prev, cur;
		if (first == null) {
			System.out.println("List is Empty");
			return;
		}

		prev = null;
		cur = first;

		while (cur.getNext() != null) {
			prev = cur;
			cur = cur.getNext();
		}

		prev.setNext(null);
		// System.out.println("Deleted Element is: "+ cur.getValue());
		size--;
	}

	public void removePos(int pos) throws IndexOutOfBoundsException {
		Node<Type> prev = null;
		Node<Type> cur = first;

		// Make sure the index is valid

		if (pos < 0 || pos > getSize()) {
			throw new IndexOutOfBoundsException();
		}

		// Step to the place where the new element is to be placed

		int count = 1;
		while (cur != null && count != pos) {
			prev = cur;
			cur = cur.getNext();
			count++;
		}

		if (count == pos) {
			prev.setNext(cur.getNext());
			size--;
			return;
		}
	}

	public void removeByValue(Type value) {
		Node<Type> prev = null;
		Node<Type> cur = first;

		if (first == null) {
			System.out.println("List is empty");
			return;
		}
		cur = first;

		if (value == first.getValue()) {
			first = first.getNext();
			return;
		}

		while (cur.getNext() != null) {
			if (cur.getValue() == value)
				break;
			prev = cur;
			cur = cur.getNext();
		}

		if (cur == null) {
			System.out.println("Search was unsuccessful");
			return;
		}
		prev.setNext(cur.getNext());

		size++;
	}

	public int getPosOfValue(Type value) {
		Node<Type> cur = first;

		if (first == null) {
			System.out.println("List if Empty");
			return -1;
		}

		int pos = 1;
		while (cur != null && value != cur.getValue()) {
			cur = cur.getNext();
			pos++;
		}

		if (value == cur.getValue()) {
			return pos;
		} else {
			return -1;
		}
	}

	public void search(Type key) {
		Node<Type> cur;
		if (first == null) {
			System.out.println("List is Empty");
			return;
		}

		cur = first;

		while (cur != null && key != cur.getValue()) {
			cur = cur.getNext();
		}

		if (key == cur.getValue()) {
			System.out.println("Search is successfully");
			return;
		}

		System.out.println("Search is Unsuccessfully");
	}

	/* Concatenate Lists */
	public void concatenateLists(LinkedList<Type> list2) {

		if (first == null) {
			first = list2.first;
			return;
		}

		if (list2.first == null) {
			return;
		}

		Node<Type> cur = first;
		while (cur.getNext() != null) {
			cur = cur.getNext();
		}

		cur.setNext(list2.first);

	}

	/* Reverse List */
	public void ReverseList() {
		Node<Type> cur, temp;

		temp = null;

		while (first != null) {
			cur = first;
			first = first.getNext();
			cur.setNext(temp);
			temp = cur;
		}
		first = temp;
	}

	/* Display */
	public String display() {
		StringBuilder listBldr = new StringBuilder();

		Node<Type> temp = first;

		listBldr.append("[ ");

		while (temp != null) {
			listBldr.append(temp.getValue());
			temp = temp.getNext();
			if (temp != null) {
				listBldr.append(" -> ");
			}
		}

		listBldr.append(" ]");

		return listBldr.toString();
	}

	@Override
	public String toString() {
		return display();
	}

	/* Other Methods */
	/* Remove Duplicates from Unsorted Linked Lists */
	/* With temporary table */
	public void removeDuplicatesUSLL() {
		Hashtable table = new Hashtable();
		Node<Type> prev, cur;
		prev = null;
		cur = first;

		while (cur.getNext() != null) {
			if (table.containsKey(cur.getValue()))
				prev.setNext(cur.getNext());
			else {
				table.put(cur.getValue(), true);
				prev = cur;
			}
			cur = cur.getNext();
		}

	}

	/* Unsorted LL -- Without temporary table - only using pointers */
	public void removeDuplicatesUSLL2() {
		if (first == null)
			return;

		Node<Type> prev = null;
		Node<Type> cur = first;
		while (cur.getNext() != null) {
			Node<Type> runner = first;
			while (runner != cur) { 
				if (runner.getValue() == cur.getValue()) {
					Node<Type> tmp = cur.getNext(); 
					prev.setNext(tmp);
					cur = tmp; 
					break; 
				}
				runner = runner.getNext();
			}
			if (runner == cur) { 
				prev = cur;
				cur = cur.getNext();
			}
		}
	}

	/* Remove Duplicates from Sorted Linked Lists */
	public void removeDuplicatesSortLL() {
		if (first == null) {
			System.out.println("List is empty");
			return;
		}

		Node<Type> prev, cur;
		prev = null;
		cur = first;

		while (cur.getNext() != null) {
			if (cur.getValue() == cur.getNext().getValue()) {
				prev = cur.getNext().getNext();
				cur.setNext(prev);
			} else
				cur = cur.getNext();
		}
	}

	/* Mth to Last element in a Linked List */
	public void findMtoLastElement(int m) {
		if (first == null) {
			System.out.println("List is empty");
			return;
		}

		Node<Type> cur, mBehind;
		cur = first;
		for (int i = 0; i < m; i++) {
			if (cur.getNext() != null) {
				cur = cur.getNext();
			} else {
				System.out
						.println("Entered mth element is greater than length of list");
				return;
			}
		}

		mBehind = first;
		while (cur.getNext() != null) {
			cur = cur.getNext();
			mBehind = mBehind.getNext();
		}

		System.out.println("Mth Behind Element is " + mBehind.getValue());
	}

}
