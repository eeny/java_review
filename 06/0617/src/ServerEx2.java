import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
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

public class ServerEx2 extends JFrame implements ActionListener, WindowListener {
    JTextArea taChat, taUser;
    JTextField tf;

    Socket sSocket;
    ServerSocket server;
    HashMap<String, PrintWriter> map;// String으로 ID를 받아서 귓속말+삭제시 id로 가능
    //Vector<PrintWriter> v;

    public ServerEx2() {
        init();
        serverSetting();
    }

    void init() {
        this.setDefaultCloseOperation(3);
        this.setSize(500, 500);
        this.setTitle("채팅 서버2");
        taChat = new JTextArea("===채팅내용===\n");
        JScrollPane spChat = new JScrollPane(taChat);
        this.add(spChat);
        taUser = new JTextArea("==접속자==\n");
        JScrollPane spUser = new JScrollPane(taUser);
        this.add(spUser, "East");
        tf = new JTextField();
        tf.addActionListener(this);
        this.add(tf, "South");

        this.addWindowListener(this);

        this.setVisible(true);
    }

    void serverSetting() {// 채팅서버 관련
        try {
            //v = new Vector<>();
            map = new HashMap<>();

            server = new ServerSocket(5555);
            taChat.append("접속을 기다립니다.\n");
            while (true) {
                sSocket = server.accept();// 계속 실행되어야 클라이언트가 계속 접속가능
                //System.out.println("accept 실행됨");
                //taChat.append("클라이언트가 접속했습니다.\n");

//            (new ServerEx2Thread(sSocket, taChat, v)).start();
                (new ServerEx2Thread(sSocket, taChat, taUser, map)).start();
                // 생성자의 매개변수로 던져주는것은 중복해서 생성되면 안되는것!!
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
            /*if(out != null) out.close();
            if(in != null) in.close();*/
                if (sSocket != null) sSocket.close();
                if (server != null) server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        new ServerEx2();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // 서버에서 클라이언트로 보내기.
        // in,out을 다른 쓰레드 클래스에서 만들어 사용함으로 여기서 in,out을 사용할수 없다.
        // 그래서 역으로 쓰레드에서 우리는 in,out을 가져와야 한다.

      /*out.println(tf.getText());
      out.flush();*/

      /*for(int i=0;i<v.size();i++){
         v.get(i).println(tf.getText());
         v.get(i).flush();
      }*/

        for (Map.Entry<String, PrintWriter> entry : map.entrySet()) {
            map.get(entry.getKey()).println(tf.getText());
            map.get(entry.getKey()).flush();
        }

        taChat.append(tf.getText() + "\n");
        taChat.selectAll();

        if (tf.getText().split(" ")[0].equals("/k")) {
            // 강퇴처리     - /k aaa <= aaa 강퇴
            map.get(tf.getText().split(" ")[1]).println("/k");
            map.get(tf.getText().split(" ")[1]).flush();
        }
    }

    @Override
    public void windowClosing(WindowEvent e) {
        for (Map.Entry<String, PrintWriter> entry : map.entrySet()) {
            map.get(entry.getKey()).println("/kall");
            map.get(entry.getKey()).flush();
        }
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowOpened(WindowEvent e) {
    }
}

class ServerEx2Thread extends Thread {
    BufferedReader in;
    PrintWriter out;
    String msg;
    Socket sSocket;
    JTextArea taChat, taUser;
    //Vector<PrintWriter> v;
    HashMap<String, PrintWriter> map;
    String id;

    //public ServerEx2Thread(Socket sSocket, JTextArea taChat, Vector<PrintWriter> v) {
    public ServerEx2Thread(Socket sSocket, JTextArea taChat, JTextArea taUser, HashMap<String, PrintWriter> map) {
        try {
            this.sSocket = sSocket;
            this.taChat = taChat;
            //this.v = v;
            this.map = map;
            this.taUser = taUser;

            in = new BufferedReader(new InputStreamReader(sSocket.getInputStream()));
            out = new PrintWriter(sSocket.getOutputStream());


            out.println("접속을 환영합니다.");
            out.flush();
         /*msg = in.readLine();// id 받는거랑 같음
         taChat.append(msg+"\n");*/

            //v.add(out);// 여기서 add 하면 SeverEx2 클래스의 v에 추가되는것과 같다.

            // 클라이언트가 접속전에 ID를 만들어서 접속과 동시에 id를 써버로 보냄.
            id = in.readLine();// 클라이언트가 보내는 id 받기

            // 서버에 클라이언트가 동시에 접속할 경우가 있음. 그때 두개가 충돌남
            // 그래서 동기화 처리를 합니다.
            synchronized (map) {
                map.put(id, out);
            }

            taChat.append("[" + id + "]님이 접속하셨습니다.\n");
            taChat.setCaretPosition(taChat.getDocument().getLength());

            // 여기까지 작업이 접속세팅완료. 채팅테스트 완료
            // map 에 아이디가 추가된걸 확인 가능함.
            // map 에 있는 모든 아이디를 문자열로 만들어서 클라이언트에게 던져주기
            // 이러면 이부분에 시작되는 코드는 누구든지 새로 접속 할때 모든 클라이언트에게
            // map 에 있는 모든 아이디를 보낼 수 있다.

            broadcastInfo("/list " + getUserList());// 클라이언트 한테 뿌리기
            setUserData(getUserList());// 나(서버) 한테 뿌리기


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void setUserData(String data) {// data = aaa,bbb,ccc
        taUser.setText("=접속자=\n");
        String[] user = data.split(",");
        for (int i = 0; i < user.length; i++) {
            taUser.append(user[i] + "\n");
        }
    }

    String getUserList() {
        String result = "";

        if (map.size() > 0) {
            // 맵에 있는 모든 아이디 뽑아오기
            for (Map.Entry<String, PrintWriter> entry : map.entrySet()) {
                result += entry.getKey() + ",";//문자열로 만들어진 아이디
            }

            // 아이디가 aaa bbb 두개가 있다고 친다면 result는 aaa,bbb, <=결과 마지막 ,를 없애자
            result = result.substring(0, result.lastIndexOf(","));
        }

        // result 에는 이제 aaa,bbb <= 이렇게 들어있다.
        return result;
    }

    void wisper(String friend, String text) {
        map.get(friend).println("[" + id + "님의 귓속말]" + text);
        map.get(friend).flush();
    }


    @Override
    public void run() {
        try {
            while ((msg = in.readLine()) != null) {// 클라이언트의 글씨 읽기
                if (msg.split(" ")[0].equals("/w")) {
                    //     /w 아이디 내용
                    wisper(msg.split(" ")[1], msg.split(" ")[2]);

                } else if (msg.equals("/quit")) {//종료
                    out.println("/quit");// 나한테 이메시지 보낸 사람한테 다시 /quit를 보냄
                    out.flush();
                    break;
                } else if (msg.split(" ")[0].equals("/k")) {//   /k aaa
                    if (id.equals(msg.split(" ")[1])) {
                        out.println("본인은 강퇴가 불가합니다.");
                        out.flush();
                    } else {
                        map.get(msg.split(" ")[1]).println("/k");
                        map.get(msg.split(" ")[1]).flush();
                    }

                } else {
                    broadcast();
                }


                taChat.append(msg + "\n");
                taChat.setCaretPosition(taChat.getDocument().getLength());


                //msg는 클라이언트로 부터 들어오는 내용임
                // 이거를 다른 클라이언트들에게도 다시 전달하면됨

                //out.println(msg); // 이거는 이 쓰레드를 사용하는 그 클라이언트만 내용을 받음

            /*for(int i=0;i<v.size();i++){
               v.get(i).println(msg);
               v.get(i).flush();
            }*/

            /*
            synchronized (map) {// 쓰레드를 무시하고 무조건 이거 실행될동안 쓰레드 멈춤
               for(Map.Entry<String, PrintWriter> entry:map.entrySet()){
                  map.get(entry.getKey()).println("["+entry.getKey()+"]"+msg);
                  map.get(entry.getKey()).flush();
               }
            }*/


            }
            // 첫번클라이언트의 readLine while이 계속 실행되고 있으므로
            // 새로운 클라이언트가 접속해도 더이상 작동하지 않는다
            // 왜냐면 첫번클라이언트의 readLine while이 끝이 안났기 때문에


            taChat.append("[" + id + "]님이 종료하였습니다.\n");

            map.remove(id);// 맵에서 삭제

            // 밑의 두 코드는 맵의 내용을 읽어서 처리 하기때문에 위에서 삭제했기 때문에 처리가 됨
            broadcastInfo("/list " + getUserList());// 클라이언트 한테 뿌리기


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) in.close();
                if (out != null) out.close();
                if (sSocket != null) sSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }//while 끝


        setUserData(getUserList());// 나(서버) 한테 뿌리기
    }// run 끝

    void broadcastInfo(String info) {
        for (Map.Entry<String, PrintWriter> entry : map.entrySet()) {
            map.get(entry.getKey()).println(info);
            map.get(entry.getKey()).flush();
        }
    }

    void broadcast() {
        synchronized (map) {// 쓰레드를 무시하고 무조건 이거 실행될동안 쓰레드 멈춤
            for (Map.Entry<String, PrintWriter> entry : map.entrySet()) {
                // 욕설 처리
                // msg 안에는 정상적으로 내용이 들어옵니다.
                // 그부분을 처리하셔서 msg의 내용을 바꿔서 보내 면됩니다.
                // 감자, 고구마, 호박 이글자가 들어오면 *** 처리 해서 보냅니다.

                // 들어오는 msg를 미리 수정해서  밑에 있는 내용을 뿌리면된다.

                msg = msg.replace("감자", "**");
                msg = msg.replace("고구마", "***");
                msg = msg.replace("호박", "**");

                map.get(entry.getKey()).println("[" + entry.getKey() + "]" + msg);
                map.get(entry.getKey()).flush();
            }
        }
    }
}







