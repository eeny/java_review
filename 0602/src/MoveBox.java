import javax.swing.JButton;
import javax.swing.JFrame;

public class MoveBox extends JFrame implements Runnable {
    JButton btn1, btn2, btn3;
    int max = 20;// 버튼의 x좌표에서 늘어날 최대 숫자 일괄 변경할 수 있게 변수로 뺐다!

    public MoveBox() {
        this.setDefaultCloseOperation(3);
        this.setSize(800, 400);
        this.setLayout(null);

        btn1 = new JButton("버튼1");
        btn2 = new JButton("버튼2");
        btn3 = new JButton("버튼3");
        // 레이아웃이 null 이기 때문에 반드시 크기와 위치를 줘야한다.

        btn1.setBounds(10, 10, 70, 70);
        btn2.setBounds(10, 100, 70, 70);
        btn3.setBounds(10, 190, 70, 70);

        this.add(btn1);
        this.add(btn2);
        this.add(btn3);

        (new Thread(this)).start();// run()을 실행시킨다!

        this.setVisible(true);
    }

    // 버튼을 움직이는 메서드
    // 따로 나눠서 만들어도 되고 메서드 한 개로 만들어도 된다!
    void move1() {
        int ran1 = (int)(Math.random() * max);
        btn1.setLocation((btn1.getX() + ran1), 10);
    }

    void move2() {
        int ran2 = (int)(Math.random() * max);
        btn2.setLocation((btn2.getX() + ran2), 100);
    }

    void move3() {
        int ran3 = (int)(Math.random() * max);
        btn3.setLocation((btn3.getX() + ran3), 190);
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            move1();
            move2();
            move3();

            try {
                Thread.sleep(100);// 1000이 1초
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new MoveBox();
    }
}