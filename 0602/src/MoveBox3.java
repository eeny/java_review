import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MoveBox3 extends JFrame {
    JButton btnBlue, btnRed;

    public MoveBox3() {
        this.setDefaultCloseOperation(3);
        this.setSize(500, 500);
        this.setLayout(null);

        btnBlue = new JButton();
        btnBlue.setBounds(10, 10, 70, 50);
        btnBlue.setBackground(Color.BLUE);

        btnRed = new JButton();
        btnRed.setBounds(250, 500, 10, 30);
        btnRed.setBackground(Color.RED);

        (new MoveBox3T1(this)).start();
        (new MoveBox3T2(this)).start();

        this.add(btnBlue);
        this.add(btnRed);

        this.setVisible(true);
    }

    public static void main(String[] args) {
        new MoveBox3();
    }
}

class MoveBox3T1 extends Thread {
    MoveBox3 main;
    boolean isEnd = false;

    public MoveBox3T1(MoveBox3 main) {
        this.main = main;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (main.btnBlue.getX() > 410) {
                isEnd = true;
            } else if (main.btnBlue.getX() < 0) {
                isEnd = false;
            }
            if (isEnd) {
                main.btnBlue.setLocation(main.btnBlue.getX() - 1, main.btnBlue.getY());
            } else {
                main.btnBlue.setLocation(main.btnBlue.getX() + 1, main.btnBlue.getY());
            }
        }
    }
}

class MoveBox3T2 extends Thread {
    MoveBox3 main;

    public MoveBox3T2(MoveBox3 main) {
        this.main = main;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (main.btnRed.getY() < 0) {
                main.btnRed.setLocation(main.btnRed.getX(), 500);
            }

            main.btnRed.setLocation(main.btnRed.getX(), main.btnRed.getY() - 1);

        }
    }
}