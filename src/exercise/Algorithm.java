package exercise;

import java.util.Collection;
import java.util.List;

public class Algorithm {
	
	public static <T extends Number> 
	int countIf(Collection<T> collection, UnaryPredicate<T> predicate) {
		int count = 0;
		for (T element : collection) {
			if(predicate.test(element)) {
				++count;
			}
		}
		return count;
	}
	
	public static <T> 
	void swap(T[] array, int to, int from) {
		T temporal = array[to];
		array[to] = array[from];
		array[from] = temporal;
	}
	
	public static void main(String[] args) {
		
		Collection<Integer> collection = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		int count = countIf(collection, predicate -> predicate % 2 != 0);
		System.out.println(count);
	}
}
