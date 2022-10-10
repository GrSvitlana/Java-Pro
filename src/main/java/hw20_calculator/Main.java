package hw20_calculator;
/*
Develop a program that performs element-by-element summation of arrays of 10 numbers.
The type of numbers can be any numeric (int, double, float, ...). Implement array summation with a lambda expression.
To add two arrays element by element is like this: {1, 2, 3} + {4, 5, 6} = {5, 7, 9}
 */
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Calculator<Integer> calculatorInt = (arr1, arr2) -> {
            Integer[] array = new Integer[arr1.length];
            for (int i = 0; i < array.length; i++) {
                array[i] = arr1[i] + arr2[i];
            }
            return array;
        };
        Integer[] array1 = {1, 2, 3};
        Integer[] array2 = {4, 5, 6};
        Integer[] array3 = calculatorInt.operation(array1, array2);
        System.out.println(Arrays.stream(array3).toList());

        Calculator<Double> calculatorDouble = (arr1, arr2) -> {
            Double[] array = new Double[arr1.length];
            for (int i = 0; i < array.length; i++) {
                array[i] = arr1[i] + arr2[i];
            }
            return array;
        };
        Double[] array4 = {1.7, 2.2, 3.8, 2.5, 2.7, 4.8, 1.1};
        Double[] array5 = {4.8, 5.7, 6.4, 4.6, 2.2, 3.3, 4.4};
        Double[] array6 = calculatorDouble.operation(array4, array5);
        System.out.println(Arrays.stream(array6).toList());
    }
}
