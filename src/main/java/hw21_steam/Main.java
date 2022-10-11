package hw21_steam;
/*
1. Count the number of even numbers in the data stream.
2. Displays all surnames beginning with the letter "J".
3. A collection is given that consists of lines: Arrays.asList(«Highload», «High», «Load», «Highload»).
  а) Output how many times the "High" object occurs in the collection.
  б) Which element in the collection comes first? If we get an empty collection, let it return 0.
4. The collection is Arrays.asList("f10", "f15", "f2", "f4", "f4").
Sort in reverse alphabetical order and remove duplicates. The array should contain only unique values.
 */

import java.util.*;
import static java.util.Collections.reverseOrder;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(9, 8, 7, 6, 5, 4, 12, 23, 45, 56, 78));
        int numbers = (int) list.stream().filter(a -> a % 2 == 0).count();
        System.out.println(numbers);

        List<String> surnames = new ArrayList<>(Arrays.asList("Aaaa", "Bbbb", "Cccc", "Dddd", "Jjjj", "Kkkk", "Llll", "Jmmm", "Nnnn"));
        surnames.stream()
                .filter(s -> s.startsWith("J"))
                .forEach(System.out::println);

        List<String> list2 = new ArrayList<>(Arrays.asList("Highload", "High", "Load", "Highload"));
        int countHigh = (int)list2.stream()
                .filter("High"::equals)
                .count();
        System.out.printf("\"High\" occurs %d times\n", countHigh);
        System.out.println(list2.stream().findFirst().orElse(String.valueOf(0)));

        List<String> list3 = new ArrayList<>(Arrays.asList("f10", "f15", "f2", "f4", "f4"));
        list3.stream()
                .sorted(reverseOrder()) // (s1, s2) -> s2.compareTo(s1)
                .distinct()
                .forEach(System.out::println);
    }
}
