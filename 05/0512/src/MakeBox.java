import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MakeBox extends JFrame implements ActionListener, MouseListener {
    JButton btnR, btnG, btnB;
    JPanel pnlN, pnlC;
    Color c;//초기값 null
    int sx, sy;//상자를 만드려고 딱 클릭한 순간 좌표

    public MakeBox() {
        this.setDefaultCloseOperation(3);
        this.setSize(500, 500);
        pnlN = new JPanel();
        btnR = new JButton("빨강");
        btnR.setBackground(Color.RED);
        btnG = new JButton("녹색");
        btnG.setBackground(Color.GREEN);
        btnB = new JButton("파랑");
        btnB.setBackground(Color.BLUE);

        btnR.addActionListener(this);
        btnG.addActionListener(this);
        btnB.addActionListener(this);

        pnlN.add(btnR);
        pnlN.add(btnG);
        pnlN.add(btnB);

        pnlC = new JPanel();
        pnlC.setLayout(null);//pnlC 안에서만 작동되도록
        pnlC.addMouseListener(this);

        this.add(pnlN, "North");
        this.add(pnlC, "Center");
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==btnR) {
            c = Color.RED;
        } else if (e.getSource()==btnG) {
            c = Color.GREEN;
        } else if (e.getSource()==btnB) {
            c = Color.BLUE;
        }
    }

    public static void main(String[] args) {
        new MakeBox();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        sx = e.getX()-8;
        sy = e.getY()-31;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        JPanel pnl = new JPanel();
        int rx = e.getX();
        int ry = e.getY();

        if (rx<sx && ry<sy) {//밑에서 위로 드래그
            pnl.setBounds(rx-8, ry-31, (sx+8)-(rx-8), (sy+31)-(ry-31));
            pnl.setBackground(c);
            pnlC.add(pnl);
            pnlC.repaint();//pnlC안에서 생성되는 거니까 pnlC를 새로고침
            pnlC.revalidate();
        } else {//위에서 밑으로 드래그
            pnl.setBounds(sx, sy, rx-sx, ry-sy);
            pnl.setBackground(c);
            pnlC.add(pnl);
            pnlC.repaint();//pnlC안에서 생성되는 거니까 pnlC를 새로고침
            pnlC.revalidate();
        }
    }
}