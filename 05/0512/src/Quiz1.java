import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Quiz1 extends JFrame implements ActionListener, KeyListener {
    JLabel lblQ, lblA, lblR;
    JButton btn;
    //문제, 보기, 답 배열로 만들어 놓기

    String[] que = {"정수 타입의 변수를 설정한 것 중 맞는 것은?",
            "자바에서 int, float와 같은 타입을 기초변수라 한다. String같이 대문자로 시작하거나 new로 생성하는 변수는 무슨 변수?",
            "자바에서 sum=sum+1 처럼 값 1씩 증가시키면서 쌓기를 줄여서 쓰면?"};
    //1차원 배열 형식
	/*String[] ans = {"1.int a  2.float b  3.String c  4.char d",
					"1.레퍼런스 변수   2.특수 변수    3.문자형 변수    4.타입 변수",
					"1.sum=+1  2.sum+=1  3.sum=++  4.sum++="};*/
    //2차원 배열 형식
	/*String[][] ans = {
						{"1.int a", "2.float b", "3.String c", "4.char d"},
						{"1.레퍼런스 변수", "2.특수 변수", "3.문자형 변수", "4.타입 변수"},
						{"1.sum=+1", "2.sum+=1", "3.sum=++", "4.sum++="}
					 };*/
    //또다른 방식 - split()과 특수문자
    String[] ans = {"1.int a/2.float b/3.String c/4.char d",
            "1.레퍼런스 변수/2.특수 변수/3.문자형 변수/4.타입 변수",
            "1.sum=+1/2.sum+=1/3.sum=++/4.sum++="};

    int[] rans = {1, 1, 2};

    int queNum = 0;//문제 번호 = 배열 번호 = 증가하면 다음 배열값 가져오기

    int score;//점수

    public Quiz1() {
        this.setDefaultCloseOperation(3);
        this.setSize(700, 300);
        this.setLayout(new GridLayout(0, 1));

        this.addKeyListener(this);
        this.requestFocus();
        this.setFocusable(true);

        JPanel pnl = new JPanel();

        lblQ = new JLabel("문제");
        lblA = new JLabel("보기");
        this.add(lblQ);
        this.add(lblA);

        //JLabel(여기)에 바로 써도 되지만 보기 좋게 여기서 후처리로 값을 바꿀거다!
        lblQ.setText(que[queNum]);
        //lblA.setText(ans[queNum]);//1차원 배열 형식

        //2차원 배열 형식
        //lblA.setText("<html>" + ans[queNum][0]  + "<br>" + ans[queNum][1]  + "<br>" + ans[queNum][2]  + "<br>" + ans[queNum][3]  + "<br>" + "</html>");

        //또다른 방식 - split()과 특수문자
        lblA.setText("<html>" + ans[queNum].split("/")[0]  + "<br>" + ans[queNum].split("/")[1]  + "<br>" + ans[queNum].split("/")[2]  + "<br>" + ans[queNum].split("/")[3]  + "<br>" + "</html>");

        lblR = new JLabel("결과");
        btn = new JButton("다음 문제");
        btn.addActionListener(this);
        pnl.add(lblR);
        pnl.add(btn);
        this.add(pnl);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.requestFocus();
        this.setFocusable(true);

        if (lblR.getText().equals("정답")) {
            score+=10;
        }

        if (queNum>=que.length-1) {//마지막 문제 후 에러 처리
            JOptionPane.showMessageDialog(this, "문제가 끝났습니다. 점수는 " + score);
        } else {
            queNum++;//누를 때 마다 1씩 증가
            lblQ.setText(que[queNum]);
            lblA.setText("<html>" + ans[queNum].split("/")[0]  + "<br>" + ans[queNum].split("/")[1]  + "<br>" + ans[queNum].split("/")[2]  + "<br>" + ans[queNum].split("/")[3]  + "<br>" + "</html>");
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int type = 0;

        if (e.getKeyCode()==49 || e.getKeyCode()==97) {
            type = 1;
        } else if (e.getKeyCode()==50 || e.getKeyCode()==98) {
            type = 2;
        } else if (e.getKeyCode()==51 || e.getKeyCode()==99) {
            type = 3;
        } else if (e.getKeyCode()==52 || e.getKeyCode()==100) {
            type = 4;
        }

        if (type==rans[queNum]) {
            lblR.setText("정답");
        } else {
            lblR.setText("오답");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}

    public static void main(String[] args) {
        new Quiz1();
    }
}