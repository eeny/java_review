import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class WhacAMoleTime extends JLabel implements Runnable {
    JLabel lblScore;

    public WhacAMoleTime(JLabel lblScore) {
        this.lblScore = lblScore;
        this.setText("시간 : 100초");
        this.setFont(new Font("굴림", Font.BOLD, 20));
    }

    @Override
    public void run() {
        for (int i = 100; i > 0; i--) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.setText("시간 : " + i + "초");
        }

        JOptionPane.showMessageDialog(this, "게임 끝! 총점 : " + lblScore.getText());
    }
}