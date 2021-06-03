import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;

public class TestMoveBox46 extends JFrame implements KeyListener {
    JButton btnHero;

    int x = 10;
    int y = 10;
    int width = 70;
    int height = 50;
    Color[] color = { Color.RED, Color.pink, Color.BLUE, Color.YELLOW, Color.GREEN };

    int kx, ky;
    private final Set<Integer> pressedKeys = new HashSet<>();

    public TestMoveBox46() {
        this.setDefaultCloseOperation(3);
        this.setSize(500, 500);
        this.setLayout(null);

        // JFrame에 키보드 이벤트 설정하기
        this.addKeyListener(this);
        this.setFocusable(true);
        this.requestFocus();

        ThreadButton1 btn1 = new ThreadButton1(x, y, width, height, color[0], 30);
        ThreadButton1 btn2 = new ThreadButton1(x, y, width, height, color[1], 10);
        ThreadButton1 btn3 = new ThreadButton1(x, y, width, height, color[2], 1);
        ThreadButton1 btn4 = new ThreadButton1(x, y, width, height, color[3], 5);
        ThreadButton1 btn5 = new ThreadButton1(x, y, width, height, color[4], 15);

        addBtn(btn1);
        addBtn(btn2);
        addBtn(btn3);
        addBtn(btn4);
        addBtn(btn5);

        btnHero = new JButton("짱");
        btnHero.setBounds(220, 410, 50, 50);

        this.add(btnHero);

        kx = btnHero.getX();
        ky = btnHero.getY();

        this.setVisible(true);
    }

    void addBtn(ThreadButton1 btn) {
        this.add(btn);
        new Thread(btn).start();
    }

    public static void main(String[] args) {
        new TestMoveBox46();
    }

    @Override
    public synchronized void keyPressed(KeyEvent e) {
        pressedKeys.add(e.getKeyCode());
        // 내가 누른 키들을 모았다가 동시에 처리한다!

        if (!pressedKeys.isEmpty()) {
            for (Iterator<Integer> it = pressedKeys.iterator(); it.hasNext();) {
                switch (it.next()) {
                    case KeyEvent.VK_W:
                    case KeyEvent.VK_UP:
                        ky -= 10;
                        break;
                    case KeyEvent.VK_A:
                    case KeyEvent.VK_LEFT:
                        kx -= 10;
                        break;
                    case KeyEvent.VK_S:
                    case KeyEvent.VK_DOWN:
                        ky += 10;
                        break;
                    case KeyEvent.VK_D:
                    case KeyEvent.VK_RIGHT:
                        kx += 10;
                        break;
                    case KeyEvent.VK_SPACE:
                        ThreadButton3 btn = new ThreadButton3(kx + 25, ky);
                        this.add(btn);
                        (new Thread(btn)).start();
                        break;
                }
            }
        }
        btnHero.setLocation(kx, ky);
    }

    @Override
    public synchronized void keyReleased(KeyEvent e) {
        pressedKeys.remove(e.getKeyCode());
    }

    @Override
    public void keyTyped(KeyEvent e) {
        /* Not used */ }

    /*
     * @Override public void keyPressed(KeyEvent e) { // btnHero가 방향키에 따라 상하좌우로
     * 움직이게 만들기 if (e.getKeyCode()==37) {// 방향키(←)
     * btnHero.setLocation(btnHero.getX()-15, btnHero.getY());
     *
     * } else if (e.getKeyCode()==38) {// 방향키(↑)
     * btnHero.setLocation(btnHero.getX(), btnHero.getY()-15);
     *
     * } else if (e.getKeyCode()==39) {// 방향키(→)
     * btnHero.setLocation(btnHero.getX()+15, btnHero.getY());
     *
     * } else if (e.getKeyCode()==40) {// 방향키(↓)
     * btnHero.setLocation(btnHero.getX(), btnHero.getY()+15);
     *
     * } else if (e.getKeyCode()==32) {// SpaceBar ThreadButton3 btn = new
     * ThreadButton3(btnHero.getX()+21, btnHero.getY()); // btnHero의 가운데에서 미사일이
     * 발사되도록 x좌표 +21 조절했다 this.add(btn); (new Thread(btn)).start(); } }
     *
     * @Override public void keyReleased(KeyEvent e) {}
     *
     * @Override public void keyTyped(KeyEvent e) {}
     */
}