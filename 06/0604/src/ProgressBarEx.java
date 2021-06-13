import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class ProgressBarEx extends JFrame implements Runnable {
    JProgressBar bar;
    int min = 0;
    int max = 2000;

    public ProgressBarEx() {
        this.setDefaultCloseOperation(3);
        this.setSize(500, 200);
        this.setLayout(new FlowLayout());

        //JProgressBar bar = new JProgressBar();
        // 프로그래스바를 이렇게만 생성하면 범위를 알 수가 없다!

        bar = new JProgressBar(min, max);
        bar.setPreferredSize(new Dimension(400, 150));
        bar.setValue(0);// 처음 시작값
        bar.setStringPainted(true);// 지금 수치가 컴포넌트 위에 뜬다!

        this.add(bar);

        // 너무 빨라서 한번에 100%로 출력 된다!
		/*for (int i = 0; i < max; i++) {
			bar.setValue(i);
		}*/

        new Thread(this).start();

        this.setVisible(true);
    }

    public static void main(String[] args) {
        new ProgressBarEx();
    }

    // Thread로 setValue(정수)를 변화시키자!
    @Override
    public void run() {
        for (int i = 0; i <= max; i++) {
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            bar.setValue(i);
        }
    }
}
