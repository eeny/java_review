import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GuiEx5 {
    public static void main(String[] args) {
        JFrame f = new JFrame("GuiEx5");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(500, 300);
        f.setLayout(new FlowLayout());

        JButton btn1 = new JButton("왼쪽 버튼");
        btn1.setBorderPainted(false);//버튼의 테두리선을 없앤다
        JButton btn2 = new JButton("중앙 버튼");
        btn2.setContentAreaFilled(false);//버튼의 배경색을 없앤다
        JButton btn3 = new JButton("오른쪽 버튼");
        btn3.setEnabled(false);//버튼 비활성화. 클릭 불가능
        JButton btn4 = new JButton("테스트 버튼1");
        btn4.setRolloverEnabled(false);//마우스를 버튼 위에 올려도 테두리가 진해지지 않음
        JButton btn5 = new JButton("테스트 버튼2");
        btn5.setToolTipText("tool tip!");//마우스를 버튼 위에 올리면 툴팁을 표시함
        JButton btn6 = new JButton("테스트 버튼3");
        btn6.setVisible(true);//버튼을 보이게 한다.(기본이 true) 감추려면 false

        //속성들은 섞어서 여러 개 사용할 수 있다!

        f.add(btn1);
        f.add(btn2);
        f.add(btn3);
        f.add(btn4);
        f.add(btn5);
        f.add(btn6);

        f.setVisible(true);
    }
}
