package priorityqueue.array;

import main.Comparator;

public class Item implements Comparator<Item> {
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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		return priority == other.priority;
	}

	@Override
	public boolean lessThan(Item other) {
		if(this.value < other.value)
			return true;
		return false;
	}

	@Override
	public boolean greaterThan(Item other) {
		return other.lessThan(this);
	}

	@Override
	public boolean lessThanEqual(Item other) {
		return !other.lessThan(this);
	}

	@Override
	public boolean greaterThanEqual(Item other) {
		return !this.lessThan(other);
	}

}
