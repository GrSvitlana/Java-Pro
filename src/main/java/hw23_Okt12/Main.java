package hw23_Okt12;
/*
1. Use Stream API to find the longest string from a list of strings.
2. Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
Example 1:
Input: haystack = "sadbutsad", needle = "sad"
Output: 0
Explanation: "sad" occurs at index 0 and 6.
The first occurrence is at index 0, so we return 0.

Example 2:
Input: haystack = "leetcode", needle = "leeto"
Output: -1
Explanation: "leeto" did not occur in "leetcode", so we return -1.
 */

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> list = List.of("a", "abc", "abcd", "abcde", "abc", "longest", "hij", "klmn", "opqr", "stuvw", "xyz", "www", "y", "z", "a", "");
        System.out.println(list.stream().reduce(String.valueOf(0), (s1, s2) -> s1.length() > s2.length() ? s1 : s2));

        String haystack1 = "pppsadbutsad", needle1 = "sad";
        String haystack2 = "leetcode", needle2 = "leeto";

        System.out.println(findoccurrence(haystack1, needle1));
        System.out.println(findoccurrence(haystack2, needle2));
    }

    // KMP(Knuth Morris Pratt) algorithm for pattern searching
    private static int findoccurrence(String text, String pattern) {
        int[] prefix = prefixFunc(pattern);
        int found = -1;
        int tPosition = 0;
        int pPosition = 0;

        while (tPosition < text.length()) {
            if (text.charAt(tPosition) == pattern.charAt(pPosition)) {
                pPosition++;
                tPosition++;
            }
            if (pPosition == pattern.length()) {
                found = tPosition - pPosition;
                break;
                //nPosition = prefix[nPosition - 1];
            } else if (tPosition < text.length() && pattern.charAt(pPosition) != text.charAt(tPosition)) {
                if (pPosition != 0) {
                    pPosition = prefix[pPosition - 1];
                } else {
                    tPosition = tPosition + 1;
                }
            }
        }
        return found;
    }

    private static int[] prefixFunc(String text) {
        int length = text.length();
        int[] prefix = new int[length];
        int position = 0;
        for (int i = 1; i < length; i++) {
            while (i + position < length && text.charAt(position) == text.charAt(i + position)) {
                prefix[i + position] = Math.max(prefix[i + position], position);
                position++;
            }
        }
        return prefix;
    }
}
