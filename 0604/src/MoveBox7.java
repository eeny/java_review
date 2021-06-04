import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MoveBox7 extends JFrame implements KeyListener, Runnable {
    // 전역변수들
    private final Set<Integer> pressedKeys = new HashSet<>();// 키 동시 입력할 수 있는 클래스 (밑에 오버라이딩도 해야 한다!)
    JButton btnHero;// 주인공 버튼
    int hero_x, hero_y;
    MoveBox7Bullet bullet;// JButton bullet; 과 같은 말!
    MoveBox7Box[] box;// box생성을 for문으로 처리하기 위해서 전역으로 뺐다!

    static int bullet_cnt;// 기본값 0

    public MoveBox7() {
        // 기본 UI
        this.setDefaultCloseOperation(3);
        this.setSize(500, 500);
        this.setLayout(null);
        // JFrame에 키 이벤트 설정 (키보드 이벤트는 포커스를 강제로 줘야한다!)
        this.addKeyListener(this);
        this.setFocusable(true);
        this.requestFocus();

        // 주인공 생성
        btnHero = new JButton("I");
        // Layout(null)이라서 반드시 크기와 위치를 설정해야 한다!
        btnHero.setBounds(220, 410, 50, 50);
        this.add(btnHero);
        hero_x = btnHero.getX();// 현재 btnHero의 x좌표 위치
        hero_y = btnHero.getY();// 현재 btnHero의 y좌표 위치

        // 시간 생성 (다 만들어진 것을 한번만 붙일 거라서 굳이 전역 변수할 필요 없다.)
        MoveBox7Lbl time = new MoveBox7Lbl();
        this.add(time);
        new Thread(time).start();// 시간 레이블에 있는 스레드 실행!

        // 적(컬러 박스) 생성
        // 박스를 생성할 때 위치를 따로 따로 설정할 수 있게 위치 값을 던진다!
        // for()문으로 여러 개의 박스 한번에 생성하기
        int cnt = 10;// 총 생성될 박스 개수
        box = new MoveBox7Box[cnt];
        for (int i = 0; i < 10; i++) {
            // 어차피 속도가 달라서 위치 고정이라도 괜찮다!
            box[i] = new MoveBox7Box(10, 10);
            setBox(box[i]);
        }

        this.setVisible(true);
    }

    // 몇 번째 발사된 총알이 어디 y좌표에 있는지 출력
    void crash(MoveBox7Bullet bullet) {
        // System.out.println(bullet_cnt + ":" + bullet.getY());
        // 적(box)의 위치와 총알(bullet)의 위치를 비교해서 같으면 둘 다 삭제
        // => 총알로 맞추기 알고리즘
    }

    // 메인의 스레드 작업
    @Override
    public void run() {
        // 총알의 위치가 화면 프레임 안에 있는 동안만 crash() 메서드를 실행시켜라!
        for (int i = bullet.getY(); i > -30; i--) {
            crash(bullet);
        }
    }

    // 적(컬러 박스) 생성 후 메인에 붙이고 스레드 실행시키는 메서드
    void setBox(MoveBox7Box b) {
        this.add(b);
        // 적(컬러 박스)에 있는 스레드 실행!
        new Thread(b).start();
    }

    // 키보드 동시 입력이 되는 키 이벤트 메소드들을 오버라이딩!
    // 키 이벤트로 주인공 버튼이 자유롭게 움직인다.
    @Override
    public synchronized void keyPressed(KeyEvent e) {
        pressedKeys.add(e.getKeyCode());
        // 내가 누른 키들을 모았다가 동시에 처리한다!

        if (!pressedKeys.isEmpty()) {
            for (Iterator<Integer> it = pressedKeys.iterator(); it.hasNext();) {
                switch (it.next()) {
                    case KeyEvent.VK_W:
                    case KeyEvent.VK_UP:
                        hero_y -= 10;
                        break;
                    case KeyEvent.VK_A:
                    case KeyEvent.VK_LEFT:
                        hero_x -= 10;
                        break;
                    case KeyEvent.VK_S:
                    case KeyEvent.VK_DOWN:
                        hero_y += 10;
                        break;
                    case KeyEvent.VK_D:
                    case KeyEvent.VK_RIGHT:
                        hero_x += 10;
                        break;
                    case KeyEvent.VK_SPACE:
                        bullet = new MoveBox7Bullet(hero_x, hero_y);// 버튼 생성
                        // Layout(null)이라서 위치, 크기를 반드시 설정해야 한다!
                        // 여기(메인)서 설정할 수도 있지만 해당 버튼 클래스에서 설정할 수도 있다!
                        // 그러기 위해서는 현재 메인 클래스에서 매개 변수(주인공 위치)를 던져주면 된다!

                        bullet_cnt++;// 내가 스페이스바를 누를 때마다 생성되는 총알의 개수

                        this.add(bullet);// 메인 프레임에 붙이기

                        new Thread(bullet).start();// bullet에 있는 스레드 실행!

                        new Thread(this).start();// 메인(나자신 this)에 있는 스레드 실행!
					
					/*repaint();// 화면 갱신인데 자동으로 움직일 경우 자동 갱신이라서 필요없다!
					revalidate();// 화면 갱신인데 자동으로 움직일 경우 자동 갱신이라서 필요없다!*/

                        break;
                }
            }
        }
        btnHero.setLocation(hero_x, hero_y);
    }

    @Override
    public synchronized void keyReleased(KeyEvent e) {
        pressedKeys.remove(e.getKeyCode());
    }

    @Override
    public void keyTyped(KeyEvent e) {
        /* Not used */ }


    public static void main(String[] args) {
        new MoveBox7();
    }
}