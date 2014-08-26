package org.singly;
public class Main {

	public static void main(String[] args) {
		
		/* Singly Linked List */
		System.out.println("Circular Linked List");
		LinkedList<String> list1 = new LinkedList<String>();

		list1.add("100"); 		list1.add("200"); 		list1.add("300"); 		list1.add("400");

		System.out.println("Size = " + list1.getSize());
		System.out.println(list1);

		list1.addAtPos("784", 4);
		System.out.println("After Add Pos Size = " + list1.getSize());
		System.out.println(list1);

		System.out.println("Element at Position ==> " + list1.getValueAtPos(3));
		System.out.println("Index ==> " + list1.getPosOfValue("200"));
		// list1.removePos(4);
		System.out.println(list1);

		list1.removeByValue("700");
		System.out.println(list1);

		list1.ReverseList();
		System.out.println("Reverse" + list1);

		LinkedList<String> list2 = new LinkedList<String>();
		list2.add("1000");
		list2.add("2000");
		list2.add("3000");
		list2.add("4000");
		System.out.println(list2);
		list1.concatenateLists(list2);

		System.out.println("Concatenate" + list1);
		list1.removeLast();
		System.out.println("Remove Last" + list1);

		/* Remove Duplicates - Unsorted LL */
		LinkedList<String> list3 = new LinkedList<String>();

		list3.add("300");
		list3.add("300");
		list3.add("400");
		list3.add("200");
		list3.add("500");
		System.out.println("List 3- Before" + list3);
		// list3.removeDuplicatesUSLL();
		list3.removeDuplicatesUSLL2();
		list3.removeByValue("500");

		System.out.println("List 3 - After" + list3);

		/* Remove Duplicates - Sorted LL */
		LinkedList<String> list4 = new LinkedList<String>();

		list4.add("100");
		list4.add("300");
		list4.add("300");
		list4.add("400");
		System.out.println("List 4- Before" + list4);
		list4.removeDuplicatesSortLL();

		System.out.println("List 4 - After" + list4);
		
		list4.search("500");
		
	//	list4.addAfterValue("100", "500");
//
		list4.findMtoLastElement(2);

		
	}
}
