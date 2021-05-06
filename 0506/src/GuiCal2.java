import java.awt.*;
import javax.swing.*;

public class GuiCal2 extends JFrame {
    public GuiCal2() {
        this.setTitle("계산기");
        this.setSize(300, 350);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField tf = new JTextField("  23");
        tf.setPreferredSize(new Dimension(300, 30));

        JPanel pnl2 = new JPanel(new GridLayout(0, 4, 10, 10));
        String[] str = {"c", "", "", "", "7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "0", "+/-", "=", "+"};
        JButton[] btns = new JButton[20];
        for (int i = 0; i < str.length; i++) {
            btns[i] = new JButton(str[i]);
            //btns[i].setPreferredSize(new Dimension(30, 30));
            btns[i].setHorizontalAlignment(SwingConstants.LEFT);//버튼 글자 왼쪽 정렬
            pnl2.add(btns[i]);
            if (str[i].equals("")) {
                btns[i].setContentAreaFilled(false);
                btns[i].setBorderPainted(false);
            }
        }

        this.add(tf, "North");
        this.add(pnl2, "Center");

        this.setVisible(true);
    }

    public static void main(String[] args) {
        new GuiCal2();
    }
}
