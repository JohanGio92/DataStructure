package collision;

public class QuadraticProbing extends OpenAddressing {

	public QuadraticProbing(int sizeTable) {
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
		hash = (probe + (offset * offset)) % sizeTable;
	}

}
