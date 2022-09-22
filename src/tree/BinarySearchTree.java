package tree;

import util.Symbol;

public class BinarySearchTree<T extends Comparable<T>> {
	
	private Node<T> head;
	private int size;
	
	public BinarySearchTree() {
		head = null;
		size = 0;
	}
	
	public BinarySearchTree(T data) {
		head = new Node<T>(data);
		size++;
	}
	
	public void add(T data) {
		head = add(head, data);
	}
	
	public Node<T> add(Node<T> head, T data){
		if(head == null) {
			head = new Node<T>(data);
		} else {
			goLeftOrRight(head, data);
		}
		return head;
	}

	private void goLeftOrRight(Node<T> head, T data) {
		if(Symbol.less(data, head.getData())) {
			head.setLeft(add(head.getLeft(), data));
		} else {
			head.setRight(add(head.getRight(), data));
		}
	}
	
	public Node<T> find(Node<T> head, T data){
		if(head != null) {
			if(Symbol.equal(data, head.getData())) {
				goLeftOrRight(head, data);
			}
		} 
		return head;
	}
	
	public void inOrder() {
		inOrder(head);
	}
	
	public void inOrder(Node<T> head){
		if(head != null) {
			inOrder(head.getLeft());
			System.out.println(head.getData());
			inOrder(head.getRight());
		}
	}
	
}
