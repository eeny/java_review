import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class MakeSignUpFile extends JFrame implements ActionListener {
    JTextField tfId, tfPw, tfName, tfEmail;
    JRadioButton rad1, rad2;
    JButton btn1, btn2;

    public MakeSignUpFile() {
        this.setDefaultCloseOperation(3);
        this.setSize(300, 400);
        this.setLayout(new FlowLayout());

        JLabel title = new JLabel("회원가입");
        title.setFont(new Font("맑은 고딕", Font.BOLD, 30));

        JPanel pnl1 = new JPanel();
        pnl1.setPreferredSize(new Dimension(270, 50));
        JLabel id = new JLabel("아이디");
        tfId = new JTextField(15);
        pnl1.add(id);
        pnl1.add(tfId);

        JPanel pnl2 = new JPanel();
        pnl2.setPreferredSize(new Dimension(270, 50));
        JLabel pw = new JLabel("비밀번호");
        tfPw = new JTextField(15);
        pnl2.add(pw);
        pnl2.add(tfPw);

        JPanel pnl3 = new JPanel();
        pnl3.setPreferredSize(new Dimension(270, 50));
        JLabel name = new JLabel("이름");
        tfName = new JTextField(15);
        pnl3.add(name);
        pnl3.add(tfName);

        JPanel pnl4 = new JPanel();
        pnl4.setPreferredSize(new Dimension(270, 50));
        JLabel email = new JLabel("이메일");
        tfEmail = new JTextField(15);
        pnl4.add(email);
        pnl4.add(tfEmail);

        JPanel pnl5 = new JPanel();
        pnl5.setPreferredSize(new Dimension(270, 50));
        JLabel gender = new JLabel("성별");
        rad1 = new JRadioButton("남");
        rad2 = new JRadioButton("여");
        rad2.setSelected(true);//미리 선택해둠
        ButtonGroup gr = new ButtonGroup();
        gr.add(rad1);
        gr.add(rad2);
        pnl5.add(gender);
        pnl5.add(rad1);
        pnl5.add(rad2);

        JPanel pnl6 = new JPanel();
        pnl6.setPreferredSize(new Dimension(270, 50));
        btn1 = new JButton("가입");
        btn1.addActionListener(this);
        btn2 = new JButton("취소");
        btn2.addActionListener(this);
        pnl6.add(btn1);
        pnl6.add(btn2);

        this.add(title);
        this.add(pnl1);
        this.add(pnl2);
        this.add(pnl3);
        this.add(pnl4);
        this.add(pnl5);
        this.add(pnl6);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String fileName = "member.txt";
        String contents = tfId.getText() + "/"
                + tfPw.getText() + "/"
                + tfName.getText() + "/"
                + tfEmail.getText() + "/"
                + (rad1.isSelected()==true? "남":"여");

        File f = new File(fileName);
        FileWriter fw = null;
        PrintWriter pw = null;

        if (e.getSource()==btn1) {//가입(저장형식 1(인덱스번호)/id/pw/name/email/gender)
            try {
                fw = new FileWriter(f, true);//true를 써주면 내용을 새로 덮어쓰는 게 아니라 추가해준다!
                pw = new PrintWriter(fw);
                pw.println(contents);

            } catch (IOException e1) {
                e1.printStackTrace();
            } finally {
                if (pw != null) {
                    pw.close();
                }
            }

        } else if (e.getSource()==btn2) {//취소(내용 지우기)
            tfId.setText("");
            tfPw.setText("");
            tfName.setText("");
            tfEmail.setText("");
        }
    }

    public static void main(String[] args) {
        new MakeSignUpFile();
    }
}