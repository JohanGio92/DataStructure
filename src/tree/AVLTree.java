package tree;

public class AVLTree<E extends Comparable<E>> {
	
	private Node<E> root;
	private int size;
	
	public AVLTree() {
		size = 0;
		root = null;
	}
	
	public void add(E element) {
		Node<E> newChild = new Node<E>(element);
		if(root != null) {
			root = add(root, newChild);
		} else {
			root = newChild;
		}
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

	private Node<E> checkBalance(Node<E> newChild) {
		if(!hasHeightBalance(newChild)) {
			newChild = rebalance(newChild);
		}
		return newChild;
	}

	private Node<E> rebalance(Node<E> newChild) {
		if(height(newChild.leftChild()) - height(newChild.rightChild()) > 1) {
			if(height(newChild.leftChild().leftChild()) > height(newChild.leftChild().rightChild())) {
				newChild = rightRotation(newChild);
			}
			else {
				newChild = leftRightRotation(newChild);
			}
		} else {
			if(height(newChild.rightChild().rightChild()) > height(newChild.rightChild().leftChild())) {
				newChild = leftRotation(newChild);
			}
			else {
				newChild = rightLeftRotation(newChild);
			}
		}
		return newChild;
	}

	private boolean hasHeightBalance(Node<E> newChild) {
		return Math.abs(height(newChild.leftChild()) - height(newChild.rightChild())) <= 1;
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
}
