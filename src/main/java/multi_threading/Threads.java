package multi_threading;

import java.io.FileWriter;

public class Threads extends Thread {
    private final FileWriter fileWriter;

    public Threads(FileWriter fileWriter, String threadName) {
        this.fileWriter = fileWriter;
        this.setName(threadName);
        this.run();
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                fileWriter.write(this.getName() + " " + i + "\n");
                Thread.sleep(20);
                Thread.yield();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
