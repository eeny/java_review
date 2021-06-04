import javax.swing.JButton;

public class MoveBox7Bullet extends JButton implements Runnable {
    public MoveBox7Bullet(int hero_x, int hero_y) {
        this.setBounds(hero_x+20, hero_y, 10, 20);
    }

    @Override
    public void run() {
        // 무한 루프
        while (true) {
            // sleep()을 해주지 않으면 버튼이 아예 보이지도 않을 정도로 실행된다
            try {
                Thread.sleep(1);// 0.001초 마다 움직이도록 설정
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (this.getY() < -30) {// 메인 프레임 밖으로 나가서 안보이게 되는 경우
                break;// 반복문 탈출
            } else {// 메인 프레임 안에 있는 경우
                this.setLocation(this.getX(), this.getY()-1);
                // 버튼(this 나 자신)이 위로 올라간다
            }
        }// break로 while을 빠져 나오면 이 스레드는 자동으로 중지된다!
    }
}