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

public class JTableEx4 extends JFrame implements ActionListener, MouseListener {
    JTable tbl;
    JTextField tf1, tf2, tf3, tf4;
    JButton btn, btn2;// 추가, 제거 버튼
    JPanel pnl;

    DefaultTableModel model;// Action 때 쓰려고 뺐다!
    int selectedRow = -1;// getSelectedRow() 해서 선택한 행이 없으면 -1

    public JTableEx4() {
        this.setDefaultCloseOperation(3);
        this.setSize(550, 500);

        String[] header = {"번호", "아이디", "비밀번호", "이름"};
        String[][] contents = {};// 빈 값으로 초기화 - new와 같음

        // tbl = new JTable(contents, header);

        // JTable만 가지고 할 수 있는 일
        // 특정 셀의 값 변경
        // 특정 셀의 값 가져오기
        // 행 추가 X => 데이터 추가 X
        // 왜 불가능? 배열의 문제! 배열은 처음 크기 설정 이후로 배열의 크기를 늘릴 수 없다!
        // 그래서~ 테이블 전용으로 생성된 이후에도 값을 추가할 수 있는
        // DefaultTableModel 이라는 클래스가 있다!

        model = new DefaultTableModel(contents, header);
        tbl = new JTable(model);
        // 원래 테이블을 만들 때 바로 배열을 매개 변수로 줬지만
        // 생성 이후에 값을 (행 단위로) 넣고 빼기 위해서 배열을 모델에 담고 모델로 테이블을 생성한다!

        tbl.addMouseListener(this);// 테이블에 이벤트 달기!

        JScrollPane sp = new JScrollPane(tbl);
        this.add(sp);

        pnl = new JPanel();
        tf1 = new JTextField(8);
        tf2 = new JTextField(8);
        tf3 = new JTextField(8);
        tf4 = new JTextField(8);
        btn = new JButton("추가");
        btn2 = new JButton("삭제");
        btn.addActionListener(this);
        btn2.addActionListener(this);
        pnl.add(tf1);
        pnl.add(tf2);
        pnl.add(tf3);
        pnl.add(tf4);
        pnl.add(btn);
        pnl.add(btn2);

        this.add(pnl, "South");
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new JTableEx4();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==btn) {
            // 입력칸의 내용을 가져와서
            // contents의 행 배열 크기에 맞게 배열을 만들어서 추가 할 수 있다!
            String[] str = new String[4];
            str[0] = tf1.getText();
            str[1] = tf1.getText();
            str[2] = tf1.getText();
            str[3] = tf1.getText();
            model.addRow(str);

        } else if (e.getSource()==btn2) {
            // 삭제 처리 - 행 단위
            // 내가 선택한 줄이 반드시 필요하다!
            // model.removeRow(tbl.getSelectedRow());// 직접 처리도 가능하다!
            if (selectedRow == -1 || tbl.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "선택된 행이 없음");
            } else {
                model.removeRow(selectedRow);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        selectedRow = tbl.getSelectedRow();// 선택한 줄 번호 가져오기
        System.out.println(selectedRow);
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
