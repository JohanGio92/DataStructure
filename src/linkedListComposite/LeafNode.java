package linkedListComposite;

public class LeafNode<T extends Comparable<T>> implements ComponentNode<T> {
	
	private ComponentNode<T> next;

	@Override
	public ComponentNode<T> add(T key) {
		return new CompositeNode<>(key, this);
	}

	@Override
	public void display() {
		System.out.println("===========");
	}

	@Override
	public ComponentNode<T> getNext() {
		return next;
	}

	@Override
	public void setNext(ComponentNode<T> next) {
		this.next = next;
	}

	@Override
	public int size() {
		return 0;
	}

	@Override
	public ComponentNode<T> hasNode(T key) {
		return null;
	}

}
