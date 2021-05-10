import java.awt.*;
import javax.swing.*;

public class LayoutEx6 extends JFrame {
    public LayoutEx6() {
        this.setSize(500, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel pnl1 = new JPanel();//말하지 않아도 Flow, 붙이면 무조건 가운데
        pnl1.setLayout(new FlowLayout(FlowLayout.LEADING));//왼쪽 오른쪽 지정할 수 있다!
        JLabel lnl = new JLabel("아이디");
        JTextField tf = new JTextField(7);
        pnl1.add(lnl);
        pnl1.add(tf);
        this.add(pnl1, "North");

        JButton btn1 = new JButton("버튼1");
        JButton btn2 = new JButton("버튼2");
        JButton btn3 = new JButton("버튼3");
        JButton btn4 = new JButton("버튼4");
        JButton btn5 = new JButton("버튼5");
        JButton btn6 = new JButton("버튼6");
        JButton btn7 = new JButton("버튼7");
        JButton btn8 = new JButton("버튼8");
        JButton btn9 = new JButton("버튼9");

        //프레임은 안되고 패널일 때만 생성하면서 레이아웃을 설정할 수 있다!
        JPanel pnl2 = new JPanel(new GridLayout(5, 2));
        //GridLayout(행, 열)
        //행이 0이면 자동으로 줄이 늘어난다. 열은 필수!

        pnl2.add(btn1);
        pnl2.add(btn2);
        pnl2.add(btn3);
        pnl2.add(btn4);
        pnl2.add(btn5);
        pnl2.add(btn6);
        pnl2.add(btn7);
        pnl2.add(btn8);
        pnl2.add(btn9);

        this.add(pnl2);

        this.setVisible(true);
    }

    public static void main(String[] args) {
        new LayoutEx6();
    }
}