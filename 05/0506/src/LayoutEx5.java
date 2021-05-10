import java.awt.*;

import javax.swing.*;//swing안에 모든 클래스 다 쓸거다~!!!

public class LayoutEx5 extends JFrame {
    public LayoutEx5() {
        this.setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton btn1 = new JButton("패널북");
        JButton btn2 = new JButton("패널남");
        JButton btn3 = new JButton("패널동");
        JButton btn4 = new JButton("패널서");
        JButton btn5 = new JButton("패널중");

        JPanel pnl = new JPanel();//패널은 기본이 FlowLayout
        pnl.setLayout(new BorderLayout(5, 5));//수평5, 수직5 간격있게 만들기
        //또는 BorderLayout bl = new BorderLayout();
        //pnl.setLayout(bl);
        //bl.setHgap(5);
        //bl.setVgap(5); 이렇게 해도 된다!

        pnl.add(btn1, "North");
        pnl.add(btn2, "South");
        pnl.add(btn3, "East");
        pnl.add(btn4, "West");
        pnl.add(btn5, "Center");

        JButton btn6 = new JButton("프레임북");
        JButton btn7 = new JButton("프레임남");
        JButton btn8 = new JButton("프레임동");
        JButton btn9 = new JButton("프레임서");

        //패널에 이미 다 붙어있지만 패널은 눈에 보이지 않는다.
        //패널을 눈에 보이는 창(JFrame)에 붙여야 한다.
        this.add(pnl);
        //this는 JFrame이고 JFrame은 레이아웃 설정이 없다면 기본이 BorderLayout
        //JFrame에 붙일 때 만약 위치를 지정하지 않으면 무조건 Center
        //this.add(pnl, "Center"); 랑 같은 말이다!

        this.add(btn6, "North");
        this.add(btn7, "South");
        this.add(btn8, "East");
        this.add(btn9, "West");

        this.setVisible(true);
    }

    public static void main(String[] args) {
        new LayoutEx5();
    }
}
