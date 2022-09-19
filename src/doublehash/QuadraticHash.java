package doublehash;

import collision.Collision;
import collision.QuadraticProbing;

public class QuadraticHash extends Hash {

	@Override
	public Collision createCollision() {
		return new QuadraticProbing(MAX_SIZE);
	}
	
}
