package multi_threading;

public class Counter {
    private int count = 0;

    public synchronized void add() {
        count++;
    }

    public synchronized void sub() {
        count--;
    }

    public int getCount() {
        return count;
    }
}
