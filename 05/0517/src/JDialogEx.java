import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

class JDialogSub extends JDialog implements ActionListener {// 프레임과 99% 유사하다. 다만 메인이 아닌 서브 팝업창
    JTextField tf1;
    JDialogEx je;

    public JDialogSub(JDialogEx je, String title, boolean modal, String data) {
        super(je, title, modal);// 부모에 원래 이런 생성자가 있음!

        this.je = je;

        JButton btn = new JButton("부모로 값 던지기");
        btn.addActionListener(this);
        this.add(btn, "South");

        tf1 = new JTextField();
        this.add(tf1, "North");

        JLabel lbl = new JLabel(data);
        this.add(lbl);

        this.setSize(200, 200);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {// 부모창으로 값 던지기
        je.tf.setText(tf1.getText());
    }
}

public class JDialogEx extends JFrame implements ActionListener {
    JTextField tf;

    public JDialogEx() {
        this.setDefaultCloseOperation(3);
        this.setSize(300, 300);

        tf = new JTextField();
        this.add(tf, "North");

        JButton btn = new JButton("JDialog 팝업");
        btn.addActionListener(this);
        this.add(btn);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new JDialogSub(this, "팝업", true, tf.getText());
        // 메인이 뜨고 나서 서브로 뜨는 팝업창이므로
        // 메인을 닫으면 같이 닫힌다!
    }

    public static void main(String[] args) {
        new JDialogEx();
    }
}
