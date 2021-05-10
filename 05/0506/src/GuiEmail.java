import javax.swing.*;
import java.awt.*;

public class GuiEmail extends JFrame {//교재 p302 모양 따라 만들기
    public GuiEmail() {
        this.setTitle("E-mail Contacts");
        this.setSize(490, 480);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        //Name 부분
        JPanel namePnl = new JPanel();//Name 전체 감싸는 패널
        namePnl.setPreferredSize(new Dimension(450, 150));//패널 사이즈 지정
        namePnl.setBorder(BorderFactory.createTitledBorder("Name"));//Name 테두리

        JPanel pnl1 = new JPanel();//이름 레이블과 텍스트 필드 감싸는 패널 1
        JLabel nameLb = new JLabel("이름  ");
        JTextField nameTf = new JTextField();
        nameTf.setPreferredSize(new Dimension(160, 20));
        pnl1.add(nameLb);
        pnl1.add(nameTf);

        JPanel pnl2 = new JPanel();//공백 때문에 만든 패널 2
        JButton fakeBtn = new JButton("");
        fakeBtn.setPreferredSize(new Dimension(205, 20));
        fakeBtn.setBorderPainted(false);//안보이게 처리
        fakeBtn.setContentAreaFilled(false);//안보이게 처리
        pnl2.add(fakeBtn);

        JPanel pnl3 = new JPanel();//직책 레이블과 텍스트 필드 감싸는 패널 3
        JLabel positionLb = new JLabel("직책  ");
        JTextField positionTf = new JTextField();
        positionTf.setPreferredSize(new Dimension(160, 20));
        pnl3.add(positionLb);
        pnl3.add(positionTf);

        JPanel pnl4 = new JPanel();//아이디 레이블과 텍스트 필드 감싸는 패널 4
        JLabel idLb = new JLabel("  아이디  ");
        JTextField idTf = new JTextField();
        idTf.setPreferredSize(new Dimension(160, 20));
        pnl3.add(idLb);
        pnl3.add(idTf);

        namePnl.add(pnl1);
        namePnl.add(pnl2);
        namePnl.add(pnl3);
        namePnl.add(pnl4);

        //E-mail 부분
        JPanel emailPnl = new JPanel(new BorderLayout());//E-mail 전체 감싸는 패널
        emailPnl.setPreferredSize(new Dimension(450, 230));//패널 사이즈 지정
        emailPnl.setBorder(BorderFactory.createTitledBorder("E-mail"));//E-mail 테두리

        JPanel pnl5 = new JPanel();//이메일 주소 레이블과 텍스트 박스까지 감싸는 패널 5
        JLabel emailLb = new JLabel("이메일 주소   ");
        JTextField emailTf = new JTextField();
        emailTf.setPreferredSize(new Dimension(240, 20));
        JTextArea ta = new JTextArea();//텍스트 박스
        ta.setPreferredSize(new Dimension(315, 107));
        ta.setBorder(BorderFactory.createLineBorder(Color.GRAY));//테두리 설정
        pnl5.add(emailLb);
        pnl5.add(emailTf);
        pnl5.add(ta);

        JPanel pnl6 = new JPanel(new GridLayout(0,1, 0, 5));//세로정렬 버튼 4개 감싸는 패널 6
        pnl6.setBorder(BorderFactory.createEmptyBorder(0,0,10,10));//패널 내부 공백
        pnl6.add(new JButton("Add"));
        pnl6.add(new JButton("Edit"));
        pnl6.add(new JButton("Remove"));
        pnl6.add(new JButton("Default"));

        JPanel pnl7 = new JPanel(new FlowLayout(FlowLayout.LEFT));//Mail Format 라디오버튼 3개 감싸는 패널 7
        pnl7.setPreferredSize(new Dimension(430, 60));
        pnl7.setBorder(BorderFactory.createEmptyBorder(0,12,0,0));//패널 내부 공백
        JLabel mailLb = new JLabel("Mail Format: ");
        mailLb.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 300));
        JRadioButton rad1 = new JRadioButton("HTML");
        JRadioButton rad2 = new JRadioButton("Plain Text");
        JRadioButton rad3 = new JRadioButton("Custom");
        pnl7.add(mailLb);
        pnl7.add(rad1);
        pnl7.add(rad2);
        pnl7.add(rad3);
        ButtonGroup gr = new ButtonGroup();
        gr.add(rad1);
        gr.add(rad2);
        gr.add(rad3);

        emailPnl.add(pnl5, "Center");
        emailPnl.add(pnl6, "East");
        emailPnl.add(pnl7, "South");

        //OK, Cancel 버튼 부분
        JPanel btnsPnl = new JPanel(new FlowLayout(FlowLayout.RIGHT));//버튼 전체 감싸는 패널
        btnsPnl.setPreferredSize(new Dimension(450, 50));//패널 사이즈 지정
        btnsPnl.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));//패널 내부 공백 제거

        JButton okBtn = new JButton("OK");
        okBtn.setPreferredSize(new Dimension(80,30));
        JButton cancelBtn = new JButton("Cancel");
        cancelBtn.setPreferredSize(new Dimension(80,30));

        btnsPnl.add(okBtn);
        btnsPnl.add(cancelBtn);

        //JFrame에 큰 패널 3개 붙이기
        this.add(namePnl);
        this.add(emailPnl);
        this.add(btnsPnl);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new GuiEmail();
    }
}
