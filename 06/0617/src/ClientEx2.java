import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ClientEx2 extends JFrame implements ActionListener, WindowListener {
    JTextArea taChat, taUser;
    JTextField tf;
    Socket cSocket;
    BufferedReader in;
    PrintWriter out;
    String id;

    public ClientEx2() {
        init();
        clientSetting();
    }

    void init() {
        this.setSize(500, 500);
        this.setDefaultCloseOperation(3);
        this.setTitle("클라이언트2");
        taChat = new JTextArea("===채팅 내용===\n");
        JScrollPane spChat = new JScrollPane(taChat);
        this.add(spChat);

        taUser = new JTextArea("=접속자=\n");
        JScrollPane spUser = new JScrollPane(taUser);
        spUser.setPreferredSize(new Dimension(150, 500));
        this.add(spUser, "East");

        tf = new JTextField();
        tf.addActionListener(this);
        this.add(tf, "South");

        this.addWindowListener(this);

        this.setVisible(true);
    }

    void clientSetting() {
        try {
            id = JOptionPane.showInputDialog("아이디를 입력하세요");
            this.setTitle("클라이언트2(" + id + ")");
            cSocket = new Socket("localhost", 5555);
            in = new BufferedReader(new InputStreamReader(cSocket.getInputStream()));
            out = new PrintWriter(cSocket.getOutputStream());
            String msg = in.readLine();
            taChat.append(msg + "\n");
            out.println(id);
            out.flush();

            (new ClientEx2Thread(in, out, cSocket, taChat, taUser)).start();


        } catch (UnknownHostException e) {// ip주소 잘못됐을때
            e.printStackTrace();
        } catch (IOException e) {// 서버없이 클라이언트를 키면 이 예외 발생
            //System.out.println(22);
            //e.printStackTrace();
            JOptionPane.showMessageDialog(this, "서버를 먼저 켜주세요");
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new ClientEx2();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //taChat.append(tf.getText());
        out.println(tf.getText());
        out.flush();
        tf.selectAll();
    }

    @Override
    public void windowClosing(WindowEvent e) {
        out.println("/quit");
        out.flush();
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

class ClientEx2Thread extends Thread {
    BufferedReader in;
    PrintWriter out;
    Socket cSocket;
    JTextArea taChat, taUser;

    public ClientEx2Thread(BufferedReader in, PrintWriter out, Socket cSocket, JTextArea taChat, JTextArea taUser) {
        this.in = in;
        this.out = out;
        this.cSocket = cSocket;
        this.taChat = taChat;
        this.taUser = taUser;
    }

    void setUserData(String data) {// data = aaa,bbb,ccc
        taUser.setText("=접속자=\n");
        String[] user = data.split(",");
        for (int i = 0; i < user.length; i++) {
            taUser.append(user[i] + "\n");
        }
    }

    @Override
    public void run() {
        String msg = null;
        try {
            while ((msg = in.readLine()) != null) {
                if (msg.equals("/quit")) {
                    break;
                } else if (msg.equals("/k")) {
                    out.println("/quit");
                    out.flush();
                } else if (msg.split(" ")[0].equals("/list")) {
                    setUserData(msg.split(" ")[1]);
                } else if (msg.equals("/kall")) {
                    out.println("/quit");
                    out.flush();
                } else {
                    taChat.append(msg + "\n");
                    taChat.setCaretPosition(taChat.getDocument().getLength());
                }
            }
            // break가 처리되면 이쪽으로 옴.
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) out.close();
                if (in != null) in.close();
                if (cSocket != null) cSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
