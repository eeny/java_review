import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
// 패널만 붙어있는 메인 프레임 (방식2 - 기존 방식)
public class McMain2 extends JFrame implements ActionListener {
    JPanel pnl1;
    JButton btnHere, btnTogo;

    public McMain2() {
        this.setDefaultCloseOperation(3);
        this.setSize(700, 800);

        pnl1 = new JPanel();
        pnl1.setBackground(Color.GREEN);

        btnHere = new JButton("매장");
        btnTogo = new JButton("포장");
        btnHere.addActionListener(this);
        btnTogo.addActionListener(this);

        pnl1.add(btnHere);
        pnl1.add(btnTogo);

        this.add(pnl1);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new McMain2();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
