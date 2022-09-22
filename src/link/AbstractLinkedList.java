package link;

public abstract class AbstractLinkedList<E> implements Iterator<E> {

	private static final int EMPTY = 0;
	protected Node<E> head;
	protected int size;
	protected Node<E> iterator;

	public AbstractLinkedList() {
		head = null;
		iterator = null;
		size = 0;
	}

	public boolean isEmpty() {
		return size == EMPTY;
	}

	public void startIterator() {
		iterator = head;
	}

	@Override
	public boolean hasNext() {
		return iterator != null;
	}

	@Override
	public E next() {
		assert hasNext();
		return nextNode().getElement();
	}
	
	protected Node<E> nextNode(){
		assert hasNext();
		Node<E> previous = iterator;
		iterator = iterator.getNext();
		return previous;
	}
	
}