import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MouseEventEx2 extends JFrame implements MouseListener {//샘 풀이
    public MouseEventEx2() {
        this.setDefaultCloseOperation(3);
        this.setSize(500, 500);
        this.setLayout(null);
        this.addMouseListener(this);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new MouseEventEx2();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println(e.getX() + ", " + e.getY());//좌표 확인

        int width = 60, height = 60;
        Color c = null;

        if (e.getButton()==2) {//마우스 휠
            c = Color.RED;
        } else if (e.getButton()==3) {//마우스 오른쪽 버튼
            c = Color.GREEN;
        } else {//마우스 왼쪽 버튼
            c = null;
        }

        JButton btn = new JButton("버튼");
        btn.setBounds(e.getX()-8, e.getY()-31, width, height);
        btn.setBackground(c);
        this.add(btn);

        //JFrame이 모니터에 출력된 이후에 이벤트로 발생하는 UI변경이 있다면
        //화면 갱신이 필수!
        this.repaint();//화면 갱신
        this.revalidate();//변수 정보와 실제 화면의 위치를 보정해줌
        //그래서 화면 갱신시 보통 2개의 메서드를 같이 써준다!
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