package multi_threading;

import java.io.FileWriter;

public class Threads extends Thread {
    private String fileName;

    public Threads(String fileName, String threadName) {
        this.fileName = fileName;
        this.setName(threadName);
        this.start();
    }

    @Override
    public void run() {
        try (FileWriter fileWriter = new FileWriter(fileName, true)) {
            for (int i = 0; i < 10; i++) {
                fileWriter.write(this.getName() + " " + i + "\n");
                Thread.sleep(20);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
