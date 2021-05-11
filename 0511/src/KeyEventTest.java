import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

class MyFrame extends JFrame implements KeyListener {//p405 예제
    public MyFrame() {
        setTitle("이벤트 예제");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField tf = new JTextField(20);
        tf.addKeyListener(this);

        add(tf);
        setVisible(true);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        display(e, "KeyTyped ");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        display(e, "KeyPressed ");
    }

    @Override
    public void keyTyped(KeyEvent e) {
        display(e, "KeyReleased ");
    }

    protected void display(KeyEvent e, String s) {
        char c = e.getKeyChar();
        int keyCode = e.getKeyCode();
        String modifiers = e.isAltDown() + " " + e.isControlDown() + " " + e.isShiftDown();
        System.out.println(s + " " + c + " " + keyCode + " " + modifiers);
    }
}

public class KeyEventTest {
    public static void main(String[] args) {
        new MyFrame();
    }
}