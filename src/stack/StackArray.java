package stack;

import java.util.Vector;

public class StackArray<E> implements Stackeable<E> {
	
	public static final int FULL = 1000;
	public static final int EMPTY = 0;
	
	private Vector<E> vector;
	
	private int size;
	
	public StackArray() {
		this.size = 0;
		this.vector = new Vector<>();
	}
	
	public boolean isEmpty() {
		return this.size == StackArray.EMPTY;
	}
	
	public boolean isFull() {
		return this.size == StackArray.FULL;
	}
	
	//public void push(int data) {
	//	assert !isFull();
	//	this.vector[size++] = data;
	//}
	
	//public int pop() {
	//	assert !isEmpty();
	//	return this.vector[--size];
	//}

	@Override
	public void push(E data) {
		this.vector.add(data);
		++size;
	}

	@Override
	public E pop() {
		assert !isEmpty();
		return vector.remove(--size);
	}
}
