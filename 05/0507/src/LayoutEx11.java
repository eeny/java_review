import java.awt.*;
import javax.swing.*;

public class LayoutEx11 extends JFrame {//교재338 예제 선생님 쉬운 방법
    JPanel pnl;//전역 변수

    public LayoutEx11() {//생성자!!! 가장 먼저 실행된다!!!
        this.setDefaultCloseOperation(3);
        this.setSize(300, 400);

        pnl = new JPanel();//패널 만들기
        pnl.setLayout(new BoxLayout(pnl, BoxLayout.Y_AXIS));
        //패널 레이아웃 설정 new BoxLayout(설정할 컨테이너, 방향)

/*		JButton btn1 = new JButton("버튼1");
		JButton btn2 = new JButton("버튼2");
		JButton btn3 = new JButton("버튼3");

		btn1.setAlignmentX(Component.CENTER_ALIGNMENT);//한개씩 적용된다!
		btn2.setAlignmentX(Component.CENTER_ALIGNMENT);
		btn3.setAlignmentX(Component.CENTER_ALIGNMENT);

		pnl.add(btn1);
		pnl.add(btn2);
		pnl.add(btn3);*/

        //위에서 반복되는 코드를 메서드화 시키자!
        //메서드가 할 일 : 버튼 생성, 버튼 정렬, 패널에 버튼 추가
        this.makButton("테스트1"); //<= 이 메서드가 위에 있는 기능 3개를 해준다!
        //패널에 테스트라는 버튼이 붙어있다!
        this.makButton("테스트2");
        this.makButton("테스트3");
        this.makButton("테스트4");

        this.add(pnl);

        //this.pack();
        //setSize()로 사이즈를 정해도
        //컴포넌트가 보이는 최대한 작은 크기로 창을 줄여버린다!

        this.setVisible(true);
    }

    void makButton(String str) {
        JButton btn = new JButton(str);
        btn.setAlignmentX(Component.CENTER_ALIGNMENT);
        pnl.add(btn);
    }

    public static void main(String[] args) {
        new LayoutEx11();
    }
}
