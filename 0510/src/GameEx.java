import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GameEx extends JFrame implements ActionListener {//p461 1번 예제
    JLabel lb;
    JTextField tf1, tf2;
    JButton btn1, btn2;
    int x;//랜덤 숫자

    public GameEx() {
        this.setDefaultCloseOperation(3);
        this.setSize(300, 200);
        this.setTitle("숫자게임");
        this.setLayout(new FlowLayout());

        x = (int)(Math.random() * 100) + 1;//1~100사이의 숫자

        JPanel pnl1 = new JPanel();
        lb = new JLabel("숫자를 추측하시오: ");
        tf1 = new JTextField(10);
        pnl1.add(lb);
        pnl1.add(tf1);

        JPanel pnl2 = new JPanel();
        tf2 = new JTextField(10);
        pnl2.add(tf2);

        JPanel pnl3 = new JPanel();
        btn1 = new JButton("정답 확인");
        btn1.addActionListener(this);
        btn2 = new JButton("종료");
        btn2.addActionListener(this);
        pnl3.add(btn1);
        pnl3.add(btn2);

        this.add(pnl1);
        this.add(pnl2);
        this.add(pnl3);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //내가 누른 버튼을 복사
        JButton btn = (JButton)e.getSource();
        if (btn==btn1) {//정답 확인
            if (x==Integer.parseInt(tf1.getText())) {//정답이라면
                tf2.setText("정답입니다!");
                tf2.setBackground(Color.CYAN);
            } else if (x > Integer.parseInt(tf1.getText())) {//x가 더 크면
                tf2.setText("너무 낮습니다.");
                tf2.setBackground(Color.PINK);
                btn1.setText("다시 한번");
            } else {//x가 더 작으면
                tf2.setText("너무 높습니다.");
                tf2.setBackground(Color.PINK);
                btn1.setText("다시 한번");
            }

        } else {//종료
            System.exit(0);//종료시키는 메서드
        }
    }

    public static void main(String[] args) {
        new GameEx();
    }
}