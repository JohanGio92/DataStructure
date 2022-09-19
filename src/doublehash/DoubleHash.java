package doublehash;

import collision.Collision;
import collision.DoubleHashing;

public class DoubleHash extends Hash {
	
	@Override
	public Collision createCollision() {
		return new DoubleHashing(MAX_SIZE);
	}

}
