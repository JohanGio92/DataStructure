package link;

public class LinkedList<E> implements Iterator<E> {
	
	private Node<E> head;

	@Override
	public boolean hasNext() {
		return false;
	}

	@Override
	public E next() {
		return null;
	}
}
