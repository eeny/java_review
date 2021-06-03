import java.awt.Color;

import javax.swing.JButton;

public class ThreadButton1 extends JButton implements Runnable {
    int speed;
    boolean isEnd;

    public ThreadButton1(int x, int y, int width, int height, Color color, int speed) {
        this.setBounds(x, y, width, height);
        this.setBackground(color);
        this.speed = speed;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(speed);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (this.getX() > 410) {
                isEnd = true;
            } else if (this.getX() < 0) {
                isEnd = false;
            }

            if (isEnd) {
                this.setLocation(this.getX() - 1, this.getY());
            } else {
                this.setLocation(this.getX() + 1, this.getY());
            }
        }
    }
}