import java.awt.Color;

import javax.swing.JButton;

public class MoveBox7Box extends JButton implements Runnable {
    Color color[] = {Color.RED, Color.GREEN, Color.BLUE, Color.CYAN, Color.YELLOW};
    boolean isRight;// 기본값 false (프레임 끝에 닿았는지 판단하는 변수)

    int speed;// 외부(MoveBox7)에서 받아오지 않고 내부에서 처리할 것이다!

    public MoveBox7Box(int x, int y) {
        // this.setBounds(10, 10, 70, 50);
        // 위치가 고정이니까 외부에서 위치를 받아올 수 있도록
        this.setBounds(x, y, 70, 50);

        // 색깔 설정하기
        int num = (int)(Math.random()*5);// 0~5 color[]가 총 5개니까
        this.setBackground(color[num]);// 랜덤으로 색깔을 설정한다!

        // 1~30까지의 숫자가 나온다! 따라서 제일 느린 속도가 0.03초
        speed = ((int)(Math.random()*29)) + 1;
    }

    @Override
    public void run() {
        // 무한 루프
        while (true) {
            try {
                Thread.sleep(speed);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (this.getX() > 420) {
                isRight = true;
            } else if (this.getX() < 0) {
                isRight = false;
            }

            if (isRight) {
                this.setLocation(this.getX() - 1, this.getY());
            } else {
                this.setLocation(this.getX() + 1, this.getY());
            }
        }
    }
}