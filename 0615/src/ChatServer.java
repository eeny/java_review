import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class ChatServer {// 쓰레드가 아님.
    HashMap<String, PrintWriter> map = null;// 접속할때 마다 이 변수를 돌려쓰면서 값을 채움
    // HashMap 쓰는 이유? 누가 접속했는지 접속한 클라이언트들을 전부 담기 위해서!
    // 채우는 내용은 접속한 id,out

    // 서버 소켓을 이용해 각 클라이언트들의 소켓과 연결을 시킨다!
    // 클라이언트들이 서버 소켓에 접근하려면 서버 소켓에서 설정해놓은 정보로 접근을 해야한다!
    // 서버는 어차피 클라이언트에서 접근하는 걸 받기만 하니까
    // 자기자신의 IP는 쓸 필요가 없고, 포트 번호는 자유니까 미리 설정을 해둔다!(여기로 들어와라~)
    // 클라이언트는 서버에 접속해야 하므로 서버의 IP와 포트번호가 모두 필요하다!
    ServerSocket server = null;

    public ChatServer() {
        try {
            map = new HashMap<>();
            server = new ServerSocket(5000);// 서버 설정
            System.out.println("접속을 기다립니다.");

            // 접속할 때 마다 채팅을 위한 전용 쓰레드 만듬
            // 각각 접속하는 클라이언트마다 연결을 해줘야하기 때문에
            // 전용 스레드를 만들어줘야 한다!
            while (true) {
                Socket socket = server.accept();// 클라이언트가 접속할때마다 실행됨
                // 접속이 됐으니까 넘어가야합니다. 쓰레드 만들기
                ChatThread chatThread = new ChatThread(socket, map);
                chatThread.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ChatServer();
    }
}// ChatServer 클래스 끝

// 아예 다른 클래스 (내부 클래스 아님!!!)
class ChatThread extends Thread {
    Socket socket;// 클라이언트랑 연결한 서버쪽 소켓
    HashMap<String, PrintWriter> map;
    PrintWriter out;
    BufferedReader in;
    String id;

    public ChatThread(Socket socket, HashMap<String, PrintWriter> map) {
        this.socket = socket;
        this.map = map;

        try {
            out = new PrintWriter(socket.getOutputStream());
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // 클라이언트가 접속할 때 바로 id부터 입력하라고 정하겠습니다.
            // 그래서 접속과 동시에 id를 받아서 처리할 수 있도록 하겠습니다.
            String id = in.readLine();
            // 처음에 접속과 동시에 아이디를 입력받으므로 무조건 여기에는 값을 받을 수 있다.
            System.out.println("[" + id + "]님이 접속 했습니다.");

            map.put(id, out);
            // 접속하는 모든 클라이언트의 정보를 들고 있다!
            // 또한 id를 들고 있으므로 차후 id를 통해서 귓말도 보낼 수 있다.
            out.println("서버:[" + id + "]님 환영합니다.");
            out.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
        // 여기까지가 쓰기 위한 준비
    }// 생성자 끝

    // 계속 들어오는 글을 읽는다!
    @Override
    public void run() {
        try {
            String msg = null;
            while ((msg = in.readLine()) != null) {
                System.out.println(id + ":" + msg);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}// 클래스 끝