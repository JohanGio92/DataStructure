package collision;

import doublehash.Eratosthenes;

public abstract class OpenAddressing implements Collision {

	protected int sizeTable;
	protected int prime;
	
	protected int probe;
	protected int offset;
	protected int hash;
	
	public OpenAddressing(int sizeTable) {
		this.sizeTable = sizeTable;
		this.sieve();
		probe = 0;
		offset =0;
		hash = 0;
	}

	private void sieve() {
		Eratosthenes erathoEratosthenes = new Eratosthenes(sizeTable);
		erathoEratosthenes.sieve();
		prime = erathoEratosthenes.primes().lastElement();
	}

	@Override
	public int getHash() {
		return hash;
	}

}
