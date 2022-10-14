package hw20_calculator;

@FunctionalInterface
public interface Calculator<T extends Number> {
    T[] operation(T[] t1, T[] t2);
}
