import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class QuizClientGUI extends JFrame implements ActionListener {
    JButton btn;
    JTextArea ta;
    JPanel pnl;
    JTextField tf;
    PrintWriter out;
    BufferedReader in;
    Socket quizSocket;

    public QuizClientGUI() {
        this.setDefaultCloseOperation(3);
        this.setSize(500, 500);
        this.setTitle("클라이언트");

        pnl = new JPanel();
        tf = new JTextField(7);
        btn = new JButton("전송");
        btn.addActionListener(this);
        pnl.add(tf);
        pnl.add(btn);
        this.add(pnl, "South");

        ta = new JTextArea();
        JScrollPane sp = new JScrollPane(ta);
        this.add(sp);

        try {
            quizSocket = new Socket("127.0.0.1", 5555);
            in = new BufferedReader(new InputStreamReader(quizSocket.getInputStream()));
            out = new PrintWriter(quizSocket.getOutputStream(), true);

        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        this.setVisible(true);

    }

    public static void main(String[] args) {
        new QuizClientGUI();
    }

    @Override

    public void actionPerformed(ActionEvent e) {
        String fromServer;
        String fromUser;

        try {
            while ((fromServer = in.readLine()) != null) {
                ta.append(fromServer + "\n");
                // 문제점
                // 생성과 동시에 접속이 되며, 접속이 되는 순간 입력을 받아야 하는데
                // actionListener가 실행되지 않고 계속 while문 안에서 맴돌면서 멈춘다
                // Thread로 해결해야함!

                out.print(tf.getText());

                if (fromServer.equals("quit"))
                    break;
            }

            in.close();
            quizSocket.close();
            out.close();

        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}