import java.awt.*;
import javax.swing.*;

public class LayoutEx16 extends JFrame {
    public LayoutEx16() {
        this.setDefaultCloseOperation(3);
        this.setSize(300, 500);
        this.setLayout(new FlowLayout());

        JTextField tf = new JTextField(10);
        JPasswordField pf = new JPasswordField(10);

        this.add(tf);
        this.add(pf);
        //둘의 메서드를 포함한 모든 내용은 차이가 없다.
        //다만 입력시 패스워드는 ...으로 표시된다.

        JPasswordField pf2 = new JPasswordField(10);
        pf2.setEchoChar('*');//표시되는 모양 다른 글자 한 개로 바꾸기!
        this.add(pf2);

        this.setVisible(true);
    }

    public static void main(String[] args) {
        new LayoutEx16();
    }
}