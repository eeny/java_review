import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class GuiEx8 {//계산기 문제 선생님 풀이
    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setLayout(new FlowLayout());
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(210, 250);
        f.setResizable(false);//화면 크기 고정

        JTextField tf = new JTextField(15);
        f.add(tf);

        String[] str = {"c", "", "", "", "7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "0", "+/-", "=", "+"};
        JButton[] btns = new JButton[20];

        for (int i = 0; i < str.length; i++) {
            btns[i] = new JButton(str[i]);
            f.add(btns[i]);
        }

        btns[1].setBorderPainted(false);//버튼 외곽선 없애기
        btns[1].setContentAreaFilled(false);//버튼 배경색 없애기
        btns[2].setBorderPainted(false);
        btns[2].setContentAreaFilled(false);
        btns[3].setBorderPainted(false);
        btns[3].setContentAreaFilled(false);

        f.setVisible(true);
    }
}
