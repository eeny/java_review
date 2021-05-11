import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TrafficLightBtn2 extends JFrame implements KeyListener {
    JPanel spnl1, spnl2, spnl3;
    JButton btn;

    public TrafficLightBtn2() {
        this.setDefaultCloseOperation(3);
        this.setSize(300, 500);
        this.setLayout(new GridLayout(0, 1));

        this.addKeyListener(this);//밑의 두 메서드가 없으면 이벤트 실행이 안됨!!!
        this.requestFocus();
        this.setFocusable(true);

        spnl1 = new JPanel();
        spnl2 = new JPanel();
        spnl3 = new JPanel();

        this.add(spnl1);
        this.add(spnl2);
        this.add(spnl3);
        this.setVisible(true);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        spnl1.setBackground(null);
        spnl2.setBackground(null);
        spnl3.setBackground(null);

        if (e.getKeyCode()==49) {
            spnl1.setBackground(Color.RED);
        } else if (e.getKeyCode()==50) {
            spnl2.setBackground(Color.YELLOW);
        } else if (e.getKeyCode()==51) {
            spnl3.setBackground(Color.GREEN);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}

    public static void main(String[] args) {
        new TrafficLightBtn2();
    }

}