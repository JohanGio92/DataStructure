package linkedListComposite;

public class CompositeNode<T extends Comparable<T>> implements ComponentNode<T> {
	
	private ComponentNode<T> next;
	private T key;
	
	public CompositeNode(T key) {
		this(key, null);
	}

	public CompositeNode(T key, ComponentNode<T> next) {
		this.key = key;
		this.next = next;
	}

	@Override
	public ComponentNode<T> add(T key) {
		next = next.add(key);
		return this;
	}

	public ComponentNode<T> getNext() {
		return next;
	}

	public void setNext(ComponentNode<T> next) {
		this.next = next;
	}

	public T getKey() {
		return key;
	}

	public void setKey(T key) {
		this.key = key;
	}

	@Override
	public void display() {
		System.out.println(key);
		next.display();
	}

	@Override
	public int size() {
		return this.next.size() + 1;
	}

	@Override
	public ComponentNode<T> hasNode(T key) {
		return (this.key == key) 
				? this 
				: this.next.hasNode(key);
	}
	
	public CompositeNode<T> nextNode(int index){
		return index != 0
				? ((CompositeNode<T>) next).nextNode(index - 1)
				: this;
	}
	
}
