import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GuiEx7 {
    public static void main(String[] args) {
        JFrame f = new JFrame("GuiEx7");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(300, 1000);
        f.setLayout(new FlowLayout());

        //이미지를 자바의 객체로 바꿔야한다.
        //이미지의 이름을 매개변수로 해서 객체로 만들어 주는 메서드는 많다!
		/*
		ImageIcon icon1 = new ImageIcon("dog1.png");//이미지아이콘이라는 객체로 변한다
		ImageIcon icon2 = new ImageIcon("dog2.png");
		ImageIcon icon3 = new ImageIcon("dog3.png");
		JLabel lb1 = new JLabel();//원래 글씨 쓸 때 사용한다.
		JLabel lb2 = new JLabel();
		JLabel lb3 = new JLabel();

		lb1.setIcon(icon1);//아이콘 객체를 매개변수로 받아서 lb공간에 넣어준다.
		lb2.setIcon(icon2);
		lb3.setIcon(icon3);
		*/

        //위의 코드 줄여보기
        //생성값으로 생성자를 넣을 수 있다!
        JLabel lb1 = new JLabel(new ImageIcon("dog1.png"));
        JLabel lb2 = new JLabel(new ImageIcon("dog2.png"));
        JLabel lb3 = new JLabel(new ImageIcon("dog3.png"));


        f.add(lb1);
        f.add(lb2);
        f.add(lb3);

        f.setVisible(true);
    }
}
