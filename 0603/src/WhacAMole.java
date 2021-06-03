import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class WhacAMole extends JFrame implements ActionListener, MouseListener, Runnable {
    JPanel pnlNorth, pnlCenter;// 화면에 출력되는 메인 패널 2개
    JPanel pnlMole[];// GridLayout에 들어가는 9개의 패널
    JLabel lblScore;// 점수 표시용 라벨
    JButton btn;// 시작 버튼
    WhacAMoleTime lblTime;// 시간 라벨
    int score = 0;// 실제 점수
    boolean isStart = false;// 시작 되면 tur로 바뀌로 이 때부터 잘못 누르면 점수가 깎인다!

    public WhacAMole() {
        this.setSize(500, 500);
        this.setDefaultCloseOperation(3);

        pnlNorth = new JPanel();
        btn = new JButton("시작");
        btn.addActionListener(this);
        lblScore = new JLabel("점수 : " + score);
        lblTime = new WhacAMoleTime(lblScore);
        // lblTime에서 실행될
        // JOptionPane.showMessageDialog()에서 사용하려고
        // 매개변수로 lblScore를 넘겼다.
        lblScore.setFont(new Font("굴림", Font.BOLD, 20));
        pnlNorth.add(lblTime);
        pnlNorth.add(btn);
        pnlNorth.add(lblScore);

        pnlCenter = new JPanel(new GridLayout(0, 3, 50, 50));// 50은 Grid의 간격
        pnlMole = new JPanel[9];// 총 9개 칸에 패널을 만들어 붙임
        for (int i = 0; i < pnlMole.length; i++) {
            pnlMole[i] = new JPanel(new BorderLayout());
            pnlMole[i].setBorder(BorderFactory.createLineBorder(Color.BLUE));
            // 패널의 외곽선
            pnlMole[i].addMouseListener(this);// 패널을 누르면 점수가 깎이도록 마우스 이벤트 추가
            pnlCenter.add(pnlMole[i]);
        }

        this.add(pnlNorth, "North");
        this.add(pnlCenter);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new WhacAMole();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn) {// 시작 버튼을 누르면
            (new Thread(lblTime)).start();// 시간 스레드 시작
            (new Thread(this)).start();// 현재 이 프레임이 가진 스레드 시작
            isStart = true;// 시작 변수를 true로 바꾼다.
        }
    }

    // 현재 스레드의 run()
    @Override
    public void run() {
        while (true) {
            if (lblTime.getText().equals("시간 : 1초")) {
                break;// 스레드 완전 종료

            } else {
                try {
                    Thread.sleep(2000);// 2초마다
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                int ran = ((int) (Math.random() * 3)) + 1;
                // 1개 또는 2개 또는 3개만 나오게 된다!

                for (int i = 0; i < ran; i++) {
                    WhacAMoleBtn wamb = new WhacAMoleBtn(this);
                    (new Thread(wamb)).start();
                }
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // 잘못 클릭했을 때 점수 깎기
        if (isStart == true && score != 0) {
            score = score - 1;
            lblScore.setText("점수 : " + score);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }
}
