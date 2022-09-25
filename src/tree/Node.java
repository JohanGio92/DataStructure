package tree;

public class Node<E extends Comparable<E>> {

	private Node<E> left;
	private Node<E> right;
	private E element;

	public Node(E element) {
		this.element = element;
		left = null;
		right = null;
	}

	public Node<E> getLeft() {
		return left;
	}

	public void setLeft(Node<E> left) {
		this.left = left;
	}

	public Node<E> getRight() {
		return right;
	}

	public void setRight(Node<E> right) {
		this.right = right;
	}

	public E getElement() {
		return element;
	}

	public void setElement(E element) {
		this.element = element;
	}
	
}
