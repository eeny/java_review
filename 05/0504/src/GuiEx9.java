import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class GuiEx9 {
    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setLayout(new FlowLayout());
        f.setSize(280,200);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String title = "피자 주문 키오스크";
        JLabel lbl = new JLabel(title);
        lbl.setFont(new Font("바탕체",Font.BOLD,24));
        lbl.setForeground(Color.RED);

        f.add(lbl);//1

        JLabel lbl2 = new JLabel("종류:");
        JLabel lbl3 = new JLabel("토핑:");
        //======================================================
        JRadioButton radio1 = new JRadioButton("콤보");
        JRadioButton radio2 = new JRadioButton("포테이토");
        JRadioButton radio3 = new JRadioButton("불고기");

        ButtonGroup group = new ButtonGroup();
        group.add(radio1);
        group.add(radio2);
        group.add(radio3);// 라디오 버튼이니까 이 그룹중에서는 하나만 선택됨
        // 덩어리를 묶어주는 작업
        f.add(lbl2);//2
        f.add(radio1);//3
        f.add(radio2);//4
        f.add(radio3);//5


        JCheckBox chk1 = new JCheckBox("치즈");
        JCheckBox chk2 = new JCheckBox("베이컨");
        JCheckBox chk3 = new JCheckBox("페퍼로니");

        f.add(lbl3);
        f.add(chk1);
        f.add(chk2);
        f.add(chk3);

        // 버튼 2개 new로 만들고 f.add로 추가해 주면된다.

        f.setVisible(true);

    }
}
