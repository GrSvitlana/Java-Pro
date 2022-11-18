package hw9_Iterator;
/*
Implement a class (ArrayIterator) iterator that will implement the interface (Iterator) on a given array of objects.
Create an array of test objects (7 pieces) and use the implemented ArrayIterator class to display the contents of the array.
*/

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        String[] array = {"Mercury", "Venus", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune"};
        toIterate(array);
    }

    public static void toIterate(String[] array) {
        ArrayIterator arrayIterator = new ArrayIterator<>(array);
        while (arrayIterator.hasNext()) {
            System.out.println(arrayIterator.next());
        }
    }
}