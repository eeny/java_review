import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class CountDownTest extends JFrame {// p585 예제
    private JLabel label;

    // 스레드를 내부 클래스로 만들면 필드에 접근하기 쉽다!
    class MyThread extends Thread {
        @Override
        public void run() {
            for (int i = 10; i >= 0; i--) {
                try {
                    Thread.sleep(1000);// 1초 쉬기(예외 발생 가능성 있음!)
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                label.setText(i + "");// 1초가 지나면 레이블의 텍스트를 변경
            }
        }
    }

    public CountDownTest() {
        this.setTitle("카운트다운");
        this.setSize(300, 200);
        this.setDefaultCloseOperation(3);

        label = new JLabel("Start");
        label.setFont(new Font("Serif", Font.BOLD, 100));

        new MyThread().start();// 스레드 실행

        this.add(label);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new CountDownTest();
    }
}