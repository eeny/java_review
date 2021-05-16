import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DisappearButton extends JFrame implements ActionListener {
    JButton startBtn;
    JPanel pnl;
    JButton[] btns = new JButton[5];
    Color[] c = {Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW, Color.PINK};

    public DisappearButton() {
        this.setDefaultCloseOperation(3);
        this.setSize(500, 500);

        startBtn = new JButton("시작");
        startBtn.addActionListener(this);

        pnl = new JPanel();
        pnl.setLayout(null);

        this.add(startBtn, "North");
        this.add(pnl);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==startBtn) {
            //버튼이 1개라도 있을 때는 추가로 같은 버튼이 안생기게 초기화
            pnl.removeAll();

            //랜덤으로 버튼 5개씩 생성됨
            for (int i = 0; i < btns.length; i++) {
                int x = (int)(Math.random()*400);
                int y = (int)(Math.random()*400);

                btns[i] = new JButton();
                btns[i].setBackground(c[i]);
                btns[i].setBounds(x, y, 50, 50);
                btns[i].addActionListener(this);//생성된 버튼에 액션 이벤트

                pnl.add(btns[i]);

                this.repaint();
                this.revalidate();
            }
        } else {
            //클릭하면 버튼 사라지게
            if (e.getSource()==btns[0]) {
                pnl.remove(btns[0]);
            } else if (e.getSource()==btns[1]) {
                pnl.remove(btns[1]);
            } else if (e.getSource()==btns[2]) {
                pnl.remove(btns[2]);
            } else if (e.getSource()==btns[3]) {
                pnl.remove(btns[3]);
            } else if (e.getSource()==btns[4]) {
                pnl.remove(btns[4]);
            }

            this.repaint();
            this.revalidate();
        }
    }

    public static void main(String[] args) {
        new DisappearButton();
    }
}