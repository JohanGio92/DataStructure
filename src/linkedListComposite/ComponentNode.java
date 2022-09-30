package linkedListComposite;

public interface ComponentNode<T extends Comparable<T>> {
	
	public ComponentNode<T> getNext();
	public void setNext(ComponentNode<T> next);
	public ComponentNode<T> add(T key);
	public ComponentNode<T> hasNode(T key);
	public void display();
	public int size();
}
