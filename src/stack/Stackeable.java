package stack;

public interface Stackeable<E> {
	
	public boolean isEmpty();
	
	public void push(E data);
	
	public E pop();

	public boolean isFull();
}
