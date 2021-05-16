import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ChangeSentence extends JFrame implements MouseListener {//p429 따라 만들기
    JLabel lb;
    public ChangeSentence() {
        this.setDefaultCloseOperation(3);
        this.setSize(400, 100);

        lb = new JLabel("Don't cry before you are hurt.");
        lb.setFont(new Font(Font.SERIF, Font.ITALIC, 30));//글씨체, 글씨형태, 글씨크기
        lb.setHorizontalAlignment(JLabel.CENTER);//레이블 글씨 가운데 정렬

        this.addMouseListener(this);

        this.add(lb);
        this.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (lb.getText().equals("Don't cry before you are hurt.")) {
            lb.setText("다치기도 전에 울지말라");
        } else {
            lb.setText("Don't cry before you are hurt.");
        }
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
        new ChangeSentence();
    }
}
