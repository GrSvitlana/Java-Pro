package multi_threading;
/**
 * Write a Counter class that has one integer field count (initialized with zero).
 * Implement two methods add and sub in the class. The first increases count by 1, the second decreases it by 1.
 * Run two threads: in the first thread call add method in a loop (you can call it 100 times),
 * in the second thread call sub method the same number of times.
 * In the loop, after each iteration, it is better to put Thread.sleep, to better simulate the situation.
 * Make sure that threads are synchronized so that the value of count after all the operations is 0.
 * Example, one thread:
 * Thread thread1 = new Thread(() -> {
 *             for (int i = 0; i < 10; i++) {
 *                 count.add();
 *                 try {
 *                     Thread.sleep(100);
 *                 } catch (InterruptedException e) {
 *                     throw new RuntimeException(e);
 *                 }
 *             }
 *         });
 */

public class Main_Counter {


    public static void main(String[] args) {

        Counter counter = new Counter();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                counter.add();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                counter.sub();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(counter.getCount());
    }
}
