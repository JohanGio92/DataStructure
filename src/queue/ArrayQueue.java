package queue;

public class ArrayQueue<T> {

	public static final int EMPTY = 0;
	public static final int FULL = 1000;
	
	private T[] vector;
	private int size;
	
	@SuppressWarnings("unchecked")
	public ArrayQueue() {
		vector = (T[]) new Object[FULL];
		size = 0;
	}
	
	public boolean isEmpty() {
		return size == EMPTY;
	}
	
	public boolean isFull() {
		return size == FULL;
	}
	
	public void enqueue(T data) {
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
	
	public T dequeue() {
		return vector[--size];
	}
	
}
