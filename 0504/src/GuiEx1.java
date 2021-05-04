import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class GuiEx1 {
    public static void main(String[] args) {
        //AWT	/	Swing
        //AWT = OS의 리소스를 이용해서 만들어진다. UI와 이벤트 처리를 포함한다.
        //Swing = 자바 자체의 리소스를 이용해서 만들어진다. 다만 UI부분에 국한된다.

        JFrame f = new JFrame();//1
        f.setTitle("타이틀의 내용");//new JFrame("타이틀의 내용")이랑 같음

        //창의 X를 눌렀을 때 종료가 될 수 있도록 작업 - 거의 필수(없어도 실행은 되므로)
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //FlowLayout flow = new FlowLayout();
        //f.setLayout(flow);
        //원래 이렇게 두 줄로 써야하는데 어차피 일회용이니까 한 줄로 바로 생성해도 된다!
        f.setLayout(new FlowLayout());//2
        //안해도 됨. 안하면 BorderLayout이 기본값.

        f.setSize(300, 200);//3
        JButton btn = new JButton();//4
        btn.setText("버튼의 글씨");//new JButton("버튼의 글씨")랑 같음
        f.add(btn);//5
        f.setVisible(true);//6
    }
}
