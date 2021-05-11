import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class KilometerEx extends JFrame implements ActionListener {//428 1번
    JLabel lb;
    JTextField tf;
    JButton btn;
    JTextField tf2;

    public KilometerEx() {
        this.setDefaultCloseOperation(3);
        this.setSize(330, 150);
        this.setTitle("마일을 킬로미터로 변환");
        this.setLayout(new FlowLayout());

        lb = new JLabel("거리를 마일 단위로 입력하시오 ");
        tf = new JTextField(5);
        btn = new JButton("변환");
        btn.addActionListener(this);
        tf2 = new JTextField(25);

        this.add(lb);
        this.add(tf);
        this.add(btn);
        this.add(tf2);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int d = Integer.parseInt(tf.getText());
        double result = d * 1.6;
        tf2.setText(d +"마일은 " + result + "킬로미터 입니다.");
    }

    public static void main(String[] args) {
        new KilometerEx();
    }
}