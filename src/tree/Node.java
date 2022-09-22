package tree;

import java.util.Objects;

public class Node<T extends Comparable<T>> {
	
	private Node<T> left;
	private Node<T> right;
	private T data;
	
	public Node(T data) {
		this.data = data;
	}

	public Node<T> getLeft() {
		return left;
	}

	public void setLeft(Node<T> left) {
		this.left = left;
	}

	public Node<T> getRight() {
		return right;
	}

	public void setRight(Node<T> right) {
		this.right = right;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	public boolean isEmpty(Node<T> node) {
		return node == null;
	}
	
	public boolean leftEmpty() {
		return isEmpty(left);
	}

	public boolean rightEmpty() {
		return isEmpty(right);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node<T> other = (Node<T>) obj;
		return Objects.equals(data, other.data) && Objects.equals(left, other.left)
				&& Objects.equals(right, other.right);
	}
	
	public Node<T> copy(){
		Node<T> copiedNode = new Node<T>(this.data);
		return copiedNode;
	}
}
