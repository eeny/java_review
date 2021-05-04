import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

public class GuiEx6 {
    public static void main(String[] args) {
        JFrame f = new JFrame("GuiEx6");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(250, 500);
        f.setLayout(new FlowLayout());

        JCheckBox chk1 = new JCheckBox("양파");
        JCheckBox chk2 = new JCheckBox("딸기", true);//박스에 체크된 채로 실행됨
        JCheckBox chk3 = new JCheckBox("토마토");

        f.add(chk1);
        f.add(chk2);
        f.add(chk3);

        //===============================================
        JRadioButton rad1 = new JRadioButton("사과");
        JRadioButton rad2 = new JRadioButton("고구마", true);//버튼에 체크된 채로 실행됨
        JRadioButton rad3 = new JRadioButton("감자");

        ButtonGroup group = new ButtonGroup();
        group.add(rad1);
        group.add(rad2);
        group.add(rad3);
        //라디오 버튼이니까 이 그룹 중에서는 하나만 선택됨
        //덩어리로 묶어주는 작업

        f.add(rad1);
        f.add(rad2);
        f.add(rad3);
        //add는 창에 추가하는 기능
        //위에 있는 group과 메서드는 같지만 사용하는 의미가 다르다!

        f.setVisible(true);
    }
}
