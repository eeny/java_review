import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ServerEx1 extends JFrame implements ActionListener {
    JTextArea taChat, taUser;
    JTextField tf;

    Socket sSocket;
    BufferedReader in;
    PrintWriter out;
    ServerSocket server;

    public ServerEx1() {
        init();

        serverSetting();
    }

    void init() {
        //UI 설정
        this.setDefaultCloseOperation(3);
        this.setSize(500, 500);
        this.setTitle("채팅 서버");

        taChat = new JTextArea("===채팅내용===\n");//괄호안에 글씨는 미리 써져 있을 글씨
        JScrollPane spChat = new JScrollPane(taChat);
        this.add(spChat);

        taUser = new JTextArea("==접속자==\n");
        JScrollPane spUser = new JScrollPane(taUser);
        this.add(spUser, "East");

        tf = new JTextField();
        tf.addActionListener(this);// tf에 액션을 붙이면 엔터로 이벤트 가능
        this.add(tf, "South");

        this.setVisible(true);

    }

    void serverSetting() {// 채팅서버 관련
        //1 ServerSocket 만들기
        //2 만들어진 ServerSocket를 이용해서 accept() 로 연결 Socket 설정
        //3 input/output 설정
        //4 or 5 input 대기
        //4 or 5 output으로 클라이언트에 채팅 전송

        // 여기서 쓰레드를 써야 하는 이유는 내가 클라이언트로 내용을 보내기 위해서
        // 글을 쓰고 있는 와중에도 클라이언트가 보내는 내용을 계속 읽어드리고 있어야 한다.
        // 서버 -> 클라 (송신)  // 클라 -> 서버 (수신)  이 두개가 동시에 실행 되야함.
        // 또한 동시에 여러명이 접속 가능하게 통신을 해야 하므로 쓰레드 필수요함.

        // 네트워크는 무조건 input/output에 관련된 예외가 발생이 예상됩니다.
        try {

            server = new ServerSocket(5555);// 서버만들기

            taChat.append("접속을 기다립니다.\n");

            sSocket = server.accept();// 접속과 동시에 서버로부터 소켓을 가져옴
            // 이 accept()는 클라이언트에서 Socket이 만들어 짐과 동시에 접속됨
            // 접속을 위해 대기 하는 메서드. 접속이 되면 양쪽다 Socket으로 연결됨

            taChat.append("클라이언트가 접속했습니다.\n");

            in = new BufferedReader(
                    new InputStreamReader(
                            sSocket.getInputStream()));
            out = new PrintWriter(sSocket.getOutputStream());

            out.println("접속을 환영합니다.");// 클라이언트에 이 내용 전송

            // 버퍼를 이용해서 만들어진 out 이므로 한번 전송할때 마다 만드시 버퍼의 내용을
            // 다 보내줘야지 안그러면 버퍼의 용량이 찰때까지 계속 안보냄

            out.flush();// 버퍼의 내용 강제로 다 내보내기.

            // 클라리언트로 들어오는 내용 읽기
            String msg = in.readLine(); //"안녕서버야" 라는 글씨 받기
            taChat.append(msg + "\n");


            while ((msg = in.readLine()) != null) {
                taChat.append(msg + "\n");
            }


        } catch (IOException e) {
            e.printStackTrace();//발생하는 예외 출력하라.
        } finally {
            try {
                if (out != null) out.close();
                if (in != null) in.close();
                if (sSocket != null) sSocket.close();
                if (server != null) server.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        new ServerEx1();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // tf에 액션을 달았으므로 tf에서 엔터를 치면 실행
        out.println(tf.getText());//tf에 썼던글을 out(클라이언트)에게 전송
        out.flush();
        taChat.append(tf.getText() + "\n");// 내 tf에 붙이기
    }

}