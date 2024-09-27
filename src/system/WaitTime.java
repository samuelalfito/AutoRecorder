package system;

public class WaitTime implements IRunnable {
    private int time = 0; // in milliseconds

    public WaitTime(int time) {
        this.time = time;
    }

    public void run() {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(WaitTime.class.getSimpleName());
    }
}
