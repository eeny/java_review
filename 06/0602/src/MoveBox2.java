import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MoveBox2 extends JFrame implements Runnable {
    JButton btnBlue, btnRed;

    public MoveBox2() {
        this.setDefaultCloseOperation(3);
        this.setSize(500, 500);
        this.setLayout(null);

        btnBlue = new JButton();
        btnBlue.setBounds(10, 10, 70, 50);
        btnBlue.setBackground(Color.BLUE);

        btnRed = new JButton();
        btnRed.setBounds(250, 500, 10, 30);
        btnRed.setBackground(Color.RED);

        this.add(btnBlue);
        this.add(btnRed);

        (new Thread(this)).start();

        this.setVisible(true);
    }

    boolean isEnd = false;

    // 왼쪽 오른쪽 왔다갔다 하는 메서드
    void btnBlue() {
        if (btnBlue.getX() > 410) {// 오른쪽 끝
            isEnd = true;
        } else if (btnBlue.getX() < 0) {// 왼쪽 끝
            isEnd = false;
        }

        if (isEnd==true) {
            btnBlue.setLocation(btnBlue.getX() - 10, btnBlue.getY());
            // 여기서 10이 움직이는 거리(스피드)
        } else {
            btnBlue.setLocation(btnBlue.getX() + 10, btnBlue.getY());
        }

    }

    // 밑에서 위로만 올라가는 메서드
    void btnRed() {
        if (btnRed.getY() < 0) {
            btnRed.setLocation(btnRed.getX(), 500);
        }

        btnRed.setLocation(btnRed.getX(), btnRed.getY() - 15);
        // 여기서 15가 움직이는 거리(스피드)
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            btnRed();
            btnBlue();

        }
    }

    public static void main(String[] args) {
        new MoveBox2();
    }
}