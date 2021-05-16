import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

public class WindowEventEx extends JFrame implements WindowListener {
    public WindowEventEx() {
        this.setDefaultCloseOperation(3);//기본적으로 JFrame이 들고 있는 메소드.
        this.setSize(500, 500);
        this.addWindowListener(this);
        this.setVisible(true);
    }

    @Override
    public void windowActivated(WindowEvent e) {
        System.out.println(1);
    }

    @Override
    public void windowClosed(WindowEvent e) {
        System.out.println(2);
    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println(3);
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        System.out.println(4);
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        System.out.println(5);
    }

    @Override
    public void windowIconified(WindowEvent e) {
        System.out.println(6);
    }

    @Override
    public void windowOpened(WindowEvent e) {
        System.out.println(7);
    }

    public static void main(String[] args) {
        new WindowEventEx();
    }
}