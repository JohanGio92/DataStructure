package doublehash;

import java.util.Vector;

public class Eratosthenes {

	private boolean[] bitSet;
	private static int MAX_NUMBER;
	
	public Eratosthenes(int size) {
		MAX_NUMBER = size + 1;
		bitSet = new boolean[MAX_NUMBER];
		bitSet[0] = true;
		bitSet[1] = true;
	}
	
	public void sieve() {
		for (int number = 2; power(number) < MAX_NUMBER; number++) {
			if(!isMarkMultiple(number)) {
				markMultiple(number);
			}
		}
	}

	private void markMultiple(int number) {
		for (int multiple = power(number); multiple < MAX_NUMBER; multiple += number) {
			bitSet[multiple] = true;
		}
	}
	
	private boolean isMarkMultiple(int number) {
		return bitSet[number];
	}
	
	private int power(int number) {
		return number * number;
	}
	
	public Vector<Integer> primes() {
		Vector<Integer> primes = new Vector<>();
		for (int number = 0; number < MAX_NUMBER; number++) {
			if(!isMarkMultiple(number)){
				primes.add(number);
			}
		}
		return primes;
	}
	
	public boolean[] getBits() {
		return bitSet;
	}
}
