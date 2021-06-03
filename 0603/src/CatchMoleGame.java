import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class CatchMoleGame extends JFrame implements ActionListener, Runnable {
    TimeLabel timeLbl;
    JLabel scoreLbl;
    int score;
    JButton[] moles;
    int cnt = 10;// 줄어드는 시간, 반복되는 시간

    public CatchMoleGame() {
        this.setDefaultCloseOperation(3);
        this.setSize(500, 500);

        JPanel pnlNorth = new JPanel();
        timeLbl = new TimeLabel();
        pnlNorth.add(timeLbl);

        (new Thread(timeLbl)).start();

        scoreLbl = new JLabel("점수 : " + score);
        scoreLbl.setBorder(BorderFactory.createEmptyBorder(0, 100, 0, 0));
        pnlNorth.add(scoreLbl);

        JPanel pnlCenter = new JPanel();
        moles = new JButton[9];
        for (int i = 0; i < moles.length; i++) {
            moles[i] = new JButton();
            moles[i].addActionListener(this);
            moles[i].setPreferredSize(new Dimension(130, 130));
            moles[i].setBackground(Color.WHITE);
            pnlCenter.add(moles[i]);
        }

        this.add(pnlNorth, "North");
        this.add(pnlCenter, "Center");

        (new Thread(this)).start();

        this.setVisible(true);
    }

    void randomMole() {
        int moleCnt = 1;// 한번에 나타날 최대 두더지 수

        for (int i = 0; i < moleCnt; i++) {
            int ran = (int) (Math.random() * 9);
            moles[ran].setBackground(Color.PINK);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        // btn의 상태에 따라서 점수를 주자
        if (btn.getBackground()==Color.PINK) {
            score += 100;
            btn.setBackground(Color.WHITE);

        } else {
            score -=100;
        }

        scoreLbl.setText("점수 : " + score);
    }


    @Override
    public void run() {
        while (cnt > 0) {
            randomMole();
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new CatchMoleGame();
    }

    // 레이블을 내부 클래스로 뺐다!
    class TimeLabel extends JLabel implements Runnable {

        public TimeLabel() {
            this.setText("시간 : " + cnt + "초");
        }

        @Override
        public void run() {
            while (true) {
                if (cnt > 0) {
                    cnt--;

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    this.setText("시간 : " + cnt + "초");

                } else {
                    break;
                }
            }

            JOptionPane.showMessageDialog(this, "시간 종료! 점수는 " + score + "점 입니다!");
            System.exit(0);// 실행창이 한 개일 때 실행 종료
            //dispose();// 실행창이 여러 개일 때 해당하는 창만 실행 종료
        }
    }
}