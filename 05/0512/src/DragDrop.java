import java.awt.event.*;

import javax.swing.*;

public class DragDrop extends JFrame implements MouseMotionListener, MouseListener {
    JButton btn;
    int sx, sy;//첫 시작점

    public DragDrop() {
        this.setDefaultCloseOperation(3);
        this.setSize(500, 500);
        this.setLayout(null);
        btn = new JButton("버튼");
        btn.setBounds(20, 20, 70, 70);
        btn.addMouseMotionListener(this);
        this.add(btn);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new DragDrop();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        btn.setLocation(e.getXOnScreen()-this.getX()-8-sx, e.getYOnScreen()-this.getY()-31-sy);
        //전체 모니터 좌표에서 현재 실행창 크기만큼 빼고 실행창 위에 창제목 부분만큼 또 빼준다
        //그리고 클릭한 좌표부터 움직일 수 있게 또 뺀다
    }

    @Override
    public void mouseMoved(MouseEvent e) {}

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {//마우스가 클릭한 좌표부터 드래그 할 수 있게 시작점
        sx = e.getX();
        sy = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {}
}