import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MakeButton extends JFrame implements MouseListener {
    public MakeButton() {
        this.setDefaultCloseOperation(3);
        this.setSize(500, 500);
        this.setLayout(null);//절대좌표
        this.addMouseListener(this);//마우스이벤트 생성
        this.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        JButton btn = new JButton("버튼");
        //위에 프레임 제목 부분이 잘리기 때문에 그 부분 만큼 좌표에서 제외해야 커서 위치에 바로 생성된다!
        int x = e.getX() - 8;
        int y = e.getY() - 31;
        btn.setBounds(x, y, 80, 80);

        if (e.getButton()==1) {
            btn.setText("좌클");
            btn.setBackground(Color.RED);
        } else if (e.getButton()==2) {
            btn.setText("휠클");
            btn.setBackground(Color.YELLOW);
        } else if (e.getButton()==3) {
            btn.setText("우클");
            btn.setBackground(Color.GREEN);
        }

        this.add(btn);

        //버튼 생성시 발생하는 텀을 없애기 위한 새로 고침 메서드
        revalidate();
        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    public static void main(String[] args) {
        new MakeButton();
    }
}