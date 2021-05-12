import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class KeyEventEx2 extends JFrame implements KeyListener {
    JTextField tf;
    JPanel pnl;
    JButton btn;
    int x, y; //초기값 0, 0

    public KeyEventEx2() {
        this.setDefaultCloseOperation(3);
        this.setSize(500, 500);

        //tf = new JTextField();
        //tf.addKeyListener(this);
        //this.add(tf, "North");

        pnl = new JPanel();
        pnl.setLayout(null);
        btn = new JButton();
        btn.setBounds(x, y, 50, 50);
        pnl.add(btn);
        this.add(pnl);

        this.addKeyListener(this);//프레임에 키 이벤트를 준다!
        this.requestFocus();//프레임을 클릭해준다.
        this.setFocusable(true);//원래 프레임은 마우스로 클릭이 안되지만 메서드로 강제 선택

        this.setVisible(true);

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode()==37) {//←
            x = x -10;//x += 10
        } else if (e.getKeyCode()==39) {//→
            x = x + 10;
        } else if (e.getKeyCode()==38) {//↑
            y = y - 10;
        } else if (e.getKeyCode()==40) {//↓
            y = y + 10;
        }

        btn.setLocation(x, y);
    }

    @Override
    public void keyTyped(KeyEvent e) {		}

    @Override
    public void keyReleased(KeyEvent e) {		}

    public static void main(String[] args) {
        new KeyEventEx2();
    }
}
