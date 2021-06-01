import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
// [클릭]버튼을 누르면 JButton이 생성되어 Vector안에 들어가고
// [출력]버튼을 누르면 만들어진 JButton이 나타나는 예제
public class Gui1 extends JFrame implements ActionListener {
    Vector<JButton> btns = null;
    JButton btn, btn2;
    JPanel pnl;

    public Gui1() {
        btns = new Vector<JButton>();
        // Vector는 배열처럼 변수의 묶음이다! 사실 변수 보다는 값의 묶음에 가깝다!

        this.setDefaultCloseOperation(3);
        this.setSize(500, 500);

        btn = new JButton("클릭");
        btn.addActionListener(this);

        btn2 = new JButton("출력");
        btn2.addActionListener(this);

        pnl = new JPanel();

        this.add(btn, "South");
        this.add(btn2, "North");
        this.add(pnl, "Center");
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Gui1();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==btn) {
            System.out.println(btns.isEmpty());// 공백이면 true

            JButton jbtn = new JButton("버튼");
            btns.add(jbtn);// 클릭할 때마다 버튼이 생성되어 Vector에 추가된다.

        } else if (e.getSource()==btn2) {
            for (int i = 0; i < btns.size(); i++) {
                pnl.add(btns.get(i));// Vector의 크기만큼 반복해서 하나씩 꺼내와 붙인다.
            }

            pnl.repaint();
            pnl.revalidate();
        }
    }
}