package tree;

public class Node<E extends Comparable<E>> {

	private Node<E> leftChild;
	private Node<E> rightChild;
	private E element;

	public Node(E element) {
		this.element = element;
		leftChild = null;
		rightChild = null;
	}

	public Node<E> leftChild() {
		return leftChild;
	}

	public void leftChild(Node<E> left) {
		this.leftChild = left;
	}

	public Node<E> rightChild() {
		return rightChild;
	}

	public void rightChild(Node<E> right) {
		this.rightChild = right;
	}

	public E getElement() {
		return element;
	}

	public void setElement(E element) {
		this.element = element;
	}

	
	public Node<E> rightRotation(){
		Node<E> parent = this.leftChild;
		this.leftChild = parent.rightChild;
		parent.rightChild = this;
		return parent;
	}
	
	public Node<E> leftRotation(){
		Node<E> parent = this.rightChild;
		this.rightChild = parent.leftChild;
		parent.leftChild = this;
		return parent;
	}
	
	public Node<E> rightLeftRotation(){
		this.rightChild = this.rightChild.rightRotation();
		return this.leftRotation();
	}
	
	public Node<E> leftRightRotation() {
		this.leftChild = this.leftChild.leftRotation();
		return this.leftRotation();
	}
	
	public boolean isEmpty(Node<E> node) {
		return node == null;
	}

	public boolean isLeftEmpty() {
		return isEmpty(leftChild);
	}

	public boolean isRightEmpty() {
		return isEmpty(rightChild);
	}

	public void inOrder() {
		if(leftChild != null) 
			leftChild.inOrder();
		System.out.println(element);
		if(rightChild != null)
			rightChild.inOrder();
		
	}

	public void preOrder() {
		System.out.println(element);
		if(leftChild != null) 
			leftChild.inOrder();
		if(rightChild != null)
			rightChild.inOrder();
		
	}
}
