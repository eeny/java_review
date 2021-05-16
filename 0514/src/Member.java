import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Member extends JFrame implements ActionListener {
    final String FILE_NAME = "member.txt";//파일명은 정해놓고 거기다 덮어씌우기만 한다!

    JPanel pnlCenter, pnlSouth, pnlSub;
    JLabel lblTitle, lblId, lblPw, lblName, lblEmail, lblGender;
    JTextField tfId, tfPw, tfName, tfEmail;
    JRadioButton raMan, raWoman;
    JButton btnRegi, btnCancel;

    public Member() {
        this.setDefaultCloseOperation(3);
        this.setSize(300, 250);

        lblTitle = new JLabel("회원가입");
        lblTitle.setFont(new Font("굴림", Font.BOLD, 24));
        lblTitle.setHorizontalAlignment(JLabel.CENTER);
        this.add(lblTitle, "North");

        pnlCenter = new JPanel(new GridLayout(0, 2));
        lblId = new JLabel("아이디");
        lblPw = new JLabel("비밀번호");
        lblName = new JLabel("이름");
        lblEmail = new JLabel("이메일");
        lblGender = new JLabel("성별");

        tfId = new JTextField();
        tfPw = new JTextField();
        tfName = new JTextField();
        tfEmail = new JTextField();

        pnlSub = new JPanel();
        raMan = new JRadioButton("남");
        raWoman = new JRadioButton("여");
        ButtonGroup bg = new ButtonGroup();
        bg.add(raMan);
        bg.add(raWoman);
        raWoman.setSelected(true);
        pnlSub.add(raMan);
        pnlSub.add(raWoman);

        pnlCenter.add(lblId);
        pnlCenter.add(tfId);
        pnlCenter.add(lblPw);
        pnlCenter.add(tfPw);
        pnlCenter.add(lblName);
        pnlCenter.add(tfName);
        pnlCenter.add(lblEmail);
        pnlCenter.add(tfEmail);
        pnlCenter.add(lblGender);
        pnlCenter.add(pnlSub);
        this.add(pnlCenter);

        pnlSouth = new JPanel();
        btnRegi = new JButton("가입");
        btnRegi.addActionListener(this);
        btnCancel = new JButton("취소");
        btnCancel.addActionListener(this);
        pnlSouth.add(btnRegi);
        pnlSouth.add(btnCancel);
        this.add(pnlSouth, "South");

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // 파일에 저장될 형식 :	1(인덱스 번호)/id/pw/name/email/gender

        if (e.getSource()==btnRegi) {//가입 버튼 눌렀을 때
            int idx = 1;
            // 인덱스 초기값 1로 주는 이유?
            // 만약에 가입자가 0명이라면 처음 만들어지는 사람의 번호를 그대로 사용하기 위해서

            File f = new File(FILE_NAME);

            boolean isExsit = false;// 동일한 아이디가 존재하는지 여부 판단하는 변수
            FileReader fr = null;
            BufferedReader br = null;

            try {// 동일한 아이디가 존재하는지 파일을 읽어와서 판단하는 try-catch 구문
                fr = new FileReader(f);// 파일을 한 개씩 읽어오고~
                br = new BufferedReader(fr);// 파일 내용을 한 줄씩 읽어온다~

                String l = null;// 파일에서 읽어온 한 줄을 넣는 변수

                while ((l = br.readLine())!= null) {// 읽어와서 넣을 줄이 더이상 없으면 (l에 들어가는 것이 null이면) while문 종료!
                    if (l.split("/")[1].equals(tfId.getText())) {// l에서 split()으로 자른 [1]인덱스에 값이 내가 입력한 아이디와 같으면~
                        // 한 줄을 읽어온 것이 l이다.
                        // l안의 내용 =>		1/aaaa/1234/홍홍홍/hhh@gggh.com/여
                        // split으로 자름     [0][1]  [2]  [3]     [4]      [5]
                        // if로 내가 입력한 tfId.getText()와 파일에 있던 [0]번째 내용 비교
                        // 같으면 존재한다는 의미로 변수 isExsit의 값을 true로 바꾸고
                        // 이미 있다는 게 확인이 되었으니, 굳이 다음 줄부터는 비교할 필요가 없으므로
                        // break로 while문을 빠져나간다! <= break는 인덱스 생성 안 할 경우에! 우리는 인덱스 필요하니까 break 안씀!

                        isExsit = true;// 동일한 아이디가 있다(true) 반환!
                    }

                    // 이 idx는 위에 아이디 중복 판단하는 if문이랑 상관없이 while문이 돌 때마다 idx에 값이 들어간다!!!
                    idx = Integer.parseInt(l.split("/")[0]);
                    // 인덱스 번호는 [0]번째에 있으니까 갖고와서 String형을 int로 형변환 해준다!
                    // while문이 파일에서 읽어온 줄 만큼 계속 돌다가 최종적으로는 마지막 줄의 인덱스번호(=최근에 입력된 인덱스번호)를 가져와서 idx변수에 집어넣는다!
                }
                // 빠져나오면 idx에는 제일 마지막 번호가 입력되어 있다!
                idx++;// 그러면 여기에는 제일 마지막 번호 +1 된 상태!
                // 만약에 첫번째 가입자면 파일이 없으니까 아예 위에 while문에서 FileNotFoundException이 발생해서 catch로 바로 빠져나간다!
                // 그래서 idx++; 부분이 아예 실행이 안된다!!!

                // 게시판에서 검색할 때 사용
				/*
				while ((l = br.readLine())!= null) {
					if (l.indexOf(tfId.getText()) > 0) {
						// 한 줄을 읽어올 때 마다 그 줄에 내가 입력한 아이디가 있으면
						// 숫자는 -1이 아니니까 양수(해당 아이디가 있다는 뜻)가 나온다.
						// 왜냐하면 그 아이디의 위치값을 가지고 있을테니까!
						// 문제점은 aaa, aaaa, aaa1 이런 거면 에러가 발생한다!
						isExsit = true;
					}
				}*/

            } catch (FileNotFoundException e2) {
                // e2.printStackTrace();
                // member.txt (지정된 파일을 찾을 수 없습니다) 에러가 발생하고 파일 생성이 되기는 한다! <= 동일한 아이디가 없는 경우니까 아래의 코드가 실행돼서 파일이 새로 생성된다!
                System.out.println("환영합니다. 첫 번째 가입자입니다.");

            } catch (IOException e1) {
                e1.printStackTrace();
            }// 동일한 아이디가 존재하는지 여부 판단하는 try-catch 끝

            if (isExsit==false) {//동일한 아이디가 없는 경우
                FileWriter fw = null;
                PrintWriter pw = null;

                try {
                    f = new File(FILE_NAME);
                    fw = new FileWriter(f, true);// true를 써주면 내용을 새로 덮어쓰는 게 아니라 추가해준다!
                    pw = new PrintWriter(fw);
                    // 세팅 끝
                    String gender = "남";
                    if (raWoman.isSelected()==true) {// 만약 여자가 선택됐다면
                        gender = "여";
                    }

                    pw.println(idx + "/" + tfId.getText() + "/" + tfPw.getText() + "/" + tfName.getText() + "/" + tfEmail.getText() + "/" + gender);
                    JOptionPane.showMessageDialog(this, "가입되었습니다.");

                } catch (IOException e1) {
                    e1.printStackTrace();
                } finally {
                    if (pw != null) {
                        pw.close();
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "이미 존재하는 아이디입니다.");
            }


        } else if (e.getSource()==btnCancel) {//취소 버튼 눌렀을 때
            tfId.setText("");
            tfPw.setText("");
            tfName.setText("");
            tfEmail.setText("");
        }
    }

    public static void main(String[] args) {
        new Member();
    }
}