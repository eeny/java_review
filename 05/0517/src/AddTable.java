import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
// 혼자서는 모양만, 기능은 선생님 답안 보고 구현함
public class AddTable extends JFrame implements ActionListener, MouseListener {
    JTable tbl;
    JTextField tfNum, tfId, tfPw, tfName;
    JButton btn, btn2;

    DefaultTableModel model;
    int selectedRow = -1;

    public AddTable() {
        this.setDefaultCloseOperation(3);
        this.setSize(550, 300);

        String[] header = {"번호", "아이디", "비밀번호", "이름"};
        String[][] contents = {};
        // tbl = new JTable(contents, header);
        model = new DefaultTableModel(contents, header);
        tbl = new JTable(model);

        tbl.addMouseListener(this);// 마우스 이벤트

        JScrollPane sp = new JScrollPane(tbl);

        JPanel pnlSouth = new JPanel();
        tfNum = new JTextField(8);
        tfId = new JTextField(8);
        tfPw = new JTextField(8);
        tfName = new JTextField(8);
        btn = new JButton("추가");
        btn.addActionListener(this);// 액션 이벤트
        btn2 = new JButton("삭제");
        btn2.addActionListener(this);// 액션 이벤트
        pnlSouth.add(tfNum);
        pnlSouth.add(tfId);
        pnlSouth.add(tfPw);
        pnlSouth.add(tfName);
        pnlSouth.add(btn);
        pnlSouth.add(btn2);

        this.add(sp);
        this.add(pnlSouth, "South");
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==btn) {
            // 행 추가
            String[] str = new String[4];// 한 행에 들어갈 내용이 4개니까
            str[0] = tfNum.getText();
            str[1] = tfId.getText();
            str[2] = tfPw.getText();
            str[3] = tfName.getText();
            model.addRow(str);

        } else if (e.getSource()==btn2) {
            // 행 삭제
            if (selectedRow==-1 || tbl.getRowCount()==0) {
                JOptionPane.showMessageDialog(this, "선택된 행이 없습니다!");
            } else {
                model.removeRow(selectedRow);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // 선택한 행 번호 담기
        selectedRow = tbl.getSelectedRow();
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
        new AddTable();
    }
}
