import java.awt.*;
import javax.swing.*;

public class LayoutEx15 extends JFrame {//p347 4번 모양 구현
    public LayoutEx15(int cnt) {
        this.setDefaultCloseOperation(3);
        this.setSize(500, 200);
        this.setLayout(null);//절대 위치
        this.getContentPane().setBackground(Color.YELLOW);
        //JFrame의 배경색을 바꾸려면 그냥 setBackground()만으로는 적용이 안된다!

        this.randomNum(cnt);

        this.setVisible(true);
    }

    void randomNum(int cnt) {
        for (int i = 0; i < cnt; i++) {
            int rdX = (int)(Math.random() * 450);//x좌표
            int rdY = (int)(Math.random() * 150) - 40;//y좌표
            JLabel lb = new JLabel(i + "");
            lb.setForeground(Color.RED);
            lb.setBounds(rdX, rdY, 50, 50);//x, y, w, h
            this.add(lb);
        }
    }

    public static void main(String[] args) {
        new LayoutEx15(30);
    }
}