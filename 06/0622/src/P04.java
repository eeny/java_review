import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class P04 extends JFrame implements ActionListener {
    JLabel lblUser, lblPw;
    JTextField tfUser;
    JPasswordField tfPw;
    JButton btnLogin;

    public P04() {
        this.setDefaultCloseOperation(3);
        this.setSize(350, 200);
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.setTitle("My First Swing Example");
        this.setLocation(750, 400);

        JPanel pnlUser = new JPanel();
        lblUser = new JLabel("User");
        lblUser.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 61));
        tfUser = new JTextField(15);
        pnlUser.add(lblUser);
        pnlUser.add(tfUser);

        JPanel pnlPw = new JPanel();
        lblPw = new JLabel("Password");
        lblPw.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 30));
        tfPw = new JPasswordField(15);
        pnlPw.add(lblPw);
        pnlPw.add(tfPw);

        btnLogin = new JButton("login");
        btnLogin.setPreferredSize(new Dimension(80, 25));
        btnLogin.addActionListener(this);

        this.add(pnlUser);
        this.add(pnlPw);
        this.add(btnLogin);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String user = tfUser.getText();
        String pw = tfPw.getText();

        if (user.equals("") || pw.equals("")) {
            JOptionPane.showMessageDialog(this, "빈 칸이 있습니다!");
        } else {
            JOptionPane.showMessageDialog(this, "User는 [" + user + "]\nPassword는 [" + pw + "]입니다." );
        }
    }

    public static void main(String[] args) {
        new P04();
    }
}
