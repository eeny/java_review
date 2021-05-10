import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SignUpForm extends JFrame {
    public SignUpForm() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 300);
        this.setTitle("회원가입 폼!!");
        this.setLayout(new FlowLayout());

        JPanel pnl1 = new JPanel(new FlowLayout(FlowLayout.LEFT));//감싸는 패널 1
        JLabel idlb = new JLabel("아이디");
        JTextField idtf = new JTextField(17);
        JLabel limit8lb = new JLabel("*8자이내");
        pnl1.add(idlb);
        pnl1.add(idtf);
        pnl1.add(limit8lb);

        JPanel pnl2 = new JPanel();//감싸는 패널 2
        JLabel pwlb = new JLabel("비밀번호");
        JTextField pwtf = new JTextField(17);
        JLabel namelb = new JLabel("성명");
        JTextField nametf = new JTextField(7);
        pnl2.add(pwlb);
        pnl2.add(pwtf);
        pnl2.add(namelb);
        pnl2.add(nametf);

        JPanel pnl3 = new JPanel();//감싸는 패널 3
        JLabel genderlb = new JLabel("성별");
        JRadioButton rad1 = new JRadioButton("남자");
        JRadioButton rad2 = new JRadioButton("여자");
        JLabel hobbylb = new JLabel("취미");
        JCheckBox chk1 = new JCheckBox("여행");
        JCheckBox chk2 = new JCheckBox("잠자기");
        pnl3.add(genderlb);
        pnl3.add(rad1);
        pnl3.add(rad2);
        pnl3.add(hobbylb);
        pnl3.add(chk1);
        pnl3.add(chk2);

        JPanel pnl4 = new JPanel();//감싸는 패널 4
        JLabel hplb = new JLabel("H.P");
        String[] str = {"010", "011", "017", "018"};
        JComboBox hpcb = new JComboBox(str);
        JLabel hplb2 = new JLabel("-");
        JTextField hptf = new JTextField(4);
        JLabel hplb3 = new JLabel("-");
        JTextField hptf2 = new JTextField(4);
        JLabel mustlb = new JLabel("*필수입력");
        pnl4.add(hplb);
        pnl4.add(hpcb);
        pnl4.add(hplb2);
        pnl4.add(hptf);
        pnl4.add(hplb3);
        pnl4.add(hptf2);
        pnl4.add(mustlb);

        JPanel pnl5 = new JPanel();//감싸는 패널 5
        JLabel selflb = new JLabel("자기소개");
        JTextArea selfta = new JTextArea(1, 23);
        JScrollPane sp = new JScrollPane(selfta, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        pnl5.add(selflb);
        pnl5.add(sp);

        JPanel pnl6 = new JPanel();//감싸는 패널 6
        JButton sendBtn = new JButton("전송");
        JButton cancelBtn = new JButton("취소");
        pnl6.add(sendBtn);
        pnl6.add(cancelBtn);

        this.add(pnl1);
        this.add(pnl2);
        this.add(pnl3);
        this.add(pnl4);
        this.add(pnl5);
        this.add(pnl6);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new SignUpForm();
    }
}