package hw19_fi_Predicate;
/*
1. Write a program that checks if a string starts with "J" or "N" and ends with "A". Use the Predicate functional interface.

2. Given an array intervals where intervals[i] = [li, ri] represent the interval [li, ri), remove all intervals that are covered by another interval in the list.
The interval [a, b) is covered by the interval [c, d) if and only if c <= a and b <= d.
Return the number of remaining intervals.

Example 1:
Input: intervals = [[1,4],[3,6],[2,8]]
Output: 2
Explanation: Interval [3,6] is covered by [2,8], therefore it is removed.

Example 2:
Input: intervals = [[1,4],[2,3]]
Output: 1
 */

import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        String str = "Write a program that checks if a string starts with J or N and ends with A. Use the Predicate functional interface.";
        Predicate<String> startJ = s -> s.startsWith("J");
        Predicate<String> startN = s -> s.startsWith("N");
        Predicate<String> endA = s -> s.endsWith("A");
        Predicate<String> orStart = startJ.or(startN);
        Predicate<String> andEnds = orStart.and(endA);

        System.out.println(andEnds.test(str));

        int[][] array1 = {{1, 4}, {3, 6}, {2, 8}};
        int[][] array2 = {{1, 4}, {2, 3}};

        System.out.println(numberOfRemainingIntervals(array1));
        System.out.println(numberOfRemainingIntervals(array2));
    }

    private static int numberOfRemainingIntervals(int[][] array) {
        int count = 1;
        int li = array[0][0];
        int ri = array[0][1];

        for (int i = 1; i < array.length; i++) {
            if (li <= array[i][0] && ri <= array[i][1]) {
                count++;
            }
            li = array[i][0];
            ri = array[i][1];
        }
        return count;
    }
}
