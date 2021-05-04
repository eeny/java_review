import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class GuiCal {
    public static void main(String[] args) {
        JFrame f = new  JFrame("계산기");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(250, 350);
        f.setLayout(new FlowLayout());
        f.setResizable(false);//화면 크기 고정

        JTextField tf = new JTextField(20);

        f.add(tf);

        String[] str = {"c", "", "", "", "7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "0", "+/-", "=", "+"};

        for (int i = 0; i < str.length; i++) {
            JButton btn = new JButton(str[i]);
            btn.setPreferredSize(new Dimension(50, 50));
            if (i==1 || i==2 || i==3) {
                btn.setContentAreaFilled(false);
                btn.setBorderPainted(false);
            }
            f.add(btn);
        }

        f.setVisible(true);
    }
}
