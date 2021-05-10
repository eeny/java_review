import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class InterestEx extends JFrame implements ActionListener {
    JLabel lb1, lb2;
    JTextField tf1, tf2, tf3;
    JButton btn;

    public InterestEx() {
        this.setDefaultCloseOperation(3);
        this.setSize(300, 180);
        this.setTitle("이자 계산기");
        this.setLayout(new FlowLayout());

        lb1 = new JLabel("원금을 입력하시오          ");
        tf1 = new JTextField(8);
        lb2 = new JLabel("이율을 입력하시오          ");
        tf2 = new JTextField(8);
        btn = new JButton("변환");
        btn.addActionListener(this);
        tf3 = new JTextField(20);

        this.add(lb1);
        this.add(tf1);
        this.add(lb2);
        this.add(tf2);
        this.add(btn);
        this.add(tf3);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int m = Integer.parseInt(tf1.getText());
        double i = Double.parseDouble(tf2.getText());
        tf3.setText("이자는 연 " + (int)(m * i / 100) + "만원 입니다.");
    }

    public static void main(String[] args) {
        new InterestEx();
    }
}