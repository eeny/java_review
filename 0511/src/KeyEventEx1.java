import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class KeyEventEx1 extends JFrame implements KeyListener {
    JTextField tf;
    JTextArea ta;
    JScrollPane sp;

    public KeyEventEx1() {
        this.setDefaultCloseOperation(3);
        this.setSize(300, 400);

        tf = new JTextField();//크기 설정 안해도 BorderLayout에서는 최대 크기가 됨
        tf.addKeyListener(this);

        ta = new JTextArea();
        sp = new JScrollPane(ta);//스크롤바 붙이기

        this.add(tf, "North");
        this.add(sp);
        this.setVisible(true);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        ta.append(e.getKeyChar() + " " + e.isAltDown() + " keyPressed\n");//앞에 적힌 글씨에 덧붙여서 적히는 기능
        //append()는 문자열만 받는다!
        //e.getKeyChar() 결과는 char타입이라서 String으로 형변환해줘야 한다!
    }

    @Override
    public void keyReleased(KeyEvent e) {
        ta.append(e.getKeyChar() + " keyReleased\n");
    }

    @Override
    public void keyTyped(KeyEvent e) {
        ta.append(e.getKeyChar() + " keyTyped\n");
    }

    public static void main(String[] args) {
        new KeyEventEx1();
    }
}