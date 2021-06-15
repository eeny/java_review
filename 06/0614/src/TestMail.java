/*
import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
// 순수하게 메일을 보내기 위한 jar 파일(라이브러리)을 사용하는 방법!
// 고정된 방법이라서 코드를 일일이 이해할 필요는 없다!
public class TestMail extends JFrame implements ActionListener {
    // 지메일의 경우 보안수준을 설정해줘야 메일이 보내진다!
    // 참고 블로그 - https://jinseongsoft.tistory.com/294
    final static String googleId = "";// 구글 아이디
    final static String googlePw = "";// 구글 비밀번호
    final static String googleEmail = "";// 본인구글아이디@gmail.com 구글 이메일

    JPanel north1;
    JLabel des1;
    JTextField email;

    JPanel north2;
    JLabel des2;
    JTextField title;
    JButton send;

    JPanel center;
    JLabel des3;
    JTextArea contents;

    TestMail() {
        north1 = new JPanel(new BorderLayout());
        des1 = new JLabel("보낼 이메일 : ");
        email = new JTextField();
        north1.add(des1, BorderLayout.WEST);
        north1.add(email, BorderLayout.CENTER);

        north2 = new JPanel(new BorderLayout());
        des2 = new JLabel("제목 : ");
        title = new JTextField();
        send = new JButton("보내기");

        send.addActionListener(this);

        north2.add(des2, BorderLayout.WEST);
        north2.add(title, BorderLayout.CENTER);
        north2.add(send, BorderLayout.EAST);

        north2.add(north1, BorderLayout.NORTH);
        this.add(north2, BorderLayout.NORTH);

        contents = new JTextArea();
        des3 = new JLabel("내용 : ");
        center = new JPanel(new BorderLayout());
        center.add(des3, BorderLayout.WEST);
        center.add(contents, BorderLayout.CENTER);

        this.add(center, BorderLayout.CENTER);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(500, 300);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        sendMail(googleId, googlePw, googleEmail, email.getText(), title.getText(), contents.getText());
    }

    public void sendMail(String id, String pw, String sendMail, String destinationMail, String title, String contents) {
        // Properties는 일종의 맵
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", 465);
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.ssl.enable", "true");
        prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        // 이 설정은 구글 메일에서 OutLookExpress 설정을 검색하면 유사한 값들을 볼 수 있다!
        // 정해진 설정이므로 그대로 쓰면 된다!

        // 이 부분을 쓰는 이유?
        // 비밀번호 타입으로 모양을 바꿔준다! 세션에 값을 담고, 보안설정을 한다!
        Session session = Session.getDefaultInstance(prop, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(id, pw);
            }
        });
        // ===== 여기까지가 보낼 데이터 설정 =====

        try {
            // 보내기 위한 객체
            MimeMessage message = new MimeMessage(session);
            // ===== 여기에서 보내겠다~ =====
            message.setFrom(new InternetAddress(sendMail));

            // 수신자메일주소
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(destinationMail));

            // Subject
            message.setSubject(title); // 메일 제목을 입력

            // Text
            message.setText(contents); // 메일 내용을 입력

            // send the message
            Transport.send(message); // 전송
            System.out.println("message sent successfully...");

        } catch (AddressException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        new TestMail();
    }

}*/
