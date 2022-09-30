package linkedListComposite;

public class LinkedList<T extends Comparable<T>> {
	
	ComponentNode<T> head;
	
	public LinkedList(T key) {
		head = new LeafNode<>();
		head = new CompositeNode<>(key, head);
	}
	
	public void add(T key) {
		head = head.add(key);

	}
	
	public void display() {
		head.display();
	}
	
	public int size() {
		return head.size();
	}
	
	private ComponentNode<T> hasNode(T key){
		return head != null 
				? head.hasNode(key) 
				: null;
	}
	
	public boolean has(T key) {
		return hasNode(key) != null;
	}
	
	public boolean hasNext() {
		return head.getNext() != null;
	}
	
	private CompositeNode<T> nextNode(int index) {
		return ((CompositeNode<T>) head).nextNode(index);
	}
	
	public T get(int index) {
		assert 0 <= index && index < this.size();
		return nextNode(index).getKey();
	}
}
