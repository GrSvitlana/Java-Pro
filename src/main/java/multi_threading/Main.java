package multi_threading;

/**
 * Write a method in which three threads write data into the file line by line (10 records each, with a period of 20 ms)
 */

public class Main {
    static private String file = "src/main/java/multi_threading/file_threads.txt";

    public static void main(String[] args) {
        new Threads(file, "thread_1");
        new Threads(file, "thread_2");
        new Threads(file, "thread_3");
    }
}
