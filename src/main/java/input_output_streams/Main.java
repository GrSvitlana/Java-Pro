package input_output_streams;
/*
Enter a filename from the console. Find the byte or bytes with the maximum number of repetitions.
Output them to the screen with a space. Close the I/O stream.
 */

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        int bytes;
        Map<Integer, Integer> map = new HashMap<>();
        try {
            FileInputStream input = new FileInputStream("../TelRan/Resource/file1.txt");
            while (input.available() > 0) {
                bytes = input.read();
                map.put(bytes, map.getOrDefault(bytes, 0) + 1);
            }
            input.close();
            int maxCounts = map.values().stream()
                    .max(Integer::compare)
                    .get();
            List<Integer> results = map.entrySet().stream()
                    .filter(x -> x.getValue().equals(maxCounts))
                    .map(Map.Entry::getKey).toList();
            System.out.printf("The maximum number of repetitions is %d with results %s", maxCounts, results);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
