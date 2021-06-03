import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class CarGame extends JFrame {// p587 예제
    // 레이블 하나가 자동차 한 대
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    // 자동차의 x좌표
    int x1 = 100, x2 = 100, x3 = 100;

    class MyThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 120; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                x1 += (int)(Math.random() * 10);
                label1.setBounds(x1, 0, 100, 100);
                x2 += (int)(Math.random() * 10);
                label2.setBounds(x2, 70, 100, 100);
                x3 += (int)(Math.random() * 10);
                label3.setBounds(x3, 150, 100, 100);
            }
        }
    }

    public CarGame() {
        this.setTitle("CarGame");
        this.setSize(700, 300);
        this.setDefaultCloseOperation(3);
        this.setLayout(null);

        label1 = new JLabel();
        label1.setIcon(new ImageIcon("car1.gif"));
        label2 = new JLabel();
        label2.setIcon(new ImageIcon("car2.gif"));
        label3 = new JLabel();
        label3.setIcon(new ImageIcon("car3.gif"));
        this.add(label1);
        this.add(label2);
        this.add(label3);
        label1.setBounds(100, 0, 100, 100);
        label2.setBounds(100, 70, 100, 100);
        label3.setBounds(100, 150, 100, 100);

        (new MyThread()).start();

        this.setVisible(true);
    }

    public static void main(String[] args) {
        new CarGame();
    }
}