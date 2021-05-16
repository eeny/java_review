import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.imageio.*;
import javax.swing.*;

public class CheckBoxImage extends JFrame implements ActionListener {
    JCheckBox chk1, chk2, chk3;
    Image img1, img2, img3;
    ImageIcon icon1, icon2, icon3;
    JLabel lbl1, lbl2, lbl3;

    public CheckBoxImage() throws IOException {
        this.setDefaultCloseOperation(3);
        this.setSize(700, 200);
        this.setLayout(new GridLayout(0, 4));

        JPanel pnl = new JPanel(new GridLayout(0, 1));
        chk1 = new JCheckBox("apple");
        chk1.addActionListener(this);
        chk2 = new JCheckBox("grape");
        chk2.addActionListener(this);
        chk3 = new JCheckBox("water melon");
        chk3.addActionListener(this);
        pnl.add(chk1);
        pnl.add(chk2);
        pnl.add(chk3);

        File f1 = new File("apple.gif");
        File f2 = new File("grape.gif");
        File f3 = new File("watermelon.gif");
        img1 = ImageIO.read(f1);
        img2 = ImageIO.read(f2);
        img3 = ImageIO.read(f3);

        icon1 = new ImageIcon();
        icon2 = new ImageIcon();
        icon3 = new ImageIcon();

        lbl1 = new JLabel(icon1);
        lbl2 = new JLabel(icon2);
        lbl3 = new JLabel(icon3);

        this.add(pnl);
        this.add(lbl1);
        this.add(lbl2);
        this.add(lbl3);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==chk1) {
            if (chk1.isSelected()) {//체크된 상태
                icon1.setImage(img1);
                lbl1.setIcon(icon1);
            } else {//체크해제 상태
                lbl1.setIcon(null);
                lbl1.setText("apple.gif");
            }

        } else if (e.getSource()==chk2) {
            if (chk2.isSelected()) {//체크된 상태
                icon2.setImage(img2);
                lbl2.setIcon(icon2);
            } else {//체크해제 상태
                lbl2.setIcon(null);
                lbl2.setText("grape.gif");
            }

        } else if (e.getSource()==chk3) {
            if (chk3.isSelected()) {//체크된 상태
                icon3.setImage(img3);
                lbl3.setIcon(icon3);
            } else {//체크해제 상태
                lbl3.setIcon(null);
                lbl3.setText("watermelon.gif");
            }
        }

        this.repaint();
        this.revalidate();
    }

    public static void main(String[] args) throws IOException {
        new CheckBoxImage();
    }
}