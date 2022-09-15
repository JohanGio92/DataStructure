package queue;

public class ArrayQueue {

	public static final int EMPTY = 0;
	public static final int FULL = 1000;
	
	private int[] vector;
	private int size;
	
	public ArrayQueue() {
		vector = new int[FULL];
		size = 0;
	}
	
	public boolean isEmpty() {
		return size == EMPTY;
	}
	
	public boolean isFull() {
		return size == FULL;
	}
	
	public void enqueue(int data) {
		assert !isFull();
		if (isEmpty()) {
			vector[size++] = data;
		} else {
			this.shift();
			vector[EMPTY] = data;
		}
	}
	
	private void shift() {
		int offset = size;
		while (offset >= 1) {
			vector[offset] = vector[offset - 1];
			offset--;
		}
		size++;
	}
	
	public int dequeue() {
		return vector[--size];
	}
	
}
