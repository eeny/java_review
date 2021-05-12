import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;

public class ChangeColor3 extends JFrame implements ActionListener {
    JButton btn;

    public ChangeColor3() {
        this.setDefaultCloseOperation(3);
        this.setSize(300, 200);
        this.setLayout(new FlowLayout());

        btn = new JButton("색변경");
        btn.addActionListener(this);

        this.add(btn);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JColorChooser chs = new JColorChooser();
        Color color = chs.showDialog(null, "색상선택", Color.RED);

        if (color != null) {//색을 골랐다면
            this.getContentPane().setBackground(color);//해당 색으로 바꾸기
        }
    }

    public static void main(String[] args) {
        new ChangeColor3();
    }
}