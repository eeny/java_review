import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GuiEx2 {
    public static void main(String[] args) {
        //JButton			//버튼
        //JTextField		//입력칸
        //new JLabel("글씨")	//글씨
        //FlowLayout으로 해서 각 3개씩 붙이기
        JFrame f = new JFrame("GuiEx2");

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.setLayout(new FlowLayout());
        f.setSize(300, 200);

        JButton btn1 = new JButton("버튼1");
        btn1.setPreferredSize(new Dimension(100, 100));//레이아웃이 있을 때 컴포넌트 사이즈 조절 가능
        JButton btn2 = new JButton("버튼2");
        JButton btn3 = new JButton();
        btn3.setText("버튼3");//버튼 만들고 글씨 넣기

        JTextField t1 = new JTextField(10);//15사이즈 크기
        JTextField t2 = new JTextField("안녕");//미리 입력된 글씨
        JTextField t3 = new JTextField("반갑", 10);//10사이즈 크기 + 글씨
        t3.setEditable(false);//편집 할 수 없다!

//		JTextField t1 = new JTextField(15);
//		JTextField t2 = new JTextField(15);
//		JTextField t3 = new JTextField(15);

        JLabel lab1 = new JLabel("글씨");//순수한 그냥 글씨
        JLabel lab2 = new JLabel("글씨");
        JLabel lab3 = new JLabel();
        String s = "글씨";
        lab3.setText(s);

        //add하는 순서에 따라서 붙는 순서가 달라진다!
        f.add(btn1);
        f.add(t1);
        f.add(lab1);

        f.add(btn2);
        f.add(t2);
        f.add(lab2);

        f.add(btn3);
        f.add(t3);
        f.add(lab3);

        f.setVisible(true);//창을 보이게한다!
    }
}
