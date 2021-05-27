import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MemberRead extends JFrame implements ActionListener {
    JLabel lbl;
    JButton btn;
    BufferedReader br;// close() 할 때 쓰기 위해서

    public MemberRead() {
        this.setDefaultCloseOperation(3);
        this.setSize(300, 800);

        lbl = new JLabel();
        this.add(lbl);

        btn = new JButton("멤버 읽어오기");
        this.add(btn, "South");
        btn.addActionListener(this);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //if(e.getSource == btn) <= 버튼 하나 뿐이라서 필요 없다!
        File f = new File("member.txt");
        try {
            FileReader fr = new FileReader(f);
            br = new BufferedReader(fr);

            String l = null;

            //String result = "";
            // result = "";
            // result += l => "" + 1/asdf/dffff
            // result += l => "" + 1/asdf/dffff + 2/bbbb/defef

            String result = "<html>";
            // JLabel은 \n이 안먹혀서 html코드를 쓴 것! JTextArea라면 \n 쓰면 된다.

            while ((l = br.readLine()) != null) {
                //result = result + l;// 글 쌓기

                //result = result + l + "<br>";// 글 쌓기

                String[] str = l.split("/");
                // str[0] = 1
                // str[1] = asdf
                // str[2] = 1234
                // str[3] = 홍길동
                // str[4] = asdf@asdf.com
                // str[5] = 남
                result = result + "번호 : " + str[0] + "<br>";
                result = result + "아이디 : " + str[1] + "<br>";
                result = result + "비밀번호 : " + str[2] + "<br>";
                result = result + "이름 : " + str[3] + "<br>";
                result = result + "메일 : " + str[4] + "<br>";
                result = result + "성별 : " + str[5] + "<br>";
                result = result + "====================<br>";

            }
            result = result + "</html>";

            lbl.setText(result);

        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }


    }

    public static void main(String[] args) {
        new MemberRead();
    }
}