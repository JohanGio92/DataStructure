package priorityqueue.array;

public class Item {
	private int value;
	private int priority;
	
	public Item(int value, int priority) {
		this.value = value;
		this.priority = priority;
	}
	
	public int getValue() {
		return value;
	}
	public int getPriority() {
		return priority;
	}
}
