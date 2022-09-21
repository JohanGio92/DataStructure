package tree;

public class BinaryTree<T> extends AbstractBinaryTree<T> {
	
	public BinaryTree() {
		super();
	}
	
	public BinaryTree(T data) {
		super(data);
	}

	public void add(T data) {
		this.add(data, root != null ? root : new Node<T>(data));
	}
	
	
	private void add(T data, Node<T> root) {
		queue.add(root);
		ok = false;
		
		while(!queue.isEmpty()) {
			Node<T> current = queue.remove();
			if(!ok) 
				current.left = isEnqueue(data, current.left);
			if(!ok)
				current.right = isEnqueue(data, current.right);
		}
	}
	
	private Node<T> isEnqueue(T data, Node<T> current) {
		if(current == null) {
			current = new Node<T>(data);
			ok = true;
		} else {
			queue.add(current);
		}
		return current;
	}
	
	public boolean has(T data) {
		assert root != null;
		boolean ok = false;
		queue.add(root);

		while(!queue.isEmpty()) {
			Node<T> current = queue.remove();
			if(current.data.equals(data)) {
				ok = true;
			}
			if(!current.isEmptyLeft())
				queue.add(current.left);
			if(!current.isEmptyRight())
				queue.add(current.right);
		}
		return ok;
	}
	
	public void remove(T data) {
		assert has(data);
		Node<T> last = getLastNode();
		queue.add(root);
		Node<T> current;

		while(!queue.isEmpty()) {
			current = queue.remove();
			swap(data, last, current);
			clearLast(last, current);
			if(!current.isEmptyLeft()) {
				queue.add(current.left);
			}
			if(!current.isEmptyRight()) {
				queue.add(current.right);
			}
		}
	}

	private void swap(T data, Node<T> last, Node<T> current) {
		if(current.data.equals(data)) {
			current.data = last.data;
		}
	}

	private void clearLast(Node<T> last, Node<T> current) {
		if(current.left == last) {
			current.left = null;
		}
		if(current.right == last) {
			current.right = null;
		}
	}
	
	public Node<T> getLastNode(){
		queue.add(root);
		Node<T> current = null;
		
		while(!queue.isEmpty()) {
			current = queue.remove();
			if(!current.isEmptyLeft())
				queue.add(current.left);
			if(!current.isEmptyRight())
				queue.add(current.right);
		}
		return current;
	}
	
	public T getLast() {
		return getLastNode().data;
	}

}
