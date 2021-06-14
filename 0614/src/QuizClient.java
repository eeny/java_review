import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

// p666 ~ 670 3가지 예제 중 세번째 순서
// 다음에 실행하기!
public class QuizClient {// p670 예제
    public static void main(String[] args) throws IOException {
        Socket quizSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;

        try {
            quizSocket = new Socket("localhost", 5555);// 연결됨
            // - 이부분이 server의 accept와 연결됨.

            // 서버로 보내는 아웃
            out = new PrintWriter(quizSocket.getOutputStream(), true);

            // 서버로 부터 들어오는 내용 읽어들이기
            in = new BufferedReader(new InputStreamReader(quizSocket.getInputStream()));

        } catch (UnknownHostException e) {
            System.err.println("localhost에 접근할 수 없습니다.");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("입출력 오류");
            System.exit(1);
        }

        BufferedReader user = new BufferedReader(new InputStreamReader(System.in));
        // 키보드로 부터 입력 받기

        String fromServer;
        String fromUser;

        while ((fromServer = in.readLine()) != null) {
            System.out.print("서버 : " + fromServer);
            if (fromServer.equals("quit"))
                break;

            fromUser = user.readLine();// 여러분이 입력한 글자.
            if (fromUser != null) {
                System.out.println("클라이언트 : " + fromUser);
                out.println(fromUser);
            }
        }
        out.close();
        in.close();
        quizSocket.close();
    }
}