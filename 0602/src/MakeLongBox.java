import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MakeLongBox extends JFrame implements Runnable {
    final int SIZE = 10;
    JLabel[] lbls;

    public MakeLongBox() {
        this.setDefaultCloseOperation(3);
        this.setSize(700, 200);
        this.setLayout(null);

        lbls = new JLabel[SIZE];
        makeBox();// 레이블 10개 만들어놓고 색깔만 바꿀 예정

        (new Thread(this)).start();// start하면 run실행

        this.setVisible(true);
    }

    // 레이블 10개 만드는 메서드
    void makeBox() {
        int num = 0;

        for (int i = 0; i < SIZE; i++) {
            lbls[i] = new JLabel();
            lbls[i].setOpaque(true);
            lbls[i].setBackground(null);
            lbls[i].setBounds((0 + num), 50, 50, 50);
            this.add(lbls[i]);

            num += 50;
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < SIZE; i++) {
            lbls[i].setBackground(Color.RED);// 0번째 레이블부터 색깔 변경

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new MakeLongBox();
    }
}