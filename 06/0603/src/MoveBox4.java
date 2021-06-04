import java.awt.Color;

import javax.swing.JFrame;

public class MoveBox4 extends JFrame {
    // 버튼 위치와 크기 초기화
    int x = 10;
    int y = 10;
    int width = 70;
    int height = 50;
    Color[] color = {Color.RED, Color.pink, Color.BLUE, Color.YELLOW, Color.GREEN};

    public MoveBox4() {
        this.setDefaultCloseOperation(3);
        this.setSize(500, 500);
        this.setLayout(null);
        // ====================여기부터=========================
        // 내가 만든 JButton을 상속받고 Runnable을 구현한 버튼을 만들어서
        // this에 add() 하고
        // 이후 start() 메서드로 run()을 호출할 예정!

        // 내가 만든 버튼은 JButton을 상속받았으므로 사용법은 일반 JButton과 같다!
        ThreadButton1 btn1 = new ThreadButton1(x, y, width, height, color[0], 30);
        // btn1.setBounds(x, y, width, height);
        // 이런 버튼 설정하는 코드들은 ThreadButton1에서 작성한다!
        ThreadButton1 btn2 = new ThreadButton1(x, y, width, height, color[1], 10);
        ThreadButton1 btn3 = new ThreadButton1(x, y, width, height, color[2], 1);
        ThreadButton1 btn4 = new ThreadButton1(x, y, width, height, color[3], 5);
        ThreadButton1 btn5 = new ThreadButton1(x, y, width, height, color[4], 15);

        addBtn(btn1);
        addBtn(btn2);
        addBtn(btn3);
        addBtn(btn4);
        addBtn(btn5);
        // Thread의 생성자 매개 변수로 Runnable을 구현한 객체를 넣으면 된다!
        // ====================여기까지=========================

        ThreadLabel lbl = new ThreadLabel();
        this.add(lbl);
        new Thread(lbl).start();

        this.setVisible(true);
    }

    // 중복된 코드를 메서드화
    void addBtn(ThreadButton1 btn) {
        this.add(btn);
        new Thread(btn).start();
    }

    public static void main(String[] args) {
        new MoveBox4();
    }
}