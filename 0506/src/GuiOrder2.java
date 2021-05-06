import java.awt.*;
import javax.swing.*;

public class GuiOrder2 extends JFrame {
    public GuiOrder2() {
        this.setSize(350, 200);
        //this.setLayout();
        this.setDefaultCloseOperation(3);

        JLabel lb = new JLabel("어떤 피자를 주문하시겠습니까?");
        lb.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        //setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0)) 상좌하우 공백
        String[] str = {"small", "medium", "Large"};
        JComboBox cb = new JComboBox(str);
        cb.setPreferredSize(new Dimension());

        JPanel pnl1 = new JPanel();
        pnl1.add(new JCheckBox("치즈 추가"));
        pnl1.add(new JCheckBox("피클 추가"));
        pnl1.add(new JCheckBox("콜라 추가"));

        JPanel pnl2 = new JPanel();
        pnl2.setLayout(new FlowLayout(FlowLayout.RIGHT));
        pnl2.add(new JButton("OK"));
        pnl2.add(new JButton("Cancel"));

        JPanel pnl = new JPanel(new GridLayout(0, 1));
        pnl.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        pnl.add(lb);
        pnl.add(cb);
        pnl.add(pnl1);
        pnl.add(pnl2);

        this.add(pnl);

        this.setVisible(true);
    }

    public static void main(String[] args) {
        new GuiOrder2();
    }
}
