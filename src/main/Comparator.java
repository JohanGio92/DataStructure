package main;

public interface Comparator<T> {

	boolean lessThan(T other);
	boolean greaterThan(T other);
	boolean lessThanEqual(T other);
	boolean greaterThanEqual(T other);
}
