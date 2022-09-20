package disjoint;

public class Node {

	private int data;
	private int height;
	private Node parent;
	
	public Node(int data) {
		this.data = data;
		this.height = 0;
		this.parent = null;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public int getHeight() {
		return height;
	}

	public void increaseHeight() {
		this.height++;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

}
