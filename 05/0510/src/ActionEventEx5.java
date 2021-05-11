import java.awt.event.*;

import javax.swing.*;

public class ActionEventEx5 extends JFrame implements ActionListener {
    JButton btn1, btn2, btn3, btn4, btn5;

    public ActionEventEx5() {
        this.setDefaultCloseOperation(3);
        this.setSize(300, 300);

        btn1 = new JButton("북");
        btn2 = new JButton("남");
        btn3 = new JButton("서");
        btn4 = new JButton("동");
        btn5 = new JButton("중");

        btn1.addActionListener(this);//내가 구현했으니까 바로 this를 쓸 수 있다.
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        btn4.addActionListener(this);
        btn5.addActionListener(this);

        this.add(btn1, "North");
        this.add(btn2, "South");
        this.add(btn3, "West");
        this.add(btn4, "East");
        this.add(btn5, "Center");
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new ActionEventEx5();//<= 무명으로 생성(일회용 클래스 생성이니까)
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //어떤 버튼을 눌렀는지 조건을 걸어준다
        //첫번째 방법. 내가 누른 버튼을 여기에 복사한다.
        JButton btn = (JButton)e.getSource();
        //e는 이벤트가 일어난  그 녀석! getSource()는 그 객체!
        //이벤트를 일으킨 그 객체를 들고와서 현재 이 메서드 안에 있는 btn으로 복사한다.
        //또는~

        //두번째 방법. 변수를 전역으로 빼고
        //e.getSource()와 내가 미리 만든 버튼 객체를 비교해서 실행한다.
        if (e.getSource()==btn1) {
            System.out.println("북 버튼 누름");
        } else if (e.getSource()==btn2) {
            System.out.println("남 버튼 누름");
        } else if (e.getSource()==btn3) {
            System.out.println("서 버튼 누름");
        } else if (e.getSource()==btn4) {
            System.out.println("동 버튼 누름");
        } else if (e.getSource()==btn5) {
            System.out.println("중 버튼 누름");
        }

        System.out.println(btn.getActionCommand());//버튼의 글씨 가져오기

    }
}