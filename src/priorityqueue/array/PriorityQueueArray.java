package priorityqueue.array;

public class PriorityQueueArray {
	
	private static final int FULL = 10000;
	private static final int EMPTY = 0;

	private Item[] items;
	private int size = 0;
	
	public PriorityQueueArray() {
		items = new Item[FULL];
		size = 0;
	}
	
	public boolean isEmpty() {
		return size == EMPTY;
	}
	
	public boolean isFull() {
		return size == FULL;
	}
	
	public void enqueue(int value, int priority) {
		items[size++] = new Item(value, priority);
	}
	
	private int peekIndex() {
		int index = this.highPriorityIndex();
		
		for (int i = 0; i < size; i++) {
			if(items[i].getPriority() == items[index].getPriority()) {
				if(items[i].getValue() > items[index].getValue()) {
					index = i;
				}
			}
		}
		return index;
	}

	
	private int highPriorityIndex() {
		int highPriority = Integer.MIN_VALUE;
		int index = -1;

		for (int i = 0; i < size; i++) {
			if(items[i].getPriority() >= highPriority) {
				highPriority = items[i].getPriority();
				index = i;
			}
		}
		return index;
	}
	
	public int peek() {
		return items[peekIndex()].getValue();
	}
	
	public int dequeue() {
		int index = peekIndex();
		int data = items[index].getValue();
		 
	    for (int i = index; i < size - 1; i++) {
	    	items[index] = items[index + 1];
	    }
	    size--;
	    return data;
	}
}
