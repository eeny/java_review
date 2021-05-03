import javax.swing.*;
import java.awt.*;

public class WindowEx2 extends JFrame{
    WindowEx2(){
        //this는 중복되는 게 없으면 안써도 된다!
        this.setDefaultCloseOperation(3);
        this.setSize(300, 200);

        this.setLayout(new FlowLayout());
        JButton btn1 = new JButton("버튼1");
        JButton btn2 = new JButton("버튼2");
        JButton btn3 = new JButton("버튼3");
        JButton btn4 = new JButton("버튼4");
        JButton btn5 = new JButton("버튼5");

        this.add(btn1);
        this.add(btn2);
        this.add(btn3);
        this.add(btn4);
        this.add(btn5);

        this.setVisible(true);
    }

    public static void main(String[] args){
		/*
		원래 상속 안받고 이렇게 바로 써도 된다~~!!!
		
		JFrame f = new JFrame();//창 만들기
		f.setDefaultCloseOperation(3);//JFrame.EXIT_ON_CLOSE == 3 이랑 같은 의미다
		f.setSize(300, 200);//창 크기 설정
		f.setVisible(true);//창을 화면에 출력하기 - 기본값은 false라서 안나옴
		*/

        new WindowEx2();
    }
}