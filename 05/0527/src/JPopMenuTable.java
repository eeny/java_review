import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JPopMenuTable extends JFrame implements ActionListener, MouseListener {
    JTable tbl;
    DefaultTableModel model;
    JMenuItem item1, item2;
    JPopupMenu popmenu;
    int row = -1;// 테이블을 선택하지 않았을 때 원래 기본값이 -1이다!

    public JPopMenuTable() {
        this.setDefaultCloseOperation(3);
        this.setSize(500, 500);
        String[] header = {"제목", "저자"};
        String[][] contents = {
                {"aaa", "111"},
                {"bbb", "222"},
                {"ccc", "333"}
        };
        model = new DefaultTableModel(contents, header);
        tbl = new JTable(model);
        JScrollPane sp = new JScrollPane(tbl);

        tbl.addMouseListener(this);

        this.add(sp);

        popmenu = new JPopupMenu();
        item1 = new JMenuItem("삭제");
        item2 = new JMenuItem("추가");
        item1.addActionListener(this);
        item2.addActionListener(this);
        popmenu.add(item1);
        popmenu.add(item2);

        tbl.setComponentPopupMenu(popmenu);

        this.setVisible(true);
    }

    public static void main(String[] args) {
        new JPopMenuTable();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==item1) {
            System.out.println("삭제");
            model.removeRow(row);// 미리 선택된 줄 번호를 이용해서 삭제!

        } else if (e.getSource()==item2) {
            System.out.println("추가");
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // JTable을 클릭하면 실행됨
        // popmenu.show(invoker, x, y);
        // 어디에 뜨는지, x좌표, y좌표
        popmenu.show(this, e.getX()+10, e.getY()+50);// 내가 마우스 클릭한 곳 근처에 떠라!
        // 여기는 순수하게 팝업창을 띄우는 것 까지!
        row = tbl.getSelectedRow();// 내가 선택한 줄 번호를 전역변수 row에 담는다.
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
