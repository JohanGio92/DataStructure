package stack;

public class StackLinkedList {
	
	private StackNode root;
	private StackNode iterator;
	private int size;
	
	public StackLinkedList(int data) {
		this.root = new StackNode(data);
		this.iterator = root;
		this.size++;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void push(int data) {

		while (iterator.getLink() != null) {
			iterator = iterator.getLink();
		}

		StackNode newNode = new StackNode(data);
		iterator.setLink(newNode);
		++size;
		iterator = root;
	}
	
	public int pop() {
		assert !isEmpty();

		int data;

		if(size == 1) {
			data = iterator.getData();
			iterator = null;
		}
		else {
			for (int i = 1; i < size() - 1; i++) {
				iterator = iterator.getLink();
			}
			data = iterator.getLink().getData();
			iterator.setLink(null);
		}
		iterator = root;
		size--;

		return data;
	}
	
	public int size() {
		return size;
	}
}
