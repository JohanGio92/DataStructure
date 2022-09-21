package exercise;

@FunctionalInterface
public interface UnaryPredicate<T> {

	boolean test(T element);

}
