package collision;

public class DoubleHashing extends OpenAddressing {
	
	public DoubleHashing(int sizeTable) {
		super(sizeTable);
	}

	public void setHash(int number) {
		probe = number % sizeTable;
		offset = prime - (number % prime);
		hash = probe;
	}
	
	public void nextHash() {
		hash = (probe + offset) % sizeTable;
	}
}
