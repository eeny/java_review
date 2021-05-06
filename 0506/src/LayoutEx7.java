import java.awt.*;
import javax.swing.*;

public class LayoutEx7 extends JFrame {
    public LayoutEx7() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new GridLayout(0, 1));

        JLabel lbl = new JLabel("        어떤 피자를 주문하시겠습니까?");

        String[] str = {"Large", "Medium", "Small"};
        JComboBox combo = new JComboBox(str);
        combo.setPreferredSize(new Dimension(300, 30));

        JPanel pnl = new JPanel();
        pnl.add(combo);

        JCheckBox chk1 = new JCheckBox("치즈 추가");
        JCheckBox chk2 = new JCheckBox("피클 추가");
        JCheckBox chk3 = new JCheckBox("콜라 추가");

        JButton btn1 = new JButton("OK");
        JButton btn2 = new JButton("Cancel");

        this.add(lbl);//첫번째 줄 그리도 0줄에 1칸
        this.add(pnl);//두번째줄

        JPanel pnl1 = new JPanel();//FlowLayout이라서 어차피 가로로 붙음
        pnl1.add(chk1);
        pnl1.add(chk2);
        pnl1.add(chk3);

        this.add(pnl1);

        JPanel pnl2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        pnl2.add(btn1);
        pnl2.add(btn2);

        this.add(pnl2);

        setVisible(true);
    }

    public static void main(String[] args) {
        new LayoutEx7();
    }
}
