package collision;

public class LinearProbing extends OpenAddressing {

	public LinearProbing(int sizeTable) {
		super(sizeTable);
	}

	@Override
	public void setHash(int number) {
		probe = number % sizeTable;
		offset = 0;
		hash = probe;
	}

	@Override
	public void nextHash() {
		++offset;
		hash = (probe + offset) % sizeTable;
	}

}
