import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class JTableEx3 extends JFrame implements MouseListener {
    JTable table;

    public JTableEx3() {
        this.setDefaultCloseOperation(3);
        this.setSize(500, 500);

        String header[] = {"이름", "국어", "영어", "수학"};
        String contents[][] = {
                {"김똘똘", "100", "100", "95"},
                {"박똘똘", "90", "100", "85"},
                {"최똘똘", "75", "60", "80"}
        };

        table = new JTable(contents, header);
        table.addMouseListener(this);
        JScrollPane sp = new JScrollPane(table);
        this.add(sp);

        this.setVisible(true);
    }

    public static void main(String[] args) {
        new JTableEx3();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int row = table.getSelectedRow();// 선택한 줄
        int column = table.getSelectedColumn();// 선택한 열
        System.out.println(table.getValueAt(row, column));
    }

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}
}
