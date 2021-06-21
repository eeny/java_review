import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatServerGUI_v1 extends JFrame implements ActionListener {
    JTextArea ta_chat, ta_user;
    JTextField tf;
    HashMap<String, PrintWriter> map;
    boolean isStop = false;

    public ChatServerGUI_v1() {
        init();
        serverSetting();
    }

    // UI 설정
    void init() {
        this.setDefaultCloseOperation(3);
        this.setSize(500, 500);
        this.setTitle("서버");

        ta_chat = new JTextArea("=== 채팅 내용 ===\n");
        ta_user = new JTextArea("=== 접속자 ===\n");
        JScrollPane sp_chat = new JScrollPane(ta_chat);
        JScrollPane sp_user = new JScrollPane(ta_user);
        tf = new JTextField();
        tf.addActionListener(this);

        this.add(sp_chat);
        this.add(sp_user, "East");
        this.add(tf, "South");
        this.setVisible(true);
    }

    // 서버 관련
    void serverSetting() {
        try {
            ServerSocket server = new ServerSocket(5000);
            ta_chat.append("접속을 기다립니다.\n");// 실행과 동시에 뜬다!
            map = new HashMap<>();

            // 왜 true? 이론상 접속자를 계속 받을 수 있게 계속 대기상태로 있기 위해서
            while (true) {
                Socket socket = server.accept();
                // 접속을 하면 스레드가 실행한다!
                new Thread(new ChatThreadGUI(socket, ta_chat, ta_user, map)).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ChatServerGUI_v1();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // 서버에서 /k 아이디 치면 해당 아이디가 강퇴되는 기능
        if (tf.getText().indexOf("/k ") == 0) {
            // kick 메서드에 id를 담아서 실행!
            kick(tf.getText().split(" ")[1]);
            tf.selectAll();

            // 서버에서 /quit 치면 전체 종료
        } else if (tf.getText().indexOf("/quit") == 0) {

            for (Map.Entry<String, PrintWriter> entry : map.entrySet()) {
                // kick 메서드에 모든 id를 담아서 실행!
                kick(entry.getKey());
            }

            System.exit(0);

            // 서버에서 내용을 입력하고 그걸 모든 클라이언트에게 뿌리는 부분
        } else {
            ta_chat.append("[서버]:" + tf.getText() + "\n");
            broadcast("[서버]:" + tf.getText());
            tf.selectAll();
        }

    }

    void broadcast(String str) {
        // 접속한 모두에게 글씨 보내기
        // 왜? 서버니까 당연히 모두에게 보낼 수 있어야한다!
        // 게임으로 친다면 공지사항 게임 내 전체 채팅처럼!
        // 우리는 정보를 다 들고 있다. <= map이 다 들고 있다!

        for (Map.Entry<String, PrintWriter> entry : map.entrySet()) {
            entry.getValue().println(str);
            entry.getValue().flush();
        }
        // map안에 있는 모든 PrintWriter(=out)에게 글씨를 보낸다.
        // 방송 = 전체 채팅
    }

    void kick(String id) {
        map.get(id).println("/quit");
        map.get(id).flush();
    }
}

// 채팅 스레드
// 클라이언트로부터 들어오는 내용을 받아서 처리하는 부분!
class ChatThreadGUI extends Thread {
    // 이 스레드가 하는 일?
    // 클라이언트로부터 들어오는 내용을
    // ta_chat과 ta_user에다가 추가하는 일을 한다!
    Socket socket;
    JTextArea ta_chat, ta_user;
    HashMap<String, PrintWriter> map;

    PrintWriter out;
    BufferedReader in;
    String id;

    public ChatThreadGUI(Socket socket, JTextArea ta_chat, JTextArea ta_user, HashMap<String, PrintWriter> map) {
        this.socket = socket;
        this.ta_chat = ta_chat;
        this.ta_user = ta_user;
        this.map = map;
        // 굳이 전역으로 받아오는 이유?
        // 여기서 생성하게 되면 ChatServerGUI의 내용을 사용하는게 아니라 전부 다 새로 만들어진다.
        // 우리는 여기서 처음에 만들어진 그 ChatServerGUI의 컴포넌트들을 공용으로 사용해야 하므로 받아와야한다!

        try {
            // PrintWriter는 내부적으로 버퍼를 사용한다!
            out = new PrintWriter(socket.getOutputStream());
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            id = in.readLine();// 하나 받아왔다!
            ta_user.append(id + "\n");
            ta_chat.append("[" + id + "] 님께서 접속하였습니다.\n");

            map.put(id, out);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            String msg = null;
            while ((msg = in.readLine()) != null) {
                // 종료하면서 에러가 뜨지 않도록 처리(스레드 종료)

                // 서버에서 /quit을 쳐서 종료하고 싶을 때는~
                // 서버에서 접속한 클라이언트에게
                // 강제로 다시 서버에게 /quit 이라고 보내라! 라고 시킨다!
                // 그러면 원래 있던 이 코드가 실행되면서 자동으로 종료된다.
                if (msg.equals("/quit")) {
                    // 클라이언트가 /quit을 치면 그 클라이언트가 서버에서 빠져나가게 된다!
                    break;

                } else if (msg.indexOf("/w ") == 0) {
                    map.get(msg.split(" ")[1]).println("[" + id + "] 님의 귓속말 : " + msg);
                    map.get(msg.split(" ")[1]).flush();
                    // 버퍼라는 건 내용이 꽉차야지만 내보내므로 내용이 꽉 안차면 내보내질 않는다!
                    // flush()를 쓰게 되면 버퍼의 내용을 강제로 다 꺼내서 내보내라는 뜻!
                    // 우리가 엔터 칠 때마다 버퍼의 내용을 바로바로 내보내기 위해서 사용한다!

                } else {
                    ta_chat.append("[" + id + "] : " + msg + "\n");

                    // 나한테만 뿌리는 게 아니라 모두 다에게 뿌린다!
                    // 읽어온 글씨를 그대로 뿌린다
                    broadcast("[" + id + "] : " + msg + "\n");
                    // 다른 클라이언트가 서버로 글을 보내면
                    // 서버가 읽어서 접속한 모두에게 그 내용을 보낸다!
                }
            }

            // while()문을 빠져나오는 순간 여기서 끝! 더이상 쓸 수 없다!
            System.out.println("삭제전" + map.size());
            // 1이 나온다! 그런데 1이 나오는 게 맞는가? 아닌데? 0이 나와야할텐데...?
            // map("아이디", out);
            map.remove(id);
            // 이렇게 초기화를 해줘야한다!
            ta_chat.append("[" + id + "] 님이 나가셨습니다.\n");

            // 접속자 명단에서도 아이디를 삭제하는 부분
            // System.out.println(ta_user.getText());
            String tmp = ta_user.getText();
            tmp = tmp.replace(id + "\n", "");
            ta_user.setText(tmp);

            System.out.println("삭제후" + map.size());// 0이 나온다!

            // map은 클라이언트가 접속할 때마다
            // 그 클라인트용 스레드(클라이언트가 보내는 글씨를 받는 스레드)가 생성된다.

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }

                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    void broadcast(String str) {
        // 이 for()문은 통째로 외우자!!!
        // Map은 순서가 없다! List나 Vector처럼 get(idx)를 할 수가 없다!
        // 그래서 지금 이 코드는 Map에 있는 모든 내용을 순서와 상관없이
        // 하나씩 전부 다 가져오라~ 는 말이다!
        // entry에 1개의 Map데이터 객체가 담긴다.
        // put으로 넣었던 한 줄이 entry다.
        // entry getKey / getValue를 통해서 꺼내볼 수 있다!
        // Map에 있는 내용을 싹 다 가져오고 싶을 때 사용하면 된다!
        for (Map.Entry<String, PrintWriter> entry : map.entrySet()) {
            // Map에 들어있는 값들이 id(Key)와 out(Value)이니까
            // 이렇게 Map에서 getValue()를 하면 out을 가지고 온 것과 같다!
            // 그래서 바로 println()이나 flush()를 사용할 수 있는 것이다!
            entry.getValue().println(str);
            entry.getValue().flush();
        }
    }
}