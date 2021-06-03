import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class WhacAMoleBtn extends JButton implements ActionListener, Runnable {
    WhacAMole wam;// 부모창의 전역 변수에 접근하기 위해서
    int idx;

    public WhacAMoleBtn(WhacAMole wam) {
        this.setBackground(Color.RED);
        this.addActionListener(this);
        // 나 자신이 JButton이니까 자신에게 액션 이벤트 달았다!
        this.wam = wam;

        idx = (int) (Math.random() * 9);// 0 ~ 8 pnlMole[] 배열의 랜덤 위치
        wam.pnlMole[idx].add(this);// WhacAMole의 GridLayout안에 있는 패널 9개
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        wam.score += 1;
        wam.lblScore.setText("점수 : " + wam.score);
        this.setVisible(false);// 아예 remove()되는 것이 아니라 안보이게끔
        // 만들어진 버튼을 누르면 사라진다.
        // 따라서 두 번 누를 수 없다!
    }

    @Override
    public void run() {// while이 없으므로 한번만 실행되고 끝나는 스레드
        int waiting = ((int) (Math.random() * 1700)) + 300;
        // 최대 2초에서 0.3초까지

        try {
            Thread.sleep(waiting);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        wam.pnlMole[idx].remove(this);
        // 메인의 pnlMole 안에 있는 버튼을 삭제한다.
        wam.pnlMole[idx].repaint();// 화면 갱신
        wam.pnlMole[idx].revalidate();// 화면 갱신
    }
}