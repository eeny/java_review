import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class GuiOrder {
    public static void main(String[] args) {
        JFrame f = new JFrame("피자주문");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(300, 200);
        f.setLayout(new FlowLayout());
        f.setResizable(false);

        JLabel lb = new JLabel("피자 주문 키오스크");
        lb.setFont(new Font("궁서", Font.BOLD, 30));
        lb.setForeground(Color.RED);
        f.add(lb);

        JLabel lb2 = new JLabel("종류 : ");
        f.add(lb2);
        //하나하나 만든 코드
        JRadioButton rad1 = new JRadioButton("콤보");
        JRadioButton rad2 = new JRadioButton("포테이토");
        JRadioButton rad3 = new JRadioButton("불고기   ");

        ButtonGroup group = new ButtonGroup();
        group.add(rad1);
        group.add(rad2);
        group.add(rad3);

        f.add(rad1);
        f.add(rad2);
        f.add(rad3);

        //for와 배열로 바꾼 코드
//		String[] str1 = {"콤보", "포테이토", "불고기   "};
//		JRadioButton[] radio = new JRadioButton[3];
//		ButtonGroup group = new ButtonGroup();
//		for (int i = 0; i < radio.length; i++) {
//			radio[i] = new JRadioButton(str1[i]);
//			group.add(radio[i]);
//			f.add(radio[i]);
//		}
//
        JLabel lb3 = new JLabel("토핑 :   ");
        f.add(lb3);
        //하나하나 만든 코드
        JCheckBox chk1 = new JCheckBox("치즈");
        JCheckBox chk2 = new JCheckBox("베이컨");
        JCheckBox chk3 = new JCheckBox("페퍼로니");
        f.add(chk1);
        f.add(chk2);
        f.add(chk3);

        //for와 배열로 바꾼 코드
//		String[] str2 = {"치즈", "포테이토", "불고기   "};
//		JCheckBox[] chk = new JCheckBox[3];
//		for (int i = 0; i < chk.length; i++) {
//			chk[i] = new JCheckBox(str2[i]);
//			f.add(chk[i]);
//		}

        JButton btn1 = new JButton("주문");
        btn1.setPreferredSize(new Dimension(100, 50));
        JButton btn2 = new JButton("취소");
        btn2.setPreferredSize(new Dimension(100, 50));
        f.add(btn1);
        f.add(btn2);



        f.setVisible(true);
    }
}
