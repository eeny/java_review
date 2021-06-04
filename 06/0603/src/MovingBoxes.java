import java.awt.Color;
import java.awt.Font;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MovingBoxes extends JFrame {
    JButton redBtn, blueBtn, cyanBtn, greenBtn, yellowBtn;
    JLabel timeLbl;
    int x = 0, y = 10, width = 70, height = 50;// 위치 크기 초기화

    public MovingBoxes() {
        this.setDefaultCloseOperation(3);
        this.setSize(500, 500);
        this.setLayout(null);

        redBtn = new RedBtn(this);
        blueBtn = new BlueBtn(this);
        cyanBtn = new CyanBtn(this);
        greenBtn = new GreenBtn(this);
        yellowBtn = new YellowBtn(this);

        timeLbl = new TimeLbl(this);

        this.add(redBtn);
        this.add(blueBtn);
        this.add(cyanBtn);
        this.add(greenBtn);
        this.add(yellowBtn);
        this.add(timeLbl);

        //(new Thread(timeLbl)).start();

        this.setVisible(true);
    }

    public static void main(String[] args) {
        new MovingBoxes();
    }

    // JButton 상속 받은 내부 클래스 5개
    class RedBtn extends JButton implements Runnable {
        MovingBoxes mb;

        public RedBtn(MovingBoxes mb) {
            this.mb = mb;
            this.setBackground(Color.RED);
            this.setBounds(x, y, width, height);
        }

        @Override
        public void run() {
            // TODO Auto-generated method stub

        }
    }

    class BlueBtn extends JButton implements Runnable {
        MovingBoxes mb;

        public BlueBtn(MovingBoxes mb) {
            this.mb = mb;
            this.setBackground(Color.BLUE);
            this.setBounds(50, y, width, height);
        }

        @Override
        public void run() {
            // TODO Auto-generated method stub

        }
    }

    class CyanBtn extends JButton implements Runnable {
        MovingBoxes mb;

        public CyanBtn(MovingBoxes mb) {
            this.mb = mb;
            this.setBackground(Color.CYAN);
            this.setBounds(100, y, width, height);
        }

        @Override
        public void run() {
            // TODO Auto-generated method stub

        }
    }

    class GreenBtn extends JButton implements Runnable {
        MovingBoxes mb;

        public GreenBtn(MovingBoxes mb) {
            this.mb = mb;
            this.setBackground(Color.GREEN);
            this.setBounds(150, y, width, height);
        }

        @Override
        public void run() {
            // TODO Auto-generated method stub

        }
    }

    class YellowBtn extends JButton implements Runnable {
        MovingBoxes mb;

        public YellowBtn(MovingBoxes mb) {
            this.mb = mb;
            this.setBackground(Color.YELLOW);
            this.setBounds(200, y, width, height);
        }

        @Override
        public void run() {
            // TODO Auto-generated method stub

        }
    }

    class TimeLbl extends JLabel implements Runnable {
        MovingBoxes mb;
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("hh:mm:ss");

        public TimeLbl(MovingBoxes mb) {
            this.mb = mb;
            this.setText("");
            this.setFont(new Font("맑은 고딕", Font.BOLD, 15));
            this.setForeground(Color.RED);
            this.setLocation(400, 450);
        }

        @Override
        public void run() {
            this.setText(dtf.format(now));

            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
