import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ThreadEx2 extends JFrame implements Runnable {
    JLabel lbl;

    public ThreadEx2() {
        this.setDefaultCloseOperation(3);
        this.setSize(300, 100);

        lbl = new JLabel();
        lbl.setFont(new Font("맑은 고딕", Font.BOLD, 25));
        lbl.setHorizontalAlignment(JLabel.CENTER);

        (new Thread(this)).start();// start하면 run실행

        this.add(lbl);
        this.setVisible(true);
    }

    void setTime() {
        // 현재 시간 가져오기
        LocalDateTime ldt = LocalDateTime.now();
        // 시간 포맷으로 모양 만들기
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        // 시간을 모양으로 변경
        String current = dtf.format(ldt);
        // 만들어진 시간을 JLabel에 붙이기
        lbl.setText(current);
    }

    @Override
    public void run() {
        // for시작
        for (;;) {
            setTime();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }// for끝
    }

    public static void main(String[] args) {
		/*ThreadEx2 te2 = new ThreadEx2();
		// te2는 스레드(Runnable)를 구현(implements)한 객체다.
		// 그러나 바로 te2.start();를 할 수 없다.
		Thread t = new Thread(te2);
		// Thread클래스의 매개변수로 Runnable객체를 넣어준다!
		// 그리고 실행!
		t.start();*/

        new ThreadEx2();
    }
}