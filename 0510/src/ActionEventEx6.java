import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ActionEventEx6 extends JFrame implements ActionListener {
    JTextField tf;
    JButton btn;
    JLabel lbl;

    public ActionEventEx6() {
        //생성자 내부에서 만들어진 객체를
        //생성자 외부에 있는 actionPerformed라는 메서드가 가져다가 쓸거다.
        //이렇게 외부로 내보낼거면, 여기에서 생성은 하되 변수를 전역으로 빼야한다!
        this.setDefaultCloseOperation(3);
        this.setSize(500, 500);

        tf = new JTextField();
        btn = new JButton("클릭");
        btn.addActionListener(this);
        lbl = new JLabel("내용내용");

        this.add(tf, "North");
        this.add(lbl, "Center");
        this.add(btn, "South");
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //버튼을 누르면 작동한다.
        //이 프로그램에서는 addActionListener를 1 개만 붙였기 때문에
        //그 버튼 말고는 작동하지 않는 메서드다.
        String str = tf.getText();
        lbl.setText(str);
    }

    public static void main(String[] args) {
        new ActionEventEx6();
    }
}