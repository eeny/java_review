import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LayoutEx9 extends JFrame {
    public LayoutEx9() {
        setDefaultCloseOperation(3);
        setSize(400, 400);

        JTextField tf = new JTextField();//크기를 안줘도 된다
        //Border에서는 무조건 최대크기로 나온다!
        this.add(tf, "North");

        JPanel pnl = new JPanel(new GridLayout(0, 4, 5, 5));//좌우상하 갭

        String[] str = {"c", "", "", "", "7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "0", "+/-", "=", "+"};
        for (int i = 0; i < 20; i++) {
            JButton btn = new JButton(str[i]);
            pnl.add(btn);
            if (i>=1 && i<=3) {
                btn.setContentAreaFilled(false);
                btn.setBorderPainted(false);
            }
        }

        this.add(pnl, "Center");

        this.setVisible(true);
    }

    public static void main(String[] args) {
        new LayoutEx9();
    }
}