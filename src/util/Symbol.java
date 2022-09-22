package util;

public class Symbol {
	
	private static final int LESS_THAN = -1;
	private static final int GREATHER_THAN = 1;
	private static final int EQUAL_THAN = 0;
	
	public static <T extends Comparable<T>> 
	boolean equal(T x, T y) {
		return x.compareTo(y) == EQUAL_THAN;
	}

	public static <T extends Comparable<T>> 
	boolean notEqual(T x, T y) {
		return !equal(x, y);
	}
	
	public static <T extends Comparable<T>> 
	boolean less(T x, T y) {
		return x.compareTo(y) == LESS_THAN;
	}

	public static <T extends Comparable<T>> 
	boolean greater(T x, T y) {
		return x.compareTo(y) == GREATHER_THAN;
	}

	public static <T extends Comparable<T>> 
	boolean lessEqual(T x, T y) {
		return !greater(x, y);
	}

	public static <T extends Comparable<T>> 
	boolean greaterEqual(T x, T y) {
		return !less(x, y);
	}

}
