package hw18_functional_interface;
@FunctionalInterface
public interface Longestable<T> {
    T longer (T t1, T t2);
}
