package org.singly;
public class Node<Type> {
	private Type value;
	private Node<Type> next;

	public Node() {
	}

	public Node(Type value, Node<Type> next) {
		this.value = value;
		this.next = next;
	}

	public Node(Type value) {
		this.value = value;
		this.next = null;
	}

	public Type getValue() {
		return value;
	}

	public Node<Type> getNext() {
		return next;
	}

	public void setValue(Type value) {
		this.value = value;
	}

	public void setNext(Node<Type> next) {
		this.next = next;
	}
}
