import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MoveBox5 extends JFrame implements KeyListener {
    /*	JButton btn;// 키이벤트와 런 메서드에서 공통으로 사용될 버튼*/
    public MoveBox5() {
        this.setDefaultCloseOperation(3);
        this.setSize(500, 500);
        this.setLayout(null);

        // JFrame에 키보드 이벤트 설정하기
        this.addKeyListener(this);
        this.setFocusable(true);
        this.requestFocus();

        this.setVisible(true);
    }

    public static void main(String[] args) {
        new MoveBox5();
    }
	
	/*@Override
	public void run() {
	// run() 메서드 자체는 반복이 되는 것이 아니다! 반복문을 넣어야 반복이 된다!
		while (true) {
			// 버튼이 위로 날아간다
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			btn.setLocation(btn.getX(), btn.getY()-1);
			
			// 이렇게 만들면 버튼이 날아가는 중에 키이벤트가 발생하면
			// 날아가던 버튼이 멈추고 새버튼이 날아가버린다.
			// 따라서 다시 만들어야함! => 새로운 버튼 클래스로 만들자!
		}
	}*/

    @Override
    public void keyPressed(KeyEvent e) {
        // 키보드를 누르면
        // 미사일(Jbutton)이 만들어진다! - 위치, 크기를 가지고 있다.
        // 스레드로 만들어서 위로 발사까지 되도록 만들기.
		/*
		btn = new JButton();
		
		btn.setSize(10, 20);
		btn.setLocation(250, 430);
		// 두 메서드를 합치면 setBounds()
		
		this.add(btn);
		
		this.repaint();
		this.revalidate();
		// 보통 이미 존재하는 컴포넌트의 값이 변할 때는 필요없다! - 시간 변경등
		// 화면에 새로운 컴포넌트(버튼, 레이블, 패널 등)가 추가되거나 삭제될 때 필요하다!
		
		(new Thread(this)).start();
		// run() 메서드를 들고 있는 클래스는? MoveBox5(this)
		// 이 스레드는 현재 버튼과 아무런 관계가 없다!
		*/

        // SpaceBar를 누를 때만 작동하게!
        if (e.getKeyCode()==32) {
            ThreadButton2 btn = new ThreadButton2();
            // 키보드 이벤트가 발생할 때마다 새로운 버튼 클래스가 생성되므로
            // 버튼 클래스를 생성하는 코드는 한번만 작성해놓으면 된다!
            this.add(btn);
            //this.repaint();
            //this.revalidate();
            (new Thread(btn)).start();
            // 스레드를 run()해서 움직이게 되면 자동 갱신되는 것과 똑같다!
            // 그래서 repaint()와 revalidate()를 실행할 필요가 없다!
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}
}