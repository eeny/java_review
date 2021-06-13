import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JLabel;

public class MoveBox7Lbl extends JLabel implements Runnable {
    public MoveBox7Lbl() {
        this.setBounds(350, 430, 200, 30);
    }

    @Override
    public void run() {
        // 무한 루프(시간은 계속 흐르니까)
        while (true) {
            LocalDateTime ldt = LocalDateTime.now();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
            String currentTime = dtf.format(ldt);

            this.setText(currentTime);

            // 시간은 어차피 자동으로 변하니까 while()문이 실시간으로 계속 갖고와서
            // 1초에 한번씩 변하는 것 처럼 보인다! 그래서 sleep()이 필수는 아니다!
            // 하지만 sleep() 없이는 실제로 while()문이 미친듯이 돌고 있는 상태라서
            // sleep()을 넣어주는 편이 효율적이다!
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}