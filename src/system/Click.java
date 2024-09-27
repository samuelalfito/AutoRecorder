package system;

import java.awt.Robot;
import java.awt.event.InputEvent;

public class Click implements IRunnable {
    private int x = 0;
    private int y = 0;

    public Click(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void run() {
        try {
            Robot robot = new Robot();
            robot.mouseMove(this.x, this.y);
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(Click.class.getSimpleName());
    }
}
