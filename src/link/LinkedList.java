package link;

public class LinkedList<E> extends AbstractLinkedList<E> implements Copyable<LinkedList<E>> {
	
	protected static final int FIRST = 0;

	public LinkedList() {
		super();
	}
	
	public LinkedList(LinkedList<E> list) {
		LinkedList<E> copied = list.copy();
		head = copied.head;
		iterator = copied.iterator;
		size = copied.size;
	}
	
	public int size() {
		return size;
	}
	
	public void add(E element) {
		add(element, size);
	}
	
	public void add(E element, int index) {
		assert (0 <= index && index <= size);
		startIterator();
		Node<E> newNode = new Node<E>(element);

		if (index == 0) {
			newNode.setNext(head);
			head = newNode;
		}
		else {
			Node<E> previous = getNode(index - 1);
			newNode.setNext(previous.getNext());
			previous.setNext(newNode);
		}
		size++;
		startIterator();
	}
	
	public void remove(int index) {
		assert (0 <= index && index < size);
		Node<E> removedNode;
		
		if(index == FIRST) {
			removedNode = head;
			head = removedNode.getNext();
		} 
		else {
			Node<E> previous = getNode(index - 1);
			removedNode = previous.getNext();
			previous.setNext(removedNode.getNext());
		}
		size--;
		startIterator();
	}
	
	public E get(int index) {
		return getNode(index).getElement();
	}
	
	private Node<E> getNode(int index){
		for (int i = 0; i < index; i++) {
			nextNode();
		}
		return iterator;
	}

	@Override
	public LinkedList<E> copy() {
		startIterator();
		LinkedList<E> copiedLinkList = new LinkedList<>();
		while (hasNext()) {
			copiedLinkList.add(next());
		}
		startIterator();
		return copiedLinkList;
	}
	
	public Iterator<E> iterate(){
		return this;
	}
}
