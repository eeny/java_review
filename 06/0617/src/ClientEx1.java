import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ClientEx1 extends JFrame implements ActionListener {
    JTextArea taChat;
    JTextField tf;
    Socket cSocket;
    BufferedReader in;
    PrintWriter out;

    public ClientEx1() {
        init();
        clientSetting();
    }

    void init() {
        this.setSize(500, 500);
        this.setDefaultCloseOperation(3);
        taChat = new JTextArea("===채팅 내용===\n");
        JScrollPane spChat = new JScrollPane(taChat);
        this.add(spChat);

        tf = new JTextField();
        tf.addActionListener(this);
        this.add(tf, "South");

        this.setVisible(true);
    }

    void clientSetting() {
        try {
            cSocket = new Socket("localhost", 5555);//ip와 port 필요
            // 생성과 동시에 서버에 접속됨

            in = new BufferedReader(
                    new InputStreamReader(
                            cSocket.getInputStream()));
            out = new PrintWriter(cSocket.getOutputStream());

            // 쓰레드가 없다면 약간 문제가 생길수 있음.
            // 서버에서 out.println(환영합니다.) 이부분이 먼저 실행되지 않고
            // 하단의 in.readLine()가 먼저 실행될 경우 에러가 발생할 수 있다.
            // Thread를 쓰면 상관없지만 쓰레드가 없는 상황에서는
            // 해결하기 위해서 Thread.sleep(100) 정도 여기에 딜레이를 주고 실행하면 해결됨.

            String msg = in.readLine();// 서버가 처음 보낸 글 받는 부분
            taChat.append(msg + "\n");// "접속을 환영합니다." 이내용 받아서 ta에 붙이기

            // 써버에 보내기
            out.println("안녕 서버야");
            out.flush();


            while ((msg = in.readLine()) != null) {
                taChat.append(msg + "\n");
            }


        } catch (UnknownHostException e) {// ip주소 잘못됐을때
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ClientEx1();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        taChat.append(tf.getText());
        out.println(tf.getText());
        out.flush();

    }

}