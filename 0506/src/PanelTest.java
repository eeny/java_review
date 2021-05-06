import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PanelTest extends JFrame {
    public PanelTest() {
        this.setDefaultCloseOperation(3);
        this.setSize(300, 300);

        JPanel pnl = new JPanel();
        //pnl.setSize(100, 100);//어차피 Center안에 꽉 차게 나와서 필요없네!
        pnl.setLayout(new BorderLayout());
        pnl.add(new JButton("패북"), "North");
        pnl.add(new JButton("패남"), "South");
        pnl.add(new JButton("패서"), "West");
        pnl.add(new JButton("패동"), "East");
        pnl.add(new JButton("패중"), "Center");

        this.add(new JButton("북"), "North");
        this.add(new JButton("남"), "South");
        this.add(new JButton("서"), "West");
        this.add(new JButton("동"), "East");
        this.add(pnl, "Center");

        this.setVisible(true);
    }

    public static void main(String[] args) {
        new PanelTest();
    }
}