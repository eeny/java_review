import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClientGUI_v1 extends JFrame implements ActionListener, WindowListener {
    JTextArea ta;
    JTextField tf;
    PrintWriter out;
    BufferedReader in;
    Socket socket;

    String id;
    String ip;

    public ChatClientGUI_v1() {
        init();
        clientSetting();
    }

    void init() {
        this.setSize(500, 500);
        this.setDefaultCloseOperation(3);
        this.setTitle("클라이언트");
        ta = new JTextArea("===채팅내용===\n");
        JScrollPane sp = new JScrollPane(ta);
        tf = new JTextField();
        tf.addActionListener(this);

        this.addWindowListener(this);

        this.add(sp);
        this.add(tf, "South");
        this.setVisible(true);

    }

    void clientSetting() {
        id = JOptionPane.showInputDialog("아이디 입력");
        ip = JOptionPane.showInputDialog("접속할 IP 입력", "127.0.0.1");

        // 클라이언트 구분이 안돼서 추가해야지...
        this.setTitle("클라이언트" + id);

        try {
            socket = new Socket(ip, 5000);
            out = new PrintWriter(socket.getOutputStream());
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out.println(id);
            out.flush();

            // 서버가 보내는 내용을 계속 받기 위한 스레드 실행
            new ClientThreadGUI(in, out, ta, socket).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ChatClientGUI_v1();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        out.println(tf.getText());
        out.flush();

        // 대화 종료하는 부분
        // 클라이언트에서 /quit을 치면 서버에서 빠져나가고 창이 꺼진다!
        if (tf.getText().equals("/quit")) {
            System.exit(0);
        }

        tf.selectAll();
    }

    @Override
    public void windowOpened(WindowEvent e) {
    }

    // 클라이언트 창에 직접 X를 눌러서 종료하기
    @Override
    public void windowClosing(WindowEvent e) {
        out.println("/quit");
        out.flush();
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }
}

// 채팅 스레드 클래스 (내부 클래스 아님!)
// 서버로부터 들어오는 내용을 받아서 화면에 띄우는 등 처리를 하는 부분!
class ClientThreadGUI extends Thread {
    BufferedReader in;
    PrintWriter out;// close() 하기 위해서 만들었다!
    JTextArea ta;
    Socket socket;

    public ClientThreadGUI(BufferedReader in, PrintWriter out, JTextArea ta, Socket socket) {
        this.in = in;
        this.out = out;
        this.ta = ta;
        this.socket = socket;
    }

    @Override
    public void run() {
        String msg = null;

        try {
            while ((msg = in.readLine()) != null) {
                // 서버가 보내는 글자를 그대로 뿌린다!

                // 서버가 클라이언트 강퇴시키는 경우
                // 서버한테 /quit 보내라~! 라고 강제로 서버로부터 명령을 받는다!
                if (msg.indexOf("/quit") == 0) {
                    out.println("/quit");
                    out.flush();
                    System.exit(0);

                    // 서버가 보내는 글자들을 받아서 화면에 출력하는 부분
                } else {
                    ta.append(msg + "\n");
                    // 글씨가 자동 추가될 때 스크롤바가 안움직이는것을 수정
                    // 스크롤바를 맨 끝으로 보내라~
                    ta.setCaretPosition(ta.getDocument().getLength());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
                if (out != null) {
                    in.close();
                }
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}