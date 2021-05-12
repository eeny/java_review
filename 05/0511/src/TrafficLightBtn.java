import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TrafficLightBtn extends JFrame implements ActionListener {
    JPanel pnl, spnl1, spnl2, spnl3;
    JButton btn;
    int i;//초기값 0

    public TrafficLightBtn() {
        this.setDefaultCloseOperation(3);
        this.setSize(300, 500);

        pnl = new JPanel(new GridLayout(0, 1));
        spnl1 = new JPanel();
        spnl2 = new JPanel();
        spnl3 = new JPanel();
        pnl.add(spnl1);
        pnl.add(spnl2);
        pnl.add(spnl3);

        btn = new JButton("버튼");
        btn.addActionListener(this);

        this.add(pnl);
        this.add(btn, "South");
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //무조건 버튼을 누르면 여기 안의 내용은 전부 실행된다!
        //배경색을 일단 없애면서 시작한다!
        spnl1.setBackground(null);
        spnl2.setBackground(null);
        spnl3.setBackground(null);

        if (i%3==0) {
            spnl1.setBackground(Color.RED);
        } else if (i%3==1) {
            spnl2.setBackground(Color.YELLOW);
        } else if (i%3==2) {
            spnl3.setBackground(Color.GREEN);
        }

        i++;
    }

    public static void main(String[] args) {
        new TrafficLightBtn();
    }
}