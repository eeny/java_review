import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

public class MouseEventEx1 extends JFrame implements MouseListener, MouseMotionListener {
    public MouseEventEx1() {
        this.setDefaultCloseOperation(3);
        this.setSize(500, 500);

        //마우스 이벤트는 포커스가 필요 없다!
        this.addMouseListener(this);
        this.addMouseMotionListener(this);

        this.setVisible(true);
    }

    public static void main(String[] args) {
        new MouseEventEx1();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("프로그램을 기준으로 " + e.getX() + " " + e.getY());
        System.out.println("모니터를 기준으로 " + e.getXOnScreen() + " " + e.getYOnScreen());
        System.out.println("현재 누른 마우스의 버튼 " + e.getButton());
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

}
