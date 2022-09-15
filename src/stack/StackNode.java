package stack;

public class StackNode {
	
	public StackNode link;
	private int data;
	
	
	public StackNode(int data) {
		this.data = data;
		this.link = null;
	}
	
	public StackNode getLink() {
		return link;
	}
	public int getData() {
		return data;
	}
	public void setLink(StackNode link) {
		this.link = link;
	}
	public void setData(int data) {
		this.data = data;
	}
}
