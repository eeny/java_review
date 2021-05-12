import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ChangeColor1 extends JFrame implements ActionListener {
    JLabel[] lbs;
    JButton btn;
    int x;//샘 힌트 나누기 3으로 나머지 판단하기 위한 변수. 초기값 0

    public ChangeColor1() {
        this.setDefaultCloseOperation(3);
        this.setSize(200, 480);
        this.setLayout(new FlowLayout());

        lbs = new JLabel[3];

        for (int i = 0; i < lbs.length; i++) {
            lbs[i] = new JLabel();
            lbs[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            lbs[i].setPreferredSize(new Dimension(200, 130));
            lbs[i].setOpaque(true);//색깔 바꾸기 위해서 설정
            this.add(lbs[i]);
        }

        btn = new JButton("클릭");
        btn.setPreferredSize(new Dimension(200, 30));
        btn.addActionListener(this);

        this.add(btn);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ++x;//우선 1씩 증가

        if (x%3==1) {
            lbs[0].setBackground(Color.RED);
            lbs[1].setBackground(null);
            lbs[2].setBackground(null);
        } else if (x%3==2) {
            lbs[1].setBackground(Color.BLUE);
            lbs[0].setBackground(null);
            lbs[2].setBackground(null);
        } else if (x%3==0) {
            lbs[2].setBackground(Color.GREEN);
            lbs[1].setBackground(null);
            lbs[0].setBackground(null);
        }
    }

    public static void main(String[] args) {
        new ChangeColor1();
    }
}