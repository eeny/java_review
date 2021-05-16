import java.awt.Image;
import java.awt.event.*;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.*;

public class SelectImage extends JFrame implements ActionListener {
    JButton btn1, btn2, btn3;
    Image img1, img2, img3;
    ImageIcon icon;
    JLabel lbl;

    public SelectImage() throws IOException {
        this.setDefaultCloseOperation(3);
        this.setSize(550, 600);

        JPanel pnl = new JPanel();
        btn1 = new JButton("강아지");
        btn2 = new JButton("고양이");
        btn3 = new JButton("햄스터");

        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);

        pnl.add(btn1);
        pnl.add(btn2);
        pnl.add(btn3);

        File f1 = new File("dog.jpg");
        File f2 = new File("cat.gif");
        File f3 = new File("ham.gif");
        img1 = ImageIO.read(f1);
        img2 = ImageIO.read(f2);
        img3 = ImageIO.read(f3);

        icon = new ImageIcon();
        lbl = new JLabel();//JLabel을 액션 리스너에 넣어서 일일이 new, add해주니까 사진이 중복으로 생성됐다...

        this.add(pnl, "North");
        this.add(lbl);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==btn1) {
            icon.setImage(img1);
            lbl.setIcon(icon);
            lbl.setHorizontalAlignment(JLabel.CENTER);//라벨 가운데 정렬

        } else if (e.getSource()==btn2) {
            icon.setImage(img2);
            lbl.setIcon(icon);
            lbl.setHorizontalAlignment(JLabel.CENTER);

        } else if (e.getSource()==btn3) {
            icon.setImage(img3);
            lbl.setIcon(icon);
            lbl.setHorizontalAlignment(JLabel.CENTER);
        }

        this.repaint();
        this.revalidate();
    }

    public static void main(String[] args) throws IOException {
        new SelectImage();
    }
}
