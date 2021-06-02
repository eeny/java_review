import java.awt.Font;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Timer extends JFrame implements Runnable {
    JLabel lbl;

    public Timer() {
        this.setDefaultCloseOperation(3);
        this.setSize(350, 100);

        lbl = new JLabel();
        lbl.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        lbl.setHorizontalAlignment(JLabel.CENTER);

        setTime();// 여러 곳에서 중복된 작업을 할 때는 메서드로 따로 빼두는 게 편하다!

        this.add(lbl);
        this.setVisible(true);
    }

    // 현재 시간을 JLabel에 넣는 메서드
    void setTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd E요일 hh:mm:ss a");
        String nowTime = dtf.format(now);

        lbl.setText(nowTime);
    }

    @Override
    public void run() {
        for (;;) {// 무한 반복
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            setTime();
        }
    }

    public static void main(String[] args) {
        Timer timer = new Timer();
        Thread t = new Thread(timer);
        t.start();
    }
}