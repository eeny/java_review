import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MoveBox22 extends JFrame implements Runnable {
    JButton btnBlue, btnRed;

    public MoveBox22() {
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

    void btnBlue() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        btnBlue.setLocation(btnBlue.getX()+10, btnBlue.getY());
    }

    void btnRed() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        btnRed.setLocation(btnRed.getX(), btnRed.getY()-10);
    }

    @Override
    public void run() {
        while (true) {
            btnBlue();// 0.5초 sleep()을 실행할 동안
            btnRed();// 대기하고 있다가 0.5초가 지나면 0.1 sleep()을 실행하게된다!
            // 결국 둘 다 똑같이 0.5초 마다 움직인다.
            // 따라서 Thread.sleep()은 스레드 안에서 한번만 실행하고,
            // 각각 메서드에서 움직이는 거리값에 차이를 줘서 속도 조절을 해야한다!
            // 여기서 거리값은 영상에서 프레임과 같다!(거리값이 작을수록 움직임이 자연스럽다.)
        }
    }

    public static void main(String[] args) {
        new MoveBox22();
    }
}