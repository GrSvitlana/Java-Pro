package tasks;

import java.util.*;

public class Solution {

    private static String[] str;
    private static Map<String, Integer> map;
    private static List<Map.Entry<String, Integer>> list;

    public static void main(String[] args) {

        str = new String[]{"hello", "this", "true", "baby", "hello", "around"};

        counting(str);

    }

    private static void counting(String[] str) {
        map = new HashMap<>();
        for (String s : str) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        list = new ArrayList<>(map.entrySet());
        List<Map.Entry<String, Integer>> sortList = list.stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .toList();

        for(Map.Entry<String, Integer> s : sortList) {
            System.out.printf("%d ", s.getValue());
        }
        System.out.println();
        for(Map.Entry<String, Integer> s : sortList) {
            System.out.printf("%s ", s.getKey());
        }
    }
}
