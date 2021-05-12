import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MouseEventTest extends JFrame implements MouseListener, MouseMotionListener {
    public MouseEventTest() {//p411 예제
        setTitle("Mouse Event");
        setSize(300, 200);
        setDefaultCloseOperation(3);

        JPanel panel = new JPanel();
        panel.addMouseListener(this);
        panel.addMouseMotionListener(this);

        add(panel);
        setVisible(true);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        display("Mouse dragged", e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        display("Mouse moved", e);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        display("Mouse clicked (# of clicks: " + e.getClickCount() + ")", e);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        display("Mouse entered", e);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        display("Mouse exited", e);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        display("Mouse pressed (# of clicks: " + e.getClickCount() + ")", e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        display("Mouse released (# of clicks: " + e.getClickCount() + ")", e);
    }

    protected void display(String s, MouseEvent e) {
        System.out.println(s + " X=" + e.getX() + " Y=" + e.getY());
    }

    public static void main(String[] args) {
        new MouseEventTest();
    }
}
