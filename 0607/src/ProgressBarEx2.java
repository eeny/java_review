import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class ProgressBarEx2 extends JFrame implements ActionListener, Runnable {
    JProgressBar bar;
    JButton play, pause, stop;
    JPanel pnl;
    int barNum;// 현재 bar의 위치값 (기본값 0)
    boolean isStop;// 현재 bar가 정지인가? 실행중인가? (기본값 false)

    public ProgressBarEx2() {
        this.setDefaultCloseOperation(3);
        this.setSize(500, 150);

        bar = new JProgressBar(0, 100);// 0~100범위를 가진다!
        bar.setStringPainted(true);
        play = new JButton(">");
        pause = new JButton("||");
        stop = new JButton("□");
        play.addActionListener(this);
        pause.addActionListener(this);
        stop.addActionListener(this);

        pnl = new JPanel();
        pnl.add(play);
        pnl.add(pause);
        pnl.add(stop);

        this.add(bar);
        this.add(pnl, "South");
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==play) {
            isStop =false;
            new Thread(this).start();
        } else if (e.getSource()==pause) {
            isStop = true;
            barNum = bar.getValue();
        } else if (e.getSource()==stop) {
            isStop = true;
            barNum = 0;
            bar.setValue(0);// 모양도 맨처음(0%)으로 돌아가게 만들고 싶다!
        }
    }

    @Override
    public void run() {
        // 쓰레드를 정지하고 싶으면~
        // 반복문을 빠져나오면 알아서 쓰레드는 정지된다!

        for (int i = barNum; i <= 100; i++) {// 0부터 100까지니까 100이하여야 한다!
            if (isStop) {// isStop==true 랑 같은 의미!
                break;
            }

            bar.setValue(i);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new ProgressBarEx2();
    }
}