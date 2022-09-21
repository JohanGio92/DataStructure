package tree;

import java.util.LinkedList;
import java.util.Queue;

public abstract class AbstractBinaryTree<T> {

	@SuppressWarnings("hiding")
	class Node<T> {
		T data;
		Node<T> left;
		Node<T> right;

		public Node(T data) {
			this.data = data;
			left = null;
			right = null;
		}
		
		public boolean isEmptyLeft() {
			return left == null;
		}
		
		public boolean isEmptyRight() {
			return right == null;
		}

		public void preOrder() {
			System.out.println(data);
			if(!isEmptyLeft() || !isEmptyRight()) {
				left.preOrder();
				right.preOrder();
			}
		}

		public void inOrder() {
			if(!isEmptyLeft() || !isEmptyRight()) {
				left.preOrder();
				System.out.println(data);
				right.preOrder();
			}
		}
	}
	
	@FunctionalInterface
	interface Predicate<T> {
		public void make(T current);
	}

	protected Node<T> root;
	protected Queue<Node<T>> queue;
	protected boolean ok;

	public AbstractBinaryTree() {
		root = null;
		queue = new LinkedList<>();
		ok = false;
	}

	public AbstractBinaryTree(T data) {
		root = new Node<T>(data);
		queue = new LinkedList<>();
		ok = false;
	}

	public void appendLeft(T data) {
		root.left = new Node<T>(data);
	}

	public void appendRight(T data) {
		root.right = new Node<T>(data);
	}

	public void preOrder() {
		root.preOrder();
	}

	public void inOrder() {
		root.inOrder();
	}
	
	public void levelOrder(Predicate<T> predicate) {
		assert root != null;
		queue.add(root);
		while (!queue.isEmpty()) {
			Node<T> current = queue.remove();
			predicate.make(current.data);
			if(!current.isEmptyLeft()) 
				queue.add(current.left);
			if(!current.isEmptyRight()) 
				queue.add(current.right);
		}
	}
	
	public void levelOrder() {
		levelOrder( data -> System.out.println(data));
	}

}