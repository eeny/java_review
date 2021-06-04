import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JLabel;

public class ThreadLabel extends JLabel implements Runnable {
    public ThreadLabel() {
        setTime();
        this.setBounds(400, 400, 100, 50);
        // Layout(null) 일 때!!!!
        // location, size 를 전부 설정해줘야 컴포넌트가 나타난다!!!
        // 둘 중 하나만 설정하면 안보인다!!!
    }

    void setTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("hh:mm:ss a");
        String current = dtf.format(now);

        this.setText(current);
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            setTime();
        }
    }
}