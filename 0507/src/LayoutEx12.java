import java.awt.*;
import javax.swing.*;

public class LayoutEx12 extends JFrame {// 선생님 코드 수정하기

    public LayoutEx12() {
        this.setDefaultCloseOperation(3);
        this.setSize(500, 300);
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        //JFrame이 가진 숨겨진 기본 패널

        String[] tag = { "자장면", "짬뽕", "팔보채", "탕수육", "라조기", "깐풍기" };
        this.makeBtn(tag);

        this.setVisible(true);
    }

    void makeBtn(String[] str) {//해야 할 일 - 버튼 생성, 버튼 메인에 붙이기
        for (int i = 0; i < str.length; i++) {
            JButton btn = new JButton(str[i]);
            btn.setAlignmentX(Component.CENTER_ALIGNMENT);
            this.add(btn);
        }
    }

    public static void main(String[] args) {
        new LayoutEx12();
    }
}