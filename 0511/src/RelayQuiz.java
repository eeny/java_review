import java.awt.Color;
import java.awt.event.*;

import javax.swing.*;

public class RelayQuiz extends JFrame implements ActionListener, KeyListener {
    JLabel blb, slb;
    JButton btn;
    int x;//문제 넘길 때 쓰는 변수. 초기값 0
    String[] str = {"<html>문제1. 다음 중 정수형인 것은?<br>(1)int<br>(2)String<br>(3)float<br>(4)boolean</html>",
            "<html>문제2. 다음 중 for문에 들어가는 값이 아닌 것은?<br>(1)초기값<br>(2)배열<br>(3)증감식<br>(4)반복될 내용</html>",
            "<html>문제3. 다음 중 java에서 외부의 클래스를 가져와서 쓸 때 사용하는 예약어는?<br>(1)import<br>(2)package<br>(3)void<br>(4)Scanner</html>"};
    int[] answer = {49, 50, 49};//정답을 키코드로
    //밑에서 따로 배열 값을 주면서 선언할 수 없다!!!

    public RelayQuiz() {
        this.setDefaultCloseOperation(3);
        this.setSize(300, 200);

        blb = new JLabel(str[0]);//처음엔 1번 문제부터 띄우기

        JPanel pnl = new JPanel();
        slb = new JLabel("");
        btn = new JButton("다음 문제");
        btn.setEnabled(false);//처음부터는 문제 못 넘기게 하기
        btn.addActionListener(this);
        pnl.add(slb);
        pnl.add(btn);

        this.addKeyListener(this);
        this.requestFocus();
        this.setFocusable(true);

        this.add(blb);
        this.add(pnl, "South");
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {//문제 넘기기
        slb.setText("");
        ++x;//x를 1로
        blb.setText(str[x]);

        if (x==(str.length-1)) {//마지막 문제에서 끝내기
            btn.setText("문제 끝");
            btn.setEnabled(false);
        }

        this.addKeyListener(this);
        this.requestFocus();
        this.setFocusable(true);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        for (int i = 0; i < str.length; i++) {
            if (blb.getText().equals(str[i])) {//i번 문제일 때
                if (e.getKeyCode()==answer[i]) {//i번 답일 때
                    slb.setText("정답!");
                    slb.setForeground(Color.RED);
                    if (i==(str.length-1)) {//마지막 문제에서 끝내기
                        btn.setEnabled(false);
                    } else {
                        btn.setEnabled(true);
                    }
                } else {
                    slb.setText("땡!");
                    slb.setForeground(Color.BLUE);
                    btn.setEnabled(false);
                }
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}

    public static void main(String[] args) {
        new RelayQuiz();
    }
}