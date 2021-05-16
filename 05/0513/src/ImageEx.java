import java.awt.*;
import java.awt.event.*;

import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.*;
//ImageIconEx 코드를 버퍼이미지를 이용해 수정함
public class ImageEx extends JFrame implements ActionListener {
    JButton btn;
    ImageIcon icon;
    JLabel lbl;
    boolean isShow = false;//초기값 설정

    public ImageEx() throws IOException {
        this.setDefaultCloseOperation(3);
        this.setSize(530, 600);

        //이미지 파일을 자바의 객체로 만들기
        File f = new File("dog.jpg");
        Image img = ImageIO.read(f);
        //여기까지

        icon = new ImageIcon(img);

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

    public static void main(String[] args) throws IOException {
        new ImageEx();
    }
}