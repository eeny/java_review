import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

// p666 ~ 670 3가지 예제 중 두번째 순서
// 먼저 실행하기!
public class QuizServer {// p666 예제
    public static void main(String[] args) throws IOException {
        // 서버 준비 1단계 - ServerSocket는 필수!!!
        ServerSocket serverSocket = null;

        try {
            // 서버 소켓 생성
            serverSocket = new ServerSocket(5555);
        } catch (IOException e) {
            System.err.println("다음의 포트번호를 연결할 수 없습니다: 5555");
            System.exit(1);
        }

        // 클라이언트가 접속되면 이 소켓을 이용한다.
        Socket clientSocket = null;

        try {
            // 연결을 기다린다.
            clientSocket = serverSocket.accept();

            // 테스트 코드
            System.out.println("클라이언트가 접속했습니다.");

            // ===== 서버와 클라이언트가 연결됨 =====

        } catch (IOException e) {
            System.err.println("accept() 실패");
            System.exit(1);
        }

        // 클라이언트로 보낼 때 사용
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

        // 클라이언트로부터 들어오는 내용을 받을 때 사용
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        clientSocket.getInputStream()));

        String inputLine, outputLine;

        QuizProtocol qp = new QuizProtocol();

        // null이 QuizProtocol로 가면 기본 세팅인 WAITING에 해당되는 구문이 실행된다!
        outputLine = qp.process(null);

        // 클라이언트에게 위의 글씨를 보낸다!
        // 시작했을 때 한 번만 보내는 부분
        out.println(outputLine);

        while ((inputLine = in.readLine()) != null) {
            // y/n, 문제들
            System.out.print(inputLine + " : 서버");

            outputLine = qp.process(inputLine);

            // 클라이언트로 보내기 - 문제가 계속 진행되는 한 계속 실행된다!
            // 만약 클라이언트가 만약 quit이라고 입력하면
            // inputLine으로 읽어들여서 다시 클라이언트에게 보낸다!
            out.println(outputLine);
            if (outputLine.equals("quit")) {
                break;
            }
        }

        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
    }
}