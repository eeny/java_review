import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GuiOrder3v2 extends JFrame implements ActionListener {
    JRadioButton rad1, rad2, rad3;
    JLabel lb2;

    public GuiOrder3v2() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(330, 200);
        this.setLayout(new GridLayout(3, 1));

        JLabel lb = new JLabel("어떤 크기의 커피를 주문하시겠습니까?");
        lb.setHorizontalAlignment(JLabel.CENTER);//레이블 가운데 정렬

        rad1 = new JRadioButton("Small size");
        rad1.addActionListener(this);
        rad2 = new JRadioButton("Medium size");
        rad2.addActionListener(this);
        rad3 = new JRadioButton("Large size");
        rad3.addActionListener(this);

        ButtonGroup group = new ButtonGroup();
        group.add(rad1);
        group.add(rad2);
        group.add(rad3);

        JPanel pnl = new JPanel();
        pnl.setBorder(BorderFactory.createTitledBorder("크기"));
        pnl.add(rad1);
        pnl.add(rad2);
        pnl.add(rad3);

        lb2 = new JLabel("커피를 선택하세요.");
        lb2.setHorizontalAlignment(JLabel.CENTER);
        lb2.setForeground(Color.RED);

        this.add(lb);
        this.add(pnl);
        this.add(lb2);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==rad1) {//내가 버튼을 누른 이벤트와 비교
            lb2.setText("Small 크기가 선택되었습니다.");
        } else if (e.getSource()==rad2) {
            lb2.setText("Medium 크기가 선택되었습니다.");
        } else {
            lb2.setText("Large 크기가 선택되었습니다.");
        }
    }

    public static void main(String[] args) {
        new GuiOrder3v2();
    }
}