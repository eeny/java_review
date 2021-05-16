import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ImageIconEx extends JFrame implements ActionListener {
    JButton btn;
    ImageIcon icon;
    JLabel lbl;
    boolean isShow = false;//초기값 설정

    public ImageIconEx() {
        this.setDefaultCloseOperation(3);
        this.setSize(530, 600);

        icon = new ImageIcon("dog.jpg");

        btn = new JButton("이미지");
        btn.addActionListener(this);

        this.add(btn, "South");
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!isShow) {//if (isShow==false) {} 랑 똑같다!
            lbl = new JLabel();
            lbl.setIcon(icon);
            this.add(lbl);

            isShow = true;
        } else {
            this.remove(lbl);

            isShow = false;
        }
        //화면 새로고침 해줘야 사진이 바로 뜬다!
        this.repaint();
        this.revalidate();
    }

    public static void main(String[] args) {
        new ImageIconEx();
    }
}