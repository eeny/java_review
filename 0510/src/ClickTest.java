import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ClickTest extends JFrame implements ActionListener {
    public ClickTest() {
        this.setDefaultCloseOperation(3);
        this.setSize(300, 200);

        JButton btn = new JButton("클릭!");
        btn.addActionListener(this);//매개 변수로 ActionListener 구현한 클래스를 줘야함
        //이 클래스 자체가 ActionListener를 구현했으므로 this를 넣으면 된다!
        //구현했다는 말은 ActionListener의 메서드인 actionPerformed()를 가졌다는 말이다.
        //addActionListener를 쓰는 순간, 이 버튼을 누르면
        //무조건 actionPerformed 메서드가 실행된다!

        this.add(btn);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new ClickTest();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //ActionListener interface가 들고 있는 반드시 구현해야하는 메서드!
        //이 메서드를 구현하면 버튼에 기능을 추가할 수 있다!
        System.out.println(111);
        JOptionPane.showMessageDialog(this, "반갑습니다!");//알림창 띄우는 기능
    }
}