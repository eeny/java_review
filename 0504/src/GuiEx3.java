import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GuiEx3 {
    public static void main(String[] args) {
        JFrame f = new JFrame("GuiEx3");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(500, 300);
        f.setLayout(new FlowLayout());
        JButton btn = new JButton("버튼");

        //btn이 실제로 갖고있는 것은 생성된 JButton의 주소값

        f.add(btn);
        f.add(btn);
        f.add(btn);
        f.add(btn);
        f.add(btn);//마지막 것만 결과로 남는다!

        //따라서 한 번만 생성해서 여러 개의 버튼을 만들 수 없다!

        f.setVisible(true);
    }
}
