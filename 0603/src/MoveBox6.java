import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MoveBox6 extends JFrame implements KeyListener {
    JButton btnHero;
    int x, y;
    private final Set<Integer> pressedKeys = new HashSet<>();
    // 키 동시 입력할 수 있는 클래스

    public MoveBox6() {
        this.setDefaultCloseOperation(3);
        this.setSize(500, 500);
        this.setLayout(null);

        // JFrame에 키보드 이벤트 설정하기
        this.addKeyListener(this);
        this.setFocusable(true);
        this.requestFocus();

        btnHero = new JButton("짱");
        btnHero.setBounds(220, 410, 50, 50);

        this.add(btnHero);

        x = btnHero.getX();
        y = btnHero.getY();

        this.setVisible(true);
    }

    public static void main(String[] args) {
        new MoveBox6();
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
                        y -= 10;
                        break;
                    case KeyEvent.VK_A:
                    case KeyEvent.VK_LEFT:
                        x -= 10;
                        break;
                    case KeyEvent.VK_S:
                    case KeyEvent.VK_DOWN:
                        y += 10;
                        break;
                    case KeyEvent.VK_D:
                    case KeyEvent.VK_RIGHT:
                        x += 10;
                        break;
                    case KeyEvent.VK_SPACE:
                        ThreadButton3 btn = new ThreadButton3(x + 25, y);
                        this.add(btn);
                        (new Thread(btn)).start();
                        break;
                }
            }
        }
        btnHero.setLocation(x, y);
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
     *
     * @Override public void keyReleased(KeyEvent e) {}
     *
     * @Override public void keyTyped(KeyEvent e) {}
     */
}