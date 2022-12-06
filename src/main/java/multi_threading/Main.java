package multi_threading;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Write a method in which three threads write data into the file line by line (10 records each, with a period of 20 ms)
 */

public class Main {
    static private final String file = "src/main/java/multi_threading/file_threads.txt";

    public static void main(String[] args) throws IOException {
            FileWriter fileWriter = new FileWriter(file, true);
            new Threads(fileWriter, "thread_1");
            new Threads(fileWriter, "thread_2");
            new Threads(fileWriter, "thread_3");
            fileWriter.flush();
    }
}
