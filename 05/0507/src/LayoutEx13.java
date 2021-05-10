import java.awt.*;
import javax.swing.*;

public class LayoutEx13 extends JFrame {
    public LayoutEx13() {//생성자 1
        this.setLayout(new FlowLayout());
        init();
    }

    public LayoutEx13(String str) {//생성자 2
        if (str.equals("FlowLayout")) {
            this.setLayout(new FlowLayout());
        }
        init();
    }

    public LayoutEx13(FlowLayout layout) {//생성자 3
        this.setLayout(layout);
        init();
    }

    void init() {//중복되는 부분 메서드화
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 200);
        this.makeButton(3);
        this.setVisible(true);
    }

    void makeButton(int x) {
        for (int i = 0; i < x; i++) {
            this.add(new JButton("test"));
        }
    }

    public static void main(String[] args) {
        new LayoutEx13();
        //new LayoutEx13(new FlowLayout());
        //new LayoutEx13("FlowLayout");
        //3개 다 똑같다!!!
    }
}