package link;

public class Node<E> {
	
	private E element;
	private Node<E> next;

	public Node(E data) {
		super();
		this.element = data;
		this.next = null;
	}

	public E getElement() {
		return element;
	}

	public void setElement(E element) {
		this.element = element;
	}

	public Node<E> getNext() {
		return next;
	}

	public void setNext(Node<E> next) {
		this.next = next;
	}
	
}
