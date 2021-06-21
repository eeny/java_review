import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
    PrintWriter out;// 서버로 보내기 위해 필요
    BufferedReader in; // 서버로 부터 들어오는 내용 위해 필요
    Socket socket;

    public ChatClient() {
        Scanner sc = new Scanner(System.in);
        System.out.print("아이디를 입력해 주세요 : ");
        String id = sc.next();

        try {
            // 서버의 accept실행
            // 여기서 localhost는 서버의 ip주소이며, 5000운 서버가 지정한 포트번호
            socket = new Socket("localhost", 5000);
            out = new PrintWriter(socket.getOutputStream());
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out.println(id);// 실행과 동시에 id 넘겨줌
            out.flush();
            // print 는 절대 절대 절대!!! 저장이 아니다!!!
            // 쓴다. file.print 하면 파일에 쓴다는 뜻!
            // 지금우리 out은 클라이언트 입장에서 서버를 의미한다.
            // out.println(id)는 서버에 id를 쓴다.

            // 클라이언트도 쓰레드가 필요
            // 쓰레드가 하는 일(서버/클라이언트 동일)
            // 서버 입장에서는 클라이언트가
            // 클라이언트 입장에서는 서버가
            // 보내는 글을 계속 받기 위해 대기 하고 있는일을 함.
            (new ClientThread(in, out, socket)).start();
        } catch (IOException e) {

        }
    }

    public static void main(String[] args) {
        new ChatClient();
    }
}

//////////////////////////
class ClientThread extends Thread {
    BufferedReader in;
    PrintWriter out;
    Socket socket;// 서버랑 연결한 클라이언트쪽 소켓

    public ClientThread(BufferedReader in, PrintWriter out, Socket socket) {
        this.in = in;
        this.out = out;
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            String msg = null;

            while ((msg = in.readLine()) != null) {
                System.out.println(msg);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null)
                    in.close();
                if (out != null)
                    out.close();
                if (socket != null)
                    socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
