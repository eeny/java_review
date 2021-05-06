import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GuiEx4 {
    /*
    Layout이 컴포넌트(버튼, 입력칸 등)의 크기 변화를 막는다.
    => setSize()를 못쓰게 함!!!
    그래서 메서드 때문에 에러는 안나지만 작동을 하지 않는다.
    그럼 어떻게 할까?
    1. 다른 설정을 추가해서 바꾸게 만든다.
    2. 레이아웃을 날려버린다.
     */
    public static void main(String[] args) {
        JFrame f = new JFrame("GuiEx4");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //내가 만든 코드
//		f.setSize(200, 150);
//		f.setLayout(new FlowLayout());
//
//		JLabel lb1 = new JLabel();
//		lb1.setText("아이디    ");
//		JLabel lb2 = new JLabel("비밀번호");
//
//		JTextField tf1 = new JTextField(10);
//		JTextField tf2 = new JTextField(10);
//
//		JButton btn1 = new JButton("로그인");
//		JButton btn2 = new JButton();
//		btn2.setText("회원가입");
//
//		f.add(lb1);
//		f.add(tf1);
//		f.add(lb2);
//		f.add(tf2);
//		f.add(btn1);
//		f.add(btn2);

        //선생님 풀이 코드
        f.setSize(500, 300);
        //f.pack(); //setSize() 대신 사용함. 컴포넌트들이 다보이는 최소 사이즈로 변경(= 빈 공간을 없앤다)

        f.setLocation(500, 500);//창이 x500, y500위치에 고정된다
        f.setResizable(false);//창의 크기를 자유롭게 조절할 수 없다(true면 조절가능)

        f.setLayout(null);
        //레이아웃을 설정하면 컴포넌트의 기본크기, add시 기본으로 붙을 위치 등을 알아서 해준다.
        //null => 아무런 설정이 없다! 레이아웃 날리기!
        JButton btn1 = new JButton("버튼");
        JButton btn2 = new JButton("클릭");
        //btn.setSize(100, 100);
        //btn.setLocation(10, 10);
        //위에 처럼 두 메서드로 따로 쓸 수도 있고, 아래처럼 한 줄로 쓸 수도 있다!
        btn1.setBounds(10, 10, 100, 100);//x, y, width, height
        btn2.setBounds(20, 20, 100, 100);

        f.add(btn1);
        f.add(btn2);

        f.setVisible(true);
    }
}
