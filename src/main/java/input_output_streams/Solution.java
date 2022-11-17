package input_output_streams;
/*
Given a text file file.txt, transpose its content.
You may assume that each row has the same number of columns, and each field is separated by the ' ' character.
If file.txt has the following content:
name age
alice 21
ryan 30

Output the following:
name alice ryan
age 21 30
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("../TelRan/Resource/file.txt"))) {
            String str = null;
            while ((str = br.readLine()) != null) {
                int count = 0;
                String word = "";
                for (int i = 0; i < str.length(); i++) {
                    char ch = str.charAt(i);
                    if (ch == ' ') { // str.split("\s")
                        try {
                            words.set(count, words.get(count) + " " + word);
                        } catch (IndexOutOfBoundsException e) {
                            words.add(count, word);
                        }
                        count++;
                        word = "";
                    } else {
                        word += ch;
                    }
                }
                try {
                    words.set(count, words.get(count) + " " + word);
                } catch (IndexOutOfBoundsException e) {
                    words.add(count, word);
                }
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("../TelRan/Resource/file_res.txt"))) {
            for (int i = 0; i < words.size(); i++) {
                bw.write(words.get(i));
                bw.write("\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
