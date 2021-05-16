import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class FocusEventEx extends JFrame implements FocusListener {
    JTextField tf1, tf2;

    public FocusEventEx() {
        this.setDefaultCloseOperation(3);
        this.setSize(200, 200);
        this.setLayout(new FlowLayout());

        tf1 = new JTextField(15);
        tf2 = new JTextField(15);
        tf1.addFocusListener(this);
        tf2.addFocusListener(this);
        tf1.setBackground(Color.GRAY);
        tf2.setBackground(Color.GRAY);

        this.add(tf1);
        this.add(tf2);
        this.setVisible(true);
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (e.getSource()==tf1) {
            tf1.setBackground(Color.PINK);
        } else {
            tf2.setBackground(Color.PINK);
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (e.getSource()==tf1) {
            tf1.setBackground(Color.GRAY);
        } else {
            tf2.setBackground(Color.GRAY);
        }
    }

    public static void main(String[] args) {
        new FocusEventEx();
    }
}
