import javax.swing.JButton;

public class ThreadButton3 extends JButton implements Runnable {
    public ThreadButton3(int x, int y) {
        this.setBounds(x, y, 10, 20);
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 버튼이 위로 날아간다!
            // 계속 무한대로 버튼이 생성되면 컴퓨터 메모리를 불필요하게 차지하게 된다!
            // 따라서 조건을 걸어서 화면 밖으로 버튼이 없어지면 while문을 빠져나가도록 하자!
            if (this.getY() < -30) {
                break;

            } else {
                this.setLocation(this.getX(), this.getY()-1);
                // 여기서 -1은 프레임 속도를 조절할 수 있는 값!
                // 숫자가 클수록 부자연스럽다.
            }
        }
    }
}