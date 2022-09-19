package doublehash;

import collision.Collision;
import collision.LinearProbing;

public class LinearHash extends Hash {

	public LinearHash(int tableSize) {
		super(tableSize);
	}

	@Override
	public Collision createCollision() {
		return new LinearProbing(MAX_SIZE);
	}

}
