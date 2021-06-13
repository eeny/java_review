import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ThreadInterruptEx2 extends JFrame implements ActionListener, Runnable {
    boolean isStop = true;
    JButton btn;
    JLabel lbl;

    public ThreadInterruptEx2() {
        this.setDefaultCloseOperation(3);
        this.setSize(500, 500);

        btn = new JButton("정지");
        btn.addActionListener(this);
        lbl = new JLabel("시간");

        new Thread(this).start();

        this.add(btn, "North");
        this.add(lbl);
        this.setVisible(true);
    }

    @Override
    public void run() {
        // 스레드를 정상적으로 정지하려면 (true/false)를 이용해
        // 조건에 맞춰 반복문을 빠져나와야 한다!

        for (int i = 100; i > 0; i--) {
            // 변수의 조건을 통해 반복문을 빠져나오게 한다!
            // 가장 일반적인 스레드 정상 종료 방법!
            if (isStop == false) {
                break;
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            lbl.setText(i + "");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        isStop = false;
    }

    public static void main(String[] args) {
        new ThreadInterruptEx2();
    }
}