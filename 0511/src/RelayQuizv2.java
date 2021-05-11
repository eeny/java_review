import java.awt.Color;
import java.awt.event.*;

import javax.swing.*;

public class RelayQuizv2 extends JFrame implements KeyListener {
    JLabel direction, blb;
    int x;//문제 넘길 때 쓰는 변수. 초기값 0
    int msg;//정답 알림창
    int score;//점수. 초기값 0
    String[] str = {"<html>문제1. 다음 중 정수형인 것은?<br>(1)int<br>(2)String<br>(3)float<br>(4)boolean</html>",
            "<html>문제2. 다음 중 for문에 들어가는 값이 아닌 것은?<br>(1)초기값<br>(2)배열<br>(3)증감식<br>(4)반복될 내용</html>",
            "<html>문제3. 다음 중 java에서 외부의 클래스를 가져와서 쓸 때 사용하는 예약어는?<br>(1)import<br>(2)package<br>(3)void<br>(4)Scanner</html>"};
    int[] answer = {49, 50, 49};

    public RelayQuizv2() {
        this.setDefaultCloseOperation(3);
        this.setSize(300, 200);
        this.setTitle("RelayQuiz");

        direction = new JLabel("숫자키로 정답을 입력하세요.");
        blb = new JLabel(str[x]);//처음엔 1번 문제부터 띄우기

        this.addKeyListener(this);
        this.requestFocus();
        this.setFocusable(true);

        this.add(direction, "North");
        this.add(blb);
        this.setVisible(true);
    }

    void nextQuestion() {//다음 문제 넘기는 메서드
        ++x;//x를 1로
        blb.setText(str[x]);
    }

    void lastQuestion() {//마지막 문제 후 점수 확인 메서드
        direction.setText("");
        blb.setText("수고하셨습니다! 점수는 " + score + "점입니다.");
        msg = JOptionPane.showConfirmDialog(this, "종료하시겠습니까?");
        if (msg==JOptionPane.YES_OPTION) {//예 누르면 강제 종료
            System.exit(0);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        String[] next = {"다음문제"};

        for (int i = 0; i < (str.length+1); i++) {

            if (blb.getText().equals(str[i])) {//i번 문제일 때
                if (e.getKeyCode()==answer[i]) {//i번 답일 때
                    score++;//점수 1점 추가

                    msg = JOptionPane.showOptionDialog(this, "정답입니다!", "Notice", JOptionPane.YES_OPTION, JOptionPane.INFORMATION_MESSAGE, null, next, next[0] );

                    if (msg==JOptionPane.YES_OPTION) {//다음문제를 눌렀을 때
                        if (i==(str.length-1)) {//마지막 문제일 때
                            lastQuestion();
                        } else {
                            nextQuestion();
                        }
                        break;
                    }

                } else {//답이 틀리다면
                    msg = JOptionPane.showOptionDialog(this, "틀렸습니다!", "Notice", JOptionPane.YES_OPTION, JOptionPane.INFORMATION_MESSAGE, null, next, next[0] );

                    if (msg==JOptionPane.YES_OPTION) {//다음문제를 눌렀을 때
                        if (i==(str.length-1)) {//마지막 문제일 때
                            lastQuestion();
                        } else {
                            nextQuestion();
                        }
                        break;
                    }
                }
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}

    public static void main(String[] args) {
        new RelayQuizv2();
    }
}