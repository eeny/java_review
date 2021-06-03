import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Moving2Box extends JFrame implements Runnable {
    JLabel lblNorth, lblSouth;

    public Moving2Box() {
        this.setDefaultCloseOperation(3);
        this.setSize(500, 500);
        this.setLayout(null);

        lblNorth = new JLabel();
        lblNorth.setOpaque(true);
        lblNorth.setBackground(Color.BLUE);
        lblNorth.setBounds(50, 10, 50, 30);

        lblSouth = new JLabel();
        lblSouth.setOpaque(true);
        lblSouth.setBackground(Color.RED);
        lblSouth.setBounds(225, 450, 30, 50);

        this.add(lblNorth);
        this.add(lblSouth);

        new Thread(this).start();// run() 실행

        this.setVisible(true);
    }

    void moveX() {
        int x = 10;// 움직이는 거리(속도)
        int y = 10;// y좌표는 고정

        lblNorth.setLocation((lblNorth.getX() + x), y);
    }

    void moveY() {
        int x = 225;// x좌표는 고정
        int y = 50;// 움직이는 거리(속도)

        if (lblSouth.getY() < 0) {
            lblSouth.setLocation(x, 450);
        }

        lblSouth.setLocation(x, (lblSouth.getY() - y));
    }

    @Override
    public void run() {
        while (true) {
            moveX();
            moveY();

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Moving2Box();
    }
}