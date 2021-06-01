import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyLotto extends JFrame implements ActionListener {
    List<JLabel> lblList;
    JButton btn1, btn2;

    public MyLotto() {
        this.setDefaultCloseOperation(3);
        this.setSize(300, 300);

        JPanel pnlCenter = new JPanel(new GridLayout(7, 7));
        JLabel[] lbls = new JLabel[45];
        for (int i = 0; i < 45; i++) {
            lbls[i] = new JLabel((i+1)+"");
            lbls[i].setFont(new Font("맑은 고딕", Font.PLAIN, 20));
            lbls[i].setHorizontalAlignment(JLabel.CENTER);
            lbls[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            pnlCenter.add(lbls[i]);
        }
        lblList = Arrays.asList(lbls);

        JPanel pnlSouth = new JPanel();
        btn1 = new JButton("자동선택");
        btn2 = new JButton("취소");
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        pnlSouth.add(btn1);
        pnlSouth.add(btn2);

        this.add(pnlCenter, "Center");
        this.add(pnlSouth, "South");
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==btn1) {// 자동선택

            Collections.shuffle(lblList);

            for (int i = 0; i < 6; i++) {
                lblList.get(i).setOpaque(true);
                lblList.get(i).setBackground(Color.RED);
                lblList.get(i).setForeground(Color.WHITE);
                System.out.print((i+1) + "번째 숫자 : "+ lblList.get(i).getText() + " / ");
            }
            System.out.println();

        } else if (e.getSource()==btn2) {// 취소
            for (JLabel lbl : lblList) {
                lbl.setForeground(Color.BLACK);
                lbl.setBackground(null);
            }
        }
    }

    public static void main(String[] args) {
        new MyLotto();
    }
}