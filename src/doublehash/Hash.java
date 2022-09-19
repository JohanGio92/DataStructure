package doublehash;

import java.util.Vector;

import collision.Collision;

public abstract class Hash {

	protected static int MAX_SIZE = 1000;
	protected int keyPresent;
	protected Vector<Integer> hashTable;
	protected Vector<State> states;
	protected Collision collision;
	
	
	protected Hash(int table_size) {
		MAX_SIZE = table_size;
		this.keyPresent = 0;
		this.fill();
		collision = createCollision();
	}
	
	protected Hash() {
		this(MAX_SIZE);
	}
	
	public abstract Collision createCollision();

	private void fill() {
		hashTable = new Vector<>();
		states = new Vector<>();
		for (int i = 0; i < MAX_SIZE; i++) {
			states.add(State.EMPTY);
			hashTable.add(0);
		}
	}
	
	public boolean isFull() {
		return MAX_SIZE == keyPresent;
	}
	
	private State currentState() {
		return states.elementAt(collision.getHash());
	}

	private Integer currentHasTable() {
		return hashTable.elementAt(collision.getHash());
	}

	public void add(int number) {
		assert !isFull();

		if(contain(number))
			return;

		collision.setHash(number);
		boolean ok = false;

		while (currentState() != State.EMPTY  && !ok) {
			if(currentState() == State.DELETED) {
				ok = true;
			} else {
				collision.nextHash();
			}
		}
		hashTable.set(collision.getHash(), number);
		states.set(collision.getHash(), State.INSERTED);
		keyPresent++;
	}

	public void remove(int number) {
		boolean ok = contain(number);
		assert ok;

		collision.setHash(number);
		ok = false;

		while(currentState() != State.EMPTY && !ok) {
			if(currentHasTable() == number){
				states.set(collision.getHash(), State.DELETED);
				keyPresent--;
				ok  = true;
			}
			collision.nextHash();
		}
	}

	public boolean contain(int number) {
		collision.setHash(number);

        boolean isSearched = false;
        boolean ok = false;
 
        while(!ok){
        	if(currentState() != State.INSERTED) {
        		isSearched = false;
        		ok = true;
        	}
        	else if(currentState() == State.INSERTED ) {
        		if(currentHasTable() == number) {
        			isSearched = true;
        			ok = true;
        		}
        	}
        	if(!ok) collision.nextHash();
        }
        return isSearched;
	}
	
	public int get(int number) {
		boolean ok = contain(number);
		assert ok;
		return currentHasTable();
	}
	
	@Override
	public String toString() {
		return "" + hashTable;
	}
	
}
