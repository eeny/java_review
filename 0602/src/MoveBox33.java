import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MoveBox33 extends JFrame {
    JButton btnBlue, btnRed;

    public MoveBox33() {
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

        // 현재 클래스에서 2개로 각각 생성한 서브 스레드를 가져와서 실행한다!
        // 각 객체별로 스레드를 계속 만들 수 있다!
        // 굳이 스레드 여러 개 만드는 이유?
        // 앞서 배운대로 하나의 스레드로 따로 속도 제어를 주면
        // 속도를 다르게 할 수는 있지만 움직임이 어색하다! (프레임이 끊긴다.)
        // 이렇게 스레드를 객체별로 만들면 자연스러운 움직임이 가능하다!
        new MoveBox331(this).start();
        new MoveBox332(this).start();

        this.setVisible(true);
    }

    public static void main(String[] args) {
        new MoveBox33();
    }
}

class MoveBox331 extends Thread {
    MoveBox33 main;

    public MoveBox331(MoveBox33 main) {
        this.main = main;
    }

    @Override
    public void run() {// blue버튼 한 개에 대한 스레드
        while (true) {
            try {
                Thread.sleep(10);// red버튼 보다 느리게
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            main.btnBlue.setLocation(main.btnBlue.getX() + 1, main.btnBlue.getY());
        }
    }
}

class MoveBox332 extends Thread {
    MoveBox33 main;

    public MoveBox332(MoveBox33 main) {
        this.main = main;
    }

    @Override
    public void run() {// red버튼 한 개에 대한 스레드
        while (true) {
            try {
                Thread.sleep(1);// blue버튼 보다 빠르게
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (main.btnRed.getY() < 0) {
                main.btnRed.setLocation(main.btnRed.getX(), 450);
            }

            main.btnRed.setLocation(main.btnRed.getX(), main.btnRed.getY() - 1);
        }
    }
}