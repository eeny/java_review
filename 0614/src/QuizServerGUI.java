import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class QuizServerGUI extends JFrame implements ActionListener {
    JButton btn;
    JLabel lbl;
    ServerSocket serverSocket;
    Socket clientSocket;

    public QuizServerGUI() {
        this.setDefaultCloseOperation(3);
        this.setSize(500, 500);

        btn = new JButton("서버시작");
        lbl = new JLabel();
        btn.addActionListener(this);
        this.add(btn, "South");
        this.add(lbl);

        this.setVisible(true);

        try {
            serverSocket = new ServerSocket(5555);
            clientSocket = serverSocket.accept();
            lbl.setText("클라이언트가 접속됨");

            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String inputLine, outputLine;

            QuizProtocol qp = new QuizProtocol();
            outputLine = qp.process(null);
            out.println(outputLine);

            while ((inputLine = in.readLine()) != null) {
                outputLine = qp.process(inputLine);
                out.println(outputLine);// 클라이언트로 보내기 - 문제가 계속 진행되는 한 계속 실행됨
                if (outputLine.equals("quit")) {
                    break;
                }
            }
            out.close();
            in.close();
            clientSocket.close();
            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new QuizServerGUI();
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {

    }
}