package hw18_functional_interface;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

/*
1. Write a functional interface with a method that accepts two strings and returns a string. Write an implementation
of this interface as a lambda which returns the string that is longer.

2. Write a program that checks that the string is not null and empty using the and() method of the Predicate functional interface.

3. Given a string s, find the length of the longest substring without repeating characters.

Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */

public class Main {
    public static void main(String[] args) {

        Longer<String> stringLonger = (t1, t2) -> t1.length() >= t2.length() ? t1 : t2;

        Predicate<String> isNotNull = s -> s != null;
        Predicate<String> isNotEmpty = s -> !s.isEmpty();

        Predicate<String> predicate = isNotNull.and(isNotEmpty);

        System.out.println(stringLonger.longer("Write a functional interface with a method that accepts two strings and returns a string.",
                "Write an implementation of this interface as a lambda which returns the string that is longer."));

        System.out.println(predicate.test("Write a program that checks that the string is not null " +
                "and is not empty using the and() method of the Predicate functional interface."));

        System.out.println(longestSubstring("abcabcbb"));
        System.out.println(longestSubstring("bbbbb"));
        System.out.println(longestSubstring("pwwkew"));

    }

    private static int longestSubstring(String s) {
        int count = 0;
        int result = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                count = map.get(ch) + 1;
            }
            map.put(ch, i);
            if (result < i - count + 1) {
                result = i - count + 1;
            }
        }
        return result;
    }
}
