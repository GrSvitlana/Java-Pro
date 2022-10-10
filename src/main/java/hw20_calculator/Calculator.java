package hw20_calculator;

@FunctionalInterface
public interface Calculator<T> {
    T[] operation(T[] t1, T[] t2);
}
