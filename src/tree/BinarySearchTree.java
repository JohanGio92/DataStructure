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
		if(head == null) 
			head = new Node<T>(data);
		else 
			addLeftOrRight(head, data);
		return head;
	}

	private void addLeftOrRight(Node<T> head, T data) {
		if(Symbol.less(data, head.getData()))
			head.setLeft(add(head.getLeft(), data));
		else
			head.setRight(add(head.getRight(), data));
	}
	
	public Node<T> find(T data){
		return find(head, data);
	}
	
	private Node<T> find(Node<T> head, T data) {
		if(head != null) {
			if(Symbol.notEqual(data, head.getData())) {
				head = findLeftOrRight(head, data);
			}
		} 
		return head;
	}

	private Node<T> findLeftOrRight(Node<T> head, T data) {
		if (Symbol.less(data, head.getData())) {
			head = find(head.getLeft(), data);
		} else {
			head = find(head.getRight(), data);
		}
		return head;
	}
	
	public boolean has(T data) {
		return find(data) != null;
	}
	
	public void remove(T data) {
		assert has(data);
		head = remove(head, data);
	}
	
	private Node<T> remove(Node<T> head, T data) {
		if(head == null) {
			return null;
		}
		goLeft(head, data);
		goRight(head, data);
		if(Symbol.equal(data, head.getData())) {
			if(head.leftEmpty() && head.rightEmpty()) {
				head = null;
			}
			else if (head.leftEmpty()) {
				head = head.getRight();
			}
			else if (head.rightEmpty()) {
				head = head.getLeft();
			}
			else {
				Node<T> temporal = getMinNode(head.getRight());
				head.setData(temporal.getData());
				head.setRight(remove(head.getRight(), temporal.getData()));
			}
		}
		return head;
	}

	private void goRight(Node<T> head, T data) {
		if(Symbol.greater(data, head.getData())) {
			head.setRight(remove(head.getRight(), data));
		}
	}

	private void goLeft(Node<T> head, T data) {
		if(Symbol.less(data, head.getData())) {
			head.setLeft(remove(head.getLeft(), data));
		}
	}

	public int getHeight() {
		return getHeight(head);
	}
	
	public int getHeight(Node<T> head) {
		return head == null 
				? 0 
				: Math.max( getHeight(head.getLeft()), getHeight(head.getRight())) + 1;
	}
	
	private Node<T> getMinNode(Node<T> iterator) {
		while (!iterator.leftEmpty()) {
			iterator = iterator.getLeft();
		}
		return iterator;
	}
	
	public T getMin() {
		return getMinNode(head).getData();
	}
	
	private Node<T> getMaxNode(Node<T> iterator){
		while (!iterator.rightEmpty()) {
			iterator = iterator.getRight();
		}
		return iterator;
	}
	
	public T getMax() {
		return getMaxNode(head).getData();
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
