import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ChangeColor2 extends JFrame implements KeyListener {
    JLabel[] lbs;

    public ChangeColor2() {
        this.setDefaultCloseOperation(3);
        this.setSize(200, 450);
        this.setLayout(new FlowLayout());

        lbs = new JLabel[3];

        for (int i = 0; i < lbs.length; i++) {
            lbs[i] = new JLabel();
            lbs[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            lbs[i].setPreferredSize(new Dimension(200, 130));
            lbs[i].setOpaque(true);//색깔 바꾸기 위해서 설정
            this.add(lbs[i]);
        }

        this.addKeyListener(this);//프레임에 키 이벤트를 주고
        this.requestFocus();//프레임에 포커스를 주고
        this.setFocusable(true);//프레임에 마우스 클릭할 수 있게

        this.setVisible(true);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode()==49 || e.getKeyCode()==97) {//1 눌렀을 때
            lbs[0].setBackground(Color.RED);
            lbs[1].setBackground(null);
            lbs[2].setBackground(null);
        } else if (e.getKeyCode()==50 || e.getKeyCode()==98) {//2 눌렀을 때
            lbs[1].setBackground(Color.RED);
            lbs[0].setBackground(null);
            lbs[2].setBackground(null);
        } else if (e.getKeyCode()==51 || e.getKeyCode()==99) {//3 눌렀을 때
            lbs[2].setBackground(Color.RED);
            lbs[1].setBackground(null);
            lbs[0].setBackground(null);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}

    public static void main(String[] args) {
        new ChangeColor2();
    }
}