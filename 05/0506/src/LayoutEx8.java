import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class LayoutEx8 extends JFrame {
    public LayoutEx8() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 400);

        JPanel northPnl = new JPanel();
        JButton btn1 = new JButton("버튼");
        JButton btn2 = new JButton("버튼");
        northPnl.add(btn1);
        northPnl.add(btn2);

        Border border = BorderFactory.createTitledBorder("버튼들");//외곽선 설정
        northPnl.setBorder(border);//외곽선 적용

        this.add(northPnl, "North");//BorderLayout이니까 위치 설정 필수

        this.setVisible(true);
    }

    public static void main(String[] args) {
        new LayoutEx8();
    }
}
