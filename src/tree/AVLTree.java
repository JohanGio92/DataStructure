package tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AVLTree<E extends Comparable<E>> {
	
	private static final int BALANCE = 1;
	private Node<E> root;
	private int size;
	
	public AVLTree() {
		size = 0;
		root = null;
	}
	
	public boolean has(E element) {
		return hasNode(element) != null;
	}
	
	private Node<E> hasNode(E element) {
		return hasNode(root, element);
	}
	
	private Node<E> hasNode(Node<E> parent, E element) {
		if(parent == null) {
			return null;
		}
		
		if(element.compareTo(parent.getElement()) > 0) {
			parent = hasNode(parent.rightChild(), element);
		}
		else if(parent.getElement().compareTo(element) > 0) {
			parent = hasNode(parent.leftChild(), element);
		}
		
		return parent;
	}
	
	public void remove(E element) {
		assert has(element);
		root = remove(root, element);
		--size;
	}

	private Node<E> remove(Node<E> parent, E element) {
		
		if(element.compareTo(parent.getElement()) > 0) {
			parent.rightChild(remove(parent.rightChild(), element));
		}
		else if(parent.getElement().compareTo(element) > 0) {
			parent.leftChild(remove(parent.leftChild(), element));
		}
		else {
			if(parent.isLeftEmpty() && parent.isRightEmpty()) {
				parent = null;
			} else if (parent.isLeftEmpty()) {
				parent = parent.rightChild();
			} else if (parent.isRightEmpty()) {
				parent = parent.leftChild();
			} else {
				Node<E> minNode = minNode(parent.rightChild());
				parent.setElement(minNode.getElement());
				parent.rightChild(remove(parent.rightChild(), minNode.getElement()));
			}
		}
		
		return parent == null ? parent : checkBalance(parent);
	}
	
	private Node<E> minNode(Node<E> iterator) {
		while (!iterator.isLeftEmpty()) {
			iterator = iterator.leftChild();
		}
		return iterator;
	}

	public void add(E element) {
		Node<E> newChild = new Node<E>(element);
		root = root != null ? add(root, newChild) : newChild;
		size++;
	}
	
	private Node<E> add(Node<E> parent, Node<E> newChild) {
		if(newChild.getElement().compareTo(parent.getElement()) > 0) {
			if(parent.isRightEmpty()) {
				parent.rightChild(newChild);
			} else {
				parent.rightChild(add(parent.rightChild(), newChild));
			}
		} 
		else {
			if(parent.isLeftEmpty()) {
				parent.leftChild(newChild);
			} else {
				parent.leftChild(add(parent.leftChild(), newChild));
			}
		}
		return checkBalance(parent);
	}

	private Node<E> checkBalance(Node<E> parent) {
		if(!hasHeightBalance(parent)) {
			parent = rebalance(parent);
		}
		return parent;
	}

	private Node<E> rebalance(Node<E> grandParent) {
		if(height(grandParent.leftChild()) - height(grandParent.rightChild()) > BALANCE) {
			if(height(grandParent.leftChild().leftChild()) > height(grandParent.leftChild().rightChild())) {
				grandParent = rightRotation(grandParent);
			}
			else {
				grandParent = leftRightRotation(grandParent);
			}
		} else {
			if(height(grandParent.rightChild().rightChild()) > height(grandParent.rightChild().leftChild())) {
				grandParent = leftRotation(grandParent);
			}
			else {
				grandParent = rightLeftRotation(grandParent);
			}
		}
		return grandParent;
	}

	private boolean hasHeightBalance(Node<E> parent) {
		return Math.abs(height(parent.leftChild()) - height(parent.rightChild())) <= BALANCE;
	}
	
	private int height(Node<E> parent) {
		if(parent == null)
			return 0;
		return Math.max(height(parent.leftChild()), height(parent.rightChild())) + 1;
	}

	private Node<E> rightRotation(Node<E> grandParent){
		Node<E> parent = grandParent.leftChild();
		grandParent.leftChild(parent.rightChild());
		parent.rightChild(grandParent);
		return parent;
	}
	
	private Node<E> leftRotation(Node<E> grandParent) {
		Node<E> parent = grandParent.rightChild();
		grandParent.rightChild(parent.leftChild());
		parent.leftChild(grandParent);
		return parent;
	}
	
	private Node<E> rightLeftRotation(Node<E> grandParent){
		grandParent.rightChild(rightRotation(grandParent.rightChild()));
		return leftRotation(grandParent);
	}
	
	private Node<E> leftRightRotation(Node<E> grandParent){
		grandParent.leftChild(leftRotation(grandParent.leftChild()));
		return rightRotation(grandParent);
	}
	
	public void inOrder() {
		root.inOrder();
	}

	public void preOrder() {
		root.preOrder();
	}
	
	public void levelOrder() {
		levelOrder(root);
	}
	
	private void levelOrder(Node<E> parent) {
		Queue<Node<E>> queue = new LinkedList<>();
		queue.add(parent);
		while(!queue.isEmpty()){
			Node<E> current = queue.remove();
			System.out.println(current.getElement());
			if(!current.isLeftEmpty())
				queue.add(current.leftChild());
			if(!current.isRightEmpty())
				queue.add(current.rightChild());
		}
	}

	public int size() {
		return size;
	}
}
